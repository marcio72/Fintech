package br.com.fiap.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.UsuarioDAOImpl;


@WebServlet("/EditarCadastro")
public class EditarCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int codigo = Integer.parseInt(request.getParameter("id"));
		
		/*UsuarioDAOImpl usuarioDAO = new  UsuarioDAOImpl();
		Usuario usuario = usuarioDAO.buscarPorCodigo(codPess);
		request.setAttribute("usuario", usuario); */
		
		request.setAttribute("usuario", new  UsuarioDAOImpl().buscarPorCodigo(codigo));
		request.getRequestDispatcher("editarcad.jsp").forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}