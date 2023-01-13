package servlets;

import java.io.IOException;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Consultas; 

/**
 * Servlet implementation class ServletDevolver
 */
@WebServlet(name = "ServletDevolver", urlPatterns = {"/ServletDevolver"})
public class ServletDevolver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Consultas db = new Consultas();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDevolver() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		request.getSession().setAttribute("devoluciones", db.devoluciones());
		request.getRequestDispatcher("devoluciones.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
