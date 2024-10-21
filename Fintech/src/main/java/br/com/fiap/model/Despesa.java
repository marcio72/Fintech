package br.com.fiap.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

public class Despesa extends Dadosfinanceiro implements Serializable{
	private static final long serialVersionUID = 1L;
    private String descDespesa; 
    private int codDesp;
    
    
    
   	public Despesa(String dataCadastro,  double valor, String descDespesa, int codDesp) {	
   		super(dataCadastro, valor);
   		this.descDespesa = descDespesa;	
   		this.codDesp = codDesp;
   	}
	
    public int getCodDesp() {
		return codDesp;
	}


	public void setCodDesp(int codDesp) {
		this.codDesp = codDesp;
	}


	public Despesa() {	
    }
    
   
	public String getDescDespesa() {
		return descDespesa;
	}


	public void setDescDespesa(String descDespesa) {
		this.descDespesa = descDespesa;
	}
	

}
