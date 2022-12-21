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

/**
 * Servlet implementation class ServletNuevaCuenta
 */
@WebServlet("/ServletNuevaCuenta")
public class ServletNuevaCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<String> nomProhibidos = new ArrayList<String>(Arrays.asList("Juan", "Alfredo", "Jon"));
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html"); 
	    PrintWriter out = response.getWriter(); 
	    String titular = request.getParameter("titular");
	    if (nomProhibidos.contains(titular)) {
	    	getServletContext().setAttribute("error","no puede crear cuentas");
	    	request.getRequestDispatcher("nuevacuenta.jsp").forward(request, response);
		}
	    out.println(request.getParameter("titular"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
