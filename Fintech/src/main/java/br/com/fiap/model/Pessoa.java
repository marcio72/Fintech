package br.com.fiap.model;

public class Pessoa {
	protected String nomUsuario;
	protected String sobreNome;
	protected String cpf;
	protected String rg;
	protected int codPess;
	protected String pre;
	
	public Pessoa() {	
	}
	
	public Pessoa (String nomUsuario, String sobreNome, String cpf, String rg, int codPess, String pre) {
		this.nomUsuario = nomUsuario;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.rg = rg;
		this.codPess = codPess;
		this.pre = pre;
		
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getSobreNome() {
		return sobreNome;
		
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	public int getCodPess() {
		return codPess;
	}

	public void setCodPess(int codPess) {
		this.codPess = codPess;
	}

	public String getPre() {
		return pre;
	}

	public void setPre(String pre) {
		this.pre = pre;
	}
	

}

