package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletNuevaCuenta
 */
@WebServlet("/ServletNuevaCuenta")
public class ServletNuevaCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<String> nomProhibidos = new ArrayList<String>(Arrays.asList("Juan", "Alfredo", "Jon"));
    private ArrayList<String> listaErrores = new ArrayList<String>(Arrays.asList("El titular se encuentra en la blacklist.", "No se puede crear una cuenta con saldo negativo.", "El titular no puede estar vacio"));
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNuevaCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html"); 
	    PrintWriter out = response.getWriter(); 
	    String titular = request.getParameter("titular"); 
	    int saldo = Integer.valueOf(request.getParameter("saldoIni")); 
	    if (nomProhibidos.contains(titular)) { 
	    	session.setAttribute("sListaErrores",listaErrores.get(0)); 
	    	response.sendRedirect("nuevacuenta.jsp");
	    	
		}
	    if(saldo < 0) {
	    	session.setAttribute("sListaErrores",listaErrores.get(1));  
	    	response.sendRedirect("nuevacuenta.jsp");
		}
	    if(titular.length() <= 0) {
	    	session.setAttribute("sListaErrores",listaErrores.get(2)); 
	    	response.sendRedirect("nuevacuenta.jsp");
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
