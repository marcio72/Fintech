package br.com.fiap.model;

import java.sql.Date;
import java.time.LocalDate;

public class Dadosfinanceiro {
	private String dataFin; 
	//private LocalDate dataFin;
	private double valor; 
	private Categoria categoria;
	
	Usuario u1 = new Usuario();
	
	public Dadosfinanceiro() {
	}
	
	public Dadosfinanceiro(String dataFin,  double valor) {
		this.setDataFin(dataFin);
		this.setValor(valor);
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getU1() {
		return u1;
	}

	public void setU1(Usuario u1) {
		this.u1 = u1;
	}

	public String getDataFin() {
		return dataFin;
	}

	public void setDataFin(String datafin) {
		this.dataFin = datafin;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
	
}

