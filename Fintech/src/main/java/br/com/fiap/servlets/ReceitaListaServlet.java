package br.com.fiap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.ReceitaDAOImpl;
import br.com.fiap.model.Receita;


@WebServlet("/ReceitaListaServlet")
public class ReceitaListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReceitaListaServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		//String acao = request.getParameter("acao");
		ReceitaDAOImpl receitadao = new ReceitaDAOImpl();
		
		List<Receita> recLista =  receitadao.listaTodaReceita(); 
		request.setAttribute("receitas", recLista);
		request.getRequestDispatcher("listareceita.jsp").forward(request, response);
			
		/*switch (acao) {
			case "listar":
				List<Receita> recLista =  receitadao.listaTodaReceita(); 
				request.setAttribute("receitas", recLista);
				request.getRequestDispatcher("listareceita.jsp").forward(request, response);
				break;
				
			case "abrir-form-edicao":
				int id = Integer.parseInt(request.getParameter("codigo"));
				Receita receita =  receitadao.buscarPorCodigo(id);
				request.setAttribute("receita", receita);
				request.getRequestDispatcher("receitaedicao.jsp").forward(request, response);
					} */
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
