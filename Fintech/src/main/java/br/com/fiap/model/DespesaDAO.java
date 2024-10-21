package br.com.fiap.model;

import java.util.List;

public interface DespesaDAO {

	void grav (Despesa despesa);
	
	List <Despesa> listaTodaDespesa();
	
	Despesa buscarPorCodigo(int id);
	
	void atualizar (Despesa despesa);
	
	void remover (int codExcluir);
	
	Despesa valorDespesas (double despValId);

}
