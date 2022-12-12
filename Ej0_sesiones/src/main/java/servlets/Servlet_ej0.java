package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_ej0
 */
@WebServlet("/")
public class Servlet_ej0 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String[] arrOpciones = {"Guerra y paz","La guerra olvidada","Un pueblo abandonado"};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_ej0() { 
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// Creamos la session
		HttpSession session = request.getSession();
		response.setContentType("text/html"); 
	    PrintWriter out = response.getWriter(); 
	    try {
		    out.println("<html>");  
		    out.println("<head><title>Session Tracking Test</title></head>");
		    out.println("<body>");
		    out.println("<h1>EJER0 SESIONES</h1>");
		    out.println ("<form action=\"#\" method=\"get\">\r\n"
		    		+ "<select name=\"select\">\r\n"); 
		    for (int i = 0; i < arrOpciones.length; i++) {
		    	// Comprobamos si ya esta seleccionado algun valor de antes y lo ponemos como seleccionado si es asi.
		    	if (request.getParameter("btn") != null && request.getParameter("select").equals(arrOpciones[i])) {
		    		out.println ("<option value=\""+ arrOpciones[i] +"\" selected>"+ arrOpciones[i] +"</option>");
		    	}else {
					out.println ("<option value=\""+ arrOpciones[i] +"\">"+ arrOpciones[i] +"</option>");
				}
		    	
			}
		    out.println ("</select>"
		    		+ "<input type=\"submit\" name=\"btn\" value=\"AGREGAR\">\r"
		    		+ "<input type=\"submit\" name=\"borrar\" value=\"BORRAR SESSION\">\n"
		    		+ "</form>"); 
		    if (request.getParameter("borrar") != null) {  
		    	session.invalidate();
		    	out.println("<p style='color:green;'>SESSION BORRADA</p>");
		    	
			}else if (request.getParameter("btn") != null) {	// Si hemos clickado en el submit y enviado el formulario  
			    if (session.getAttribute("sLibros") == null) {
			    	ArrayList<String> arrL = new ArrayList<String>(); 
					arrL.add((String) request.getParameter("select"));
					session.setAttribute("sLibros", arrL);
				}else {
					// Comprobamos que no este ya en el Array
					ArrayList<String> sArrL = (ArrayList<String>) session.getAttribute("sLibros");
					String tituloLibro = (String) request.getParameter("select");
					if (!sArrL.contains(tituloLibro)) {
						sArrL.add(tituloLibro);
					}else {
						out.println("<p style='color:red;'>ERROR: El libro \"" + tituloLibro + "\" ya se encuentra seleccinado.</p>");
					}
					 
				}
			    // Procedemos a recorrer la session
			    out.println("<p>Tu eleccion</p>"
			    		+ "<ul>");
			    ArrayList<String> sArrL = (ArrayList<String>) session.getAttribute("sLibros");
				for (String titulo : sArrL) {
					out.println("<li>"
							+ titulo
							+ "</li>");
				}
				out.println("</ul>");
			}else {
				// Si ya hay libros en session los mostramos si no mensaje.
				if (session.getAttribute("sLibros") != null) {
					// Procedemos a recorrer la session
				    out.println("<p>Tu eleccion</p>"
				    		+ "<ul>");
				    ArrayList<String> sArrL = (ArrayList<String>) session.getAttribute("sLibros");
					for (String titulo : sArrL) {
						out.println("<li>"
								+ titulo
								+ "</li>");
					}
					out.println("</ul>");
				
				}else {
					out.println("<p>No se han elegido libros</p>");  
				}
				
			}
		    
	    }
	    finally {
	    	out.println("</body></html>");  
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
	}

}
