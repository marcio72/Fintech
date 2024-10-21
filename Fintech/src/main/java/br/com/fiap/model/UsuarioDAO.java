package br.com.fiap.model;

import java.util.List;

public interface UsuarioDAO {
	
	void gravar (Usuario usuario);
	
	List <Usuario> buscarTodos();
	
	Usuario buscarPorCodigo(int codigo);
	
	void atualizar (Usuario usuario);
	
	void remover (int codigo);
	
	Usuario confLogin (String emial, String senha);
	
}
