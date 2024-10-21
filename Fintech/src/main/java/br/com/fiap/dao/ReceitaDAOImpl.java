package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Categoria;
import br.com.fiap.model.Dadosfinanceiro;
import br.com.fiap.model.Receita;
import br.com.fiap.model.ReceitaDAO;
import br.com.fiap.model.Usuario;

public class ReceitaDAOImpl implements ReceitaDAO  {
	private Connection conexao;
	
	PreparedStatement pstmt = null;
	
	public void gravar (Receita receita) {
		conexao = ConexaoDB.obterConexao();
		ReceitaDAO dao = new ReceitaDAOImpl();
		
		try {
			conexao = ConexaoDB.obterConexao();
			pstmt = conexao.prepareStatement ("INSERT INTO T_Receita (COD_RECEITA, DESC_RECEITA, DAT_RECEITA, VAL_RECEITA, COD_CATEGORIA, COD_USUARIO )"
				      + " VALUES (SQ_COD_RECEITA.nextval, ?, ?, ?, ?, ? )");
			pstmt.setString(1, receita.getDescReceita());
			 //LocalDate dataCadastro = LocalDate.parse(receita.getDataFin(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			//Date data = Date.valueOf(receita.getDataFin());
			pstmt.setString(2, receita.getDataFin()); //(2, receita.getDataFin());
			pstmt.setDouble(3, receita.getValor());
			pstmt.setInt(4, receita.getCategoria().getCodCateg());
			pstmt.setInt(5, receita.getCodRec()); //receita.getU1().getCodUsuario());
			pstmt.executeUpdate();
			pstmt.close();
			
			}catch(SQLException erro) {
				erro.printStackTrace();
			}	
	}
	

	public List <Receita> listaTodaReceita(){
		List<Receita> listaReceita = new ArrayList<Receita>();
		ResultSet rs = null;
		//int codusu = 9;
		ReceitaDAO dao = new ReceitaDAOImpl();
		try {
			conexao = ConexaoDB.obterConexao();
			pstmt = conexao.prepareStatement ("SELECT * FROM T_receita INNER JOIN T_categoria "
					+ "ON T_receita.cod_categoria = T_categoria.cod_categoria ORDER BY T_categoria.cod_categoria ");
			//WHERE t_receita.cod_usuario = ? 
			//pstmt.setInt(1, codusu);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
					int codRec = rs.getInt("cod_receita");
					String descReceita = rs.getString("desc_receita");
					String dataCadastro = rs.getString("dat_receita");
					Double valor = rs.getDouble("val_receita");
					int codUsuario = rs.getInt("cod_usuario");
					
					int codCateg = rs.getInt("Cod_Categoria");
					String descCateg = rs.getString("Desc_Categoria");
					
					//String dataCadastro, double valor, String descReceita, int codRec
					
					Receita receita = new Receita (dataCadastro, valor, descReceita, codRec);
					Categoria categoria =  new Categoria(codCateg, descCateg);
					receita.setCategoria(categoria);
				
					
					//String dataCadastro, double valor
					listaReceita.add(receita);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaReceita;
		
		
	}		
	
	
	
	public Receita buscarPorCodigo(int id) {
		
		Receita buscaReceita = new Receita();
		ResultSet rs = null;
	
		ReceitaDAO dao = new ReceitaDAOImpl();
		try {
			conexao = ConexaoDB.obterConexao();
			pstmt = conexao.prepareStatement ("SELECT * FROM T_receita INNER JOIN T_categoria "
					+ "ON T_receita.cod_categoria = T_categoria.cod_categoria WHERE t_receita.cod_receita = ?");
			//WHERE t_receita.cod_receita = ?  AND  t_receita.cod_usuario = ?
			/* pstmt.setInt(1,  id);
			   pstmt.setInt(2,  id);  */
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int codRec = rs.getInt("cod_receita");
				String descReceita = rs.getString("desc_receita");
				String dataCadastro = rs.getString("dat_receita");
				Double valor = rs.getDouble("val_receita");
				int codUsuario = rs.getInt("cod_usuario");
				
				int codCateg = rs.getInt("Cod_Categoria");
				String descCateg = rs.getString("Desc_Categoria");
					
					Receita receita = new Receita (dataCadastro, valor, descReceita, codRec);
					Categoria categoria =  new Categoria(codCateg, descCateg);
					receita.setCategoria(categoria);
					
					return receita;

				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buscaReceita;
	}
	
	public void atualizar (Receita receita) {
		ReceitaDAO dao = new ReceitaDAOImpl();
		Receita codigoReceita = new Receita();
		ResultSet result = null;
		try {
			conexao = ConexaoDB.obterConexao();
			pstmt = conexao.prepareStatement ("UPDATE T_receita SET desc_receita = ?, "
																+ "	dat_receita = ?, "
																+ "	val_receita = ?, "
																+ "	cod_usuario = ?, "
																+ "	Cod_Categoria = ? WHERE t_receita.cod_receita = ? ");
			pstmt.setString(1, receita.getDescReceita());
			pstmt.setString(2, receita.getDataFin());
			pstmt.setDouble(3, receita.getValor());
			pstmt.setInt(4, receita.getU1().getCodUsuario());
			pstmt.setInt(5, receita.getCategoria().getCodCateg());
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			}
		}
	
	
	public void remover (int codExcluir)  {
		ReceitaDAO dao = new ReceitaDAOImpl();
		conexao = ConexaoDB.obterConexao();
		try {
		pstmt = conexao.prepareStatement ("DELETE FROM T_receita WHERE cod_receita = ?");
		pstmt.setInt(1, codExcluir);
		pstmt.executeUpdate();
		
		}catch(SQLException erro) {
			erro.printStackTrace();
		}finally {
		}	try {
			pstmt.close();
			conexao.close();
		}catch(Exception erro) {
			erro.printStackTrace();
		}
	}
	
	public Receita valorReceitas (double recValId) {
		return null;
	}
}
