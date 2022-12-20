package servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;

/**
 * Servlet implementation class ServletPrepararProductos
 */
//@WebServlet(name = "/ServletPrepararProductos", urlPatterns = {"/*","/ServletPrepararProductos"})
public class ServletPrepararProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrepararProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		response.setContentType("text/html"); 
	    PrintWriter out = response.getWriter(); 
	    // Declaraciones
	    HttpSession session = request.getSession();
	    String nomFich = getServletConfig().getInitParameter("nomFich");
	    // Comprobaciones
		if (request.getParameter("categ") != null && !request.getParameter("categ").isEmpty()) {
			boolean todoBn = false;
			String categoria = request.getParameter("categ");
			HashMap<String, ArrayList<String>> mapa = new HashMap<String, ArrayList<String>>();
			ArrayList<String> arrProductos = new ArrayList<String>();
			// Recorremos el fichero y vamos añadiendo los productos de la misma categoria en un array.
			try (BufferedReader br = new BufferedReader(new FileReader(getServletContext().getRealPath(nomFich)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] partes = line.split(";");
                    if (categoria == partes[0]) {
						todoBn = true;
						arrProductos.add(partes[1]);
					}
                    
                }
                // Metemos en session el mapa y redireccionamos.
                if (todoBn) {
                	mapa.put(categoria, arrProductos);
                	session.setAttribute("sMapa", mapa);
//                	request.getRequestDispatcher("/compra.jsp").forward(request, response);
                	response.sendRedirect("/compra.jsp");
				}else {
					session.setAttribute("sMapa", null);
				}
                
            }catch (IOException e) {
                e.printStackTrace();
            }
		}else {
			HashMap<String, ArrayList<String>> mapa = new HashMap<String, ArrayList<String>>();
			ArrayList<String> arrProductos = new ArrayList<String>();
			try (BufferedReader br = new BufferedReader(new FileReader(getServletContext().getRealPath(nomFich)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] partes = line.split(";");  
					arrProductos.add(partes[1]);
				}   
                // Metemos en session el mapa y redireccionamos. 
                mapa.put("todo", arrProductos);
                session.setAttribute("sMapa", mapa); 
                request.getRequestDispatcher("/compra.jsp").include(request, response);
            }catch (IOException e) {
                e.printStackTrace();
            }
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
