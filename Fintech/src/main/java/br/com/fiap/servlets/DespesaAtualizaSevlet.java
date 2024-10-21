package br.com.fiap.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.DespesaDAOImpl;
import br.com.fiap.model.Despesa;


@WebServlet("/DespesaAtualizaServlet")
public class DespesaAtualizaSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DespesaAtualizaSevlet() {
    	
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("id"));
		
		DespesaDAOImpl despesadao = new DespesaDAOImpl ();
		
		Despesa despesa =  despesadao.buscarPorCodigo(codigo);
		request.setAttribute("despesa", despesa);
		request.getRequestDispatcher("despesaedicao.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
