package br.com.fiap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.DespesaDAOImpl;
import br.com.fiap.dao.ReceitaDAOImpl;
import br.com.fiap.model.Despesa;
import br.com.fiap.model.Receita;

@WebServlet("/DespesaListaServlet")
public class DespesaListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DespesaListaServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DespesaDAOImpl despesadao = new DespesaDAOImpl();
		
		List<Despesa> despLista =  despesadao.listaTodaDespesa(); 
		request.setAttribute("despesas", despLista);
		request.getRequestDispatcher("listadespesa.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
