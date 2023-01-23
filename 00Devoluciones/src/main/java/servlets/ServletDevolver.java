package servlets;

import java.io.IOException;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestorBD; 

/**
 * Servlet implementation class ServletDevolver
 */
@WebServlet(name = "ServletDevolver", urlPatterns = {"/ServletDevolver"})
public class ServletDevolver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestorBD db = new GestorBD();
       
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
		if (request.getParameter("idDevolucion") != null) {
			int id = Integer.parseInt(request.getParameter("idDevolucion"));
			if (request.getSession().getAttribute("marcados") == null ) {
				ArrayList<Integer> arrDev = new ArrayList<Integer>();
				arrDev.add(id);
				request.getSession().setAttribute("marcados", arrDev);
				request.getSession().setAttribute("contDev", 1);
			}else {
				ArrayList<Integer> arrDev = new ArrayList<Integer>();
				arrDev = ((ArrayList<Integer>) request.getSession().getAttribute("marcados"));
				int cant = 0;
				if (!arrDev.contains(id)) {
					arrDev.add(id);
					if (request.getSession().getAttribute("contDev") != null) {
						cant = (Integer) request.getSession().getAttribute("contDev");
					} 
					cant++;
					request.getSession().setAttribute("contDev", cant);
				}
				request.getSession().setAttribute("marcados", arrDev);
				
			}
		}else if(request.getParameter("idRevertir") != null){
			int idRev = Integer.parseInt(request.getParameter("idRevertir")) ;
			ArrayList<Integer> arrDev = new ArrayList<Integer>();
			arrDev = ((ArrayList<Integer>) request.getSession().getAttribute("marcados"));
			arrDev.remove((Object) idRev);
			request.getSession().setAttribute("marcados", arrDev);
			int cant = (Integer) request.getSession().getAttribute("contDev");
			if (cant == 0) {
				request.getSession().setAttribute("contDev", null);
			}else {
				cant--;
				request.getSession().setAttribute("contDev", cant);
			}
			
		}else if(request.getParameter("grabarDev") != null) {
			ArrayList<Integer> arrDev = new ArrayList<Integer>();
			arrDev = ((ArrayList<Integer>) request.getSession().getAttribute("marcados"));
			for (Integer idElim : arrDev) {
				db.grabarDevolucion(idElim);
			}
			arrDev.clear();
			request.getSession().setAttribute("marcados", arrDev);
			request.getSession().setAttribute("contDev", null);
			request.getSession().setAttribute("devoluciones", db.prestamos());
		}else {
			request.getSession().setAttribute("devoluciones", db.prestamos());
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
