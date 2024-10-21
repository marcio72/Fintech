package br.com.fiap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.CategoriaDAOImpl;
import br.com.fiap.dao.DespesaDAOImpl;
import br.com.fiap.dao.ReceitaDAOImpl;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.CategoriaDAO;
import br.com.fiap.model.Despesa;
import br.com.fiap.model.Receita;


@WebServlet("/DespesaServlet")
public class DespesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DespesaServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DespesaDAOImpl dao = new DespesaDAOImpl();
		CategoriaDAOImpl categoriadao = new CategoriaDAOImpl();
		
		List<Categoria> listarec =  categoriadao.lista();
		request.setAttribute("categorias", listarec);
		request.getRequestDispatcher("DespesaCadastro.jsp").forward(request, response);	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DespesaDAOImpl dao = new DespesaDAOImpl();
		CategoriaDAO categoriadao = new CategoriaDAOImpl();
		
		try {
			String desc = request.getParameter("descricao");
			double valor = Double.parseDouble( request.getParameter("valor"));
			/*
			String dataCadastroString = request.getParameter("dataCadastro");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //O formato do input date HTML
            
            System.out.println("dataCadastro: " + dataCadastroString);
            LocalDate dataCadastro = LocalDate.parse(dataCadastroString, formatter);
            System.out.println("Data recebida do formulário: " + dataCadastroString); */
            
            String dataCadastro = request.getParameter("dataCadastro");
            int codigocategoria =  Integer.parseInt(request.getParameter("categoria"));
            Categoria categoria = new Categoria();
            categoria.setCodCateg(codigocategoria);           
            int codigo =  Integer.parseInt(request.getParameter("codigo"));
            
            Despesa despesa = new Despesa( dataCadastro, valor, desc, codigo ); 
			despesa.setCategoria(categoria);
			
			dao.grav(despesa);
			request.setAttribute("msg","Despesa Cadastrada com sucesso. !! ");
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","cadastro nao efetuado. !! ");
		}
		request.getRequestDispatcher("DespesaCadastro.jsp").forward(request, response);
		
		//request.getRequestedSessionId()
	}
		
	}


