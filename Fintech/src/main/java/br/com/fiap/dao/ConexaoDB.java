package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDB {
	
	public static Connection obterConexao() {
		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(
					  "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","rm550869","090172");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}
