package br.com.fiap.model;

import java.util.List;

public interface ReceitaDAO {
	
	
void gravar (Receita receita);
	
	//List <Receita> listaTodaReceita(int codigo);
	List <Receita> listaTodaReceita();
	
	Receita buscarPorCodigo(int id);
	
	void atualizar (Receita receita);
	
	void remover (int codExcluir);
	
	Receita valorReceitas (double recValId);
	


}