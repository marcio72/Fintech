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

@WebServlet("/NovoUsuario")
public class NovoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NovoUsuario() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cad_usuario.jsp").forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO dao = new UsuarioDAOImpl();
		List<Usuario> listaUsuario = dao.buscarTodos();
		request.setAttribute("listaUsuario", listaUsuario);
		request.getRequestDispatcher("listausuarios.jsp").forward(request, response);
	}

}
