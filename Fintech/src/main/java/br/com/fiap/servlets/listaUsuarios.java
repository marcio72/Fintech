package br.com.fiap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.UsuarioDAOImpl;
import br.com.fiap.model.Usuario;
import br.com.fiap.model.UsuarioDAO;


@WebServlet("/listaUsuarios")
public class listaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public listaUsuarios() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Servlet listadeUsuario está sendo chamado.");
		
		Usuario usuario = new Usuario();
		
		UsuarioDAO dao = new UsuarioDAOImpl();
		List<Usuario> listaUsuario = dao.buscarTodos();
		request.setAttribute("listaUsuario", listaUsuario);
		request.getRequestDispatcher("listausuarios.jsp").forward(request, response);	
	}
}
