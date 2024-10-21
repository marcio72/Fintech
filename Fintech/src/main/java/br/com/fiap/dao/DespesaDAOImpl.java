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
import br.com.fiap.model.Despesa;
import br.com.fiap.model.DespesaDAO;
import br.com.fiap.model.Receita;
import br.com.fiap.model.ReceitaDAO;
import br.com.fiap.model.Usuario;

public class DespesaDAOImpl implements DespesaDAO{
    private Connection conexao;
    
	PreparedStatement pstmt = null;
	
	public void grav (Despesa despesa) {
		conexao = ConexaoDB.obterConexao();
		DespesaDAO dao = new DespesaDAOImpl();
		
		try {
			conexao = ConexaoDB.obterConexao();
			pstmt = conexao.prepareStatement ("INSERT INTO T_despesa (COD_despesa, DESC_despesa, DAT_despesa, VAL_despesa, COD_CATEGORIA, COD_USUARIO )"
				      + " VALUES (SQ_COD_despesa.nextval, ?, ?, ?, ?, ? )");
			pstmt.setString(1, despesa.getDescDespesa());
			 //LocalDate dataCadastro = LocalDate.parse(despesa.getDataFin(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			//Date data = Date.valueOf(despesa.getDataFin());
			pstmt.setString(2, despesa.getDataFin()); //(2, despesa.getDataFin());
			pstmt.setDouble(3, despesa.getValor());
			pstmt.setInt(4, despesa.getCategoria().getCodCateg());
			pstmt.setInt(5, despesa.getCodDesp());         //despesa.getU1().getCodUsuario());
			pstmt.executeUpdate();
			pstmt.close();
			
			}catch(SQLException erro) {
				erro.printStackTrace();
			}		
	}
	
	
	public List <Despesa> listaTodaDespesa(){
		List<Despesa> listaDespesa = new ArrayList<Despesa>();
		ResultSet rs = null;
		//int codusu = 9;
		DespesaDAO dao = new DespesaDAOImpl();
		try {
			conexao = ConexaoDB.obterConexao();
			pstmt = conexao.prepareStatement ("SELECT * FROM T_despesa INNER JOIN T_categoria "
					+ "ON T_despesa.cod_categoria = T_categoria.cod_categoria ORDER BY T_categoria.cod_categoria");
			//WHERE t_despesa.cod_usuario = ? 
			//pstmt.setInt(1, codusu);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
					int codDespesa = rs.getInt("cod_despesa");
					String descricao = rs.getString("desc_despesa");
					String dataDespesa = rs.getString("dat_despesa");
					Double valorDespesa = rs.getDouble("val_despesa");
					int codUsuario = rs.getInt("cod_usuario");
					
					int codCategoria = rs.getInt("Cod_Categoria");
					String descricaoCat = rs.getString("Desc_Categoria");
					
					Despesa despesa = new Despesa (dataDespesa, valorDespesa, descricao, codDespesa);
					Categoria categoria =  new Categoria(codCategoria, descricaoCat);
					despesa.setCategoria(categoria);
				
					listaDespesa.add(despesa);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDespesa;
	}
	
		
	public Despesa buscarPorCodigo(int id) {
		Despesa buscaDespesa = new Despesa();
		ResultSet rs = null;
	
		DespesaDAO dao = new DespesaDAOImpl();
		try {
			conexao = ConexaoDB.obterConexao();
			pstmt = conexao.prepareStatement ("SELECT * FROM T_despesa INNER JOIN T_categoria "
					+ "ON T_despesa.cod_categoria = T_categoria.cod_categoria WHERE t_despesa.cod_despesa = ?");
			//WHERE t_despesa.cod_despesa = ?  AND  t_despesa.cod_usuario = ?
			/* pstmt.setInt(1,  id);
			   pstmt.setInt(2,  id);  */
			
			pstmt.setInt(1,  id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
					int codDespesa = rs.getInt("cod_despesa");
					String descricao = rs.getString("desc_despesa");
					String dataDespesa = rs.getString("dat_despesa");
					Double valor = rs.getDouble("val_despesa");
					int codUsuario = rs.getInt("cod_usuario");
					
					int codCategoria = rs.getInt("Cod_Categoria");
					String descricaoCat = rs.getString("Desc_Categoria");
					
					Despesa despesa = new Despesa (dataDespesa, valor, descricao, codDespesa);
					Categoria categoria =  new Categoria(codCategoria, descricaoCat);
					despesa.setCategoria(categoria);
					
					return despesa;
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buscaDespesa;

	}
	
	
	


	public void atualizar (Despesa despesa) {
		
		DespesaDAO dao = new DespesaDAOImpl();
		Despesa codigoDespesa = new Despesa();
		ResultSet result = null;
		try {
			conexao = ConexaoDB.obterConexao();
			pstmt = conexao.prepareStatement ("UPDATE T_receita SET desc_despesa = ?, "
																+ "	dat_despesa = ?, "
																+ "	val_despesa = ?, "
																+ "	cod_usuario = ?, "
																+ "	Cod_Categoria = ? WHERE t_Despesa.cod_despesa = ? ");
			pstmt.setString(1, despesa.getDescDespesa());
			pstmt.setString(2, despesa.getDataFin());
			pstmt.setDouble(3, despesa.getValor());
			pstmt.setInt(4, despesa.getU1().getCodUsuario());
			pstmt.setInt(5, despesa.getCategoria().getCodCateg());
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			}
	}
	
	
	public void remover (int codExcluir) {
		DespesaDAO dao = new DespesaDAOImpl();
		conexao = ConexaoDB.obterConexao();
		try {
		pstmt = conexao.prepareStatement ("DELETE FROM T_despesa WHERE cod_Despesa = ?");
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
		
	public Despesa valorDespesas (double despValId) {
		return null;
	}
	}


