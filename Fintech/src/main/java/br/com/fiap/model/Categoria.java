package br.com.fiap.model;

public class Categoria {
	private int codCateg;
	private String descCateg;
	
	public Categoria () {
	}
	
	public Categoria (int codCateg, String descCateg) {
		this.codCateg = codCateg;
		this.descCateg = descCateg;
	}

	public int getCodCateg() {
		return codCateg;
	}

	public void setCodCateg(int codCateg) {
		this.codCateg = codCateg;
	}

	public String getDescCateg() {
		return descCateg;
	}

	public void setDescCateg(String descCateg) {
		this.descCateg = descCateg;
	}

}

