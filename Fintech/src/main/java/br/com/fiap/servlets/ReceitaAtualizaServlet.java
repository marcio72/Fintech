package br.com.fiap.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.ReceitaDAOImpl;
import br.com.fiap.model.Receita;


@WebServlet("/ReceitaAtualizaServlet")
public class ReceitaAtualizaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReceitaAtualizaServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("id"));
		
		ReceitaDAOImpl receitadao = new ReceitaDAOImpl();
		
		Receita receita =  receitadao.buscarPorCodigo(codigo);
		request.setAttribute("receita", receita);
		request.getRequestDispatcher("receitaedicao.jsp").forward(request, response);
		
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
