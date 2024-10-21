package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.model.Usuario;
import br.com.fiap.model.UsuarioDAO;


public  class UsuarioDAOImpl implements UsuarioDAO{
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	int pegcod, pegcod1;
	
	
	@Override
	public void gravar(Usuario usuario) {
		conexao = ConexaoDB.obterConexao();
		UsuarioDAO dao = new UsuarioDAOImpl();
		//System.out.println("Conectou.!!!");
		try {
		pstmt = conexao.prepareStatement ("INSERT INTO T_inf_usuario (cod_nome, nom_usuario, sobrenome, pre_nome, cpf, rg )"
			      + " VALUES (SQ_COD_NOME.nextval, ?, ?, ?, ?, ? )");
		pstmt.setString(1, usuario.getNomUsuario());
		pstmt.setString(2, usuario.getSobreNome());
		pstmt.setString(3, usuario.getPre());
		pstmt.setString(4, usuario.getCpf());
		pstmt.setString(5, usuario.getRg());
		pstmt.executeUpdate();
		pstmt.close();
		
		//pstmt1
		pstmt = conexao.prepareStatement ("INSERT INTO T_usuario (cod_usuario, email, telefone, senha )"
			      + " VALUES (SQ1_COD_USUARIO.nextval, ?, ? )");
		pstmt.setString(1, usuario.getEmail());
		pstmt.setString(2, usuario.getTelef());
		pstmt.setString(3, usuario.getSenha());
		pstmt.executeUpdate();
		pstmt.close();
		
		//pstmt2
		pstmt = conexao.prepareStatement ("SELECT cod_nome FROM T_inf_usuario ORDER BY cod_nome DESC FETCH first 1 ROWS ONLY ");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			pegcod = rs.getInt("cod_nome");
		}
		pstmt.close();
		
		//pstmt3
		pstmt = conexao.prepareStatement ("SELECT * FROM T_usuario ORDER BY cod_usuario DESC FETCH first 1 ROWS ONLY ");
		ResultSet rs1 = pstmt.executeQuery();
		
		while(rs1.next()) {
			pegcod1 = rs1.getInt("cod_usuario");
		}
		pstmt.close();
		
		//pstmt4
		pstmt = conexao.prepareStatement("UPDATE T_usuario SET cod_nome = ? where cod_usuario = ? ");
		pstmt.setInt(1, pegcod);
		pstmt.setInt(2, pegcod1);
		pstmt.executeUpdate();
		pstmt.close();
		
		pstmt = conexao.prepareStatement("UPDATE T_inf_usuario SET cod_usuario = ? where cod_nome = ? ");
		pstmt.setInt(1, pegcod1);
		pstmt.setInt(2, pegcod);
		pstmt.executeUpdate();
		dao.buscarPorCodigo(pegcod);
		//System.out.println("Registro gravando com sucesso.!!\n\n");
		pstmt.close();
		conexao.close();
		
		}catch(SQLException erro) {
			erro.printStackTrace();
		}
		
	}

	@Override
	public List<Usuario> buscarTodos() {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		ResultSet rs = null;
		try {
			conexao = ConexaoDB.obterConexao();
			pstmt = conexao.prepareStatement ("SELECT cod_nome, nom_usuario, sobrenome, pre_nome, rg, cpf, cod_usuario, email, telefone, senha "
			+ "FROM t_inf_usuario NATURAL JOIN t_usuario  ORDER BY nom_usuario ASC");
			//where nom_usuario LIKE ?
			//String cns = "M%";
			//pstmt.setString(1, cns);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getInt("cod_nome"),
											  rs.getString("nom_usuario").toUpperCase(),
											  rs.getString("sobrenome").toUpperCase(),
											  rs.getString("pre_nome").toUpperCase(),
											  rs.getString("rg"),
											  rs.getString("cpf"),
											  rs.getInt("cod_usuario"),
											  rs.getString("email"),
											  rs.getString("telefone"),
											  rs.getString("senha"));
				listaUsuario.add(usuario);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaUsuario ;
	}
	
	@Override
	public Usuario buscarPorCodigo(int codigo) {
		Usuario codigoUsuario = new Usuario();
		ResultSet result = null;
		try {
			conexao = ConexaoDB.obterConexao();
			pstmt = conexao.prepareStatement ("SELECT cod_nome, nom_usuario, sobrenome, pre_nome, rg, cpf, cod_usuario, email, telefone "
			+ "FROM t_inf_usuario NATURAL JOIN t_usuario WHERE cod_nome = ? ");
			pstmt.setInt(1, codigo);
			result = pstmt.executeQuery();
			
		while (result.next()) {
			int codPess = result.getInt("cod_nome");
			String nomUsuario = result.getString("nom_usuario").toUpperCase();
			String sobreNome = result.getString("sobrenome").toUpperCase();
			String pre = result.getString("pre_nome").toUpperCase();
			String rg =	result.getString("rg");
			String cpf = result.getString("cpf");
			int codUsuario = result.getInt("cod_usuario");
			String email = result.getString("email");
			String telef = result.getString("telefone");
			
			
		Usuario usuario = new Usuario(codPess,  nomUsuario, sobreNome, telef, rg, pre, codUsuario, cpf, email );
		return usuario;		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return codigoUsuario ;
	}

	@Override
	public void atualizar(Usuario usuario) {	
	}

	@Override
	public void remover(int codigo) {
		
	}
	
	public Usuario confLogin (String email, String senha){
		Usuario codigoUsuario = new Usuario();
		ResultSet result = null;
		try {
			conexao = ConexaoDB.obterConexao();
			pstmt = conexao.prepareStatement ("SELECT * T_usuario WHERE email = ?  AND senha = ? ");
			pstmt.setString(1, email );
			pstmt.setString(2, senha );
			result = pstmt.executeQuery();
			
			while (result.next()) {
				String emailU = result.getString("email");
				String senhaU = result.getString("senha");
				
				
			Usuario usuario = new Usuario( emailU, senhaU );
			return usuario;		
			}
		
		
		
		return null;
	}	catch(Exception erro) {
		erro.printStackTrace();
		}
		return codigoUsuario;
	}
}
