package br.com.fiap.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

public class Receita extends Dadosfinanceiro implements Serializable{
	private static final long serialVersionUID = 1L;
	private String descReceita;
	private int codRec; 
	
	
	public Receita(String dataCadastro, double valor, String descReceita, int codRec) {	
		super(dataCadastro, valor);
		this.descReceita = descReceita;	
		this.codRec = codRec;		
	}
	


	public int getCodRec() {
		return codRec;
	}

	public void setCodRec(int codRec) {
		this.codRec = codRec;
	}

	

	public Receita(){	
	}

	
	
	public String getDescReceita() {
		return descReceita;
	}

	public void setDescReceita(String descReceita) {
		this.descReceita = descReceita;
	}
	
	/*public void exibirDadodeEntrada(LocalDate dataFin, double valor, String descReceita) {
		System.out.println("Data:" + super.getDataFin() + " Valor:" + super.getValor() + " Descrição:" + descReceita);
	}
	
	public void exibirDadodeEntrada() {
		System.out.println("----- DADOS DA RECEITA ------");
		System.out.println("Data:" + super.getDataFin() + " Categoria:" + super.getDescCateg() + "\nValor:" + super.getValor() + " Descrição:" + descReceita);
	}*/

		

}
