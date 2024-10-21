package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.CategoriaDAO;
import br.com.fiap.model.ReceitaDAO;

public class CategoriaDAOImpl implements CategoriaDAO{
	
	Connection conexao = ConexaoDB.obterConexao();
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public List <Categoria> lista(){
		List<Categoria> lista = new ArrayList<Categoria>();
		ResultSet rs = null;
		conexao = ConexaoDB.obterConexao();
		//CategoriaDAO dao = new CategoriaDAOImpl();
		
		try {
			pstmt = conexao.prepareStatement ("SELECT * FROM T_Categoria order by Desc_categoria ASC");
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				int codigo = rs.getInt("Cod_Categoria");
				String desc = rs.getString("Desc_Categoria");
				Categoria categoria = new Categoria(codigo, desc);
				lista.add(categoria);
			}
			
			}catch(SQLException e) {
				e.printStackTrace();	
			}finally {
				try {
					pstmt.close();
					rs.close();
					conexao.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return lista;	
	}


	@Override
	public List<Categoria> listar() {
		return null;
	}

}
