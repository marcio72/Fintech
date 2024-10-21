package br.com.fiap.teste;

import java.sql.Connection;
import java.util.List;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Despesa;
import br.com.fiap.model.Receita;
import br.com.fiap.dao.CategoriaDAOImpl;
import br.com.fiap.dao.ConexaoDB;
import br.com.fiap.dao.DespesaDAOImpl;
import br.com.fiap.dao.ReceitaDAOImpl;

public class TesteMain {

	public static void main(String[] args) {
		
		/*CategoriaDAOImpl dao = new CategoriaDAOImpl();
        // Chama o método lista() para obter a lista de categorias
		List <Categoria> listas = dao.lista();
		for(Categoria categoria : listas) {
		System.out.println(categoria.getCodCateg() + "  - " + categoria.getDescCateg());*/
		
			
		/*ReceitaDAOImpl recDAO = new ReceitaDAOImpl();
			List<Receita> listas = recDAO.listaTodaReceita();
			for(Receita receita : listas) {
				System.out.println(receita.getCodRec()+ "  - " + receita.getDescReceita() + "  - " + receita.getValor()
						+ "  - " + receita.getDataFin() + "  - " + receita.getCategoria().getDescCateg()); */
				
				DespesaDAOImpl despDAO = new DespesaDAOImpl();
				List<Despesa> listas = despDAO.listaTodaDespesa();
				for(Despesa despesa : listas) {
					System.out.println(despesa.getCodDesp()+ "  - " + despesa.getDescDespesa() + "  - " + despesa.getValor()
							+ "  - " + despesa.getDataFin() + "  - " + despesa.getCategoria().getDescCateg());
		}
		
	}
}


