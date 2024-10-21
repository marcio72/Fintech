package br.com.fiap.model;

import java.io.Serializable;

public class Usuario extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	private String email;
	private String telef;
	private int codUsuario;
	private String senha;
	
	public Usuario (String email, String senha) {
		this.email = email;
		this.senha = senha;
		
	}
	
	public Usuario(
			 int codPess, 
			 String nomUsuario, 
			 String sobreNome, 
			 String telef, 
			 String rg, 
			 String pre,
			 int codUsuario,
			 String cpf, 
			 String email,
			 String senha) {
		super(nomUsuario, sobreNome, cpf, rg, codPess, pre);
		this.email = email;
		this.telef = telef;
		this.codUsuario = codUsuario;
		this.senha = senha;
	}
	
	public Usuario(
			 int codPess, 
			 String nomUsuario, 
			 String sobreNome, 
			 String telef, 
			 String rg, 
			 String pre,
			 int codUsuario,
			 String cpf, 
			 String email)
			 {
		super(nomUsuario, sobreNome, cpf, rg, codPess, pre);
		this.email = email;
		this.telef = telef;
		this.codUsuario = codUsuario;
		
	}
	
	
	public Usuario() {
	}
	public String getTelef() {
		return telef;	
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public void setTelef(String telef) {
		this.telef = telef;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [Codigo = " + getCodPess() + ",  "
				+ "Nome= " + getNomUsuario() + ",  "
				+ "Sobrenome = " + getSobreNome() + ",  "
				+ "Apelido = " +  getTelef()  + ",  "
				+ "email = " +  getCpf() + ",  "
				+ "CodigoConta = " +  getCodUsuario() + ",  "
				+ "rg= " + getRg()  + ",  "
				+ "Fone = " + getEmail() + ",  "
		        + "cpf= " + getPre() + " ]";
	}
}

