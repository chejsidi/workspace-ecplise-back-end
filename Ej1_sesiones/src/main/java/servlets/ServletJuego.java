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

import beans.AlmacenPalabras;

/**
 * Servlet implementation class ServletJuego
 */
@WebServlet(name="ServletJuego", urlPatterns="/")
public class ServletJuego extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJuego() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Declaraciones 
		HttpSession session = request.getSession();
		if (request.getParameter("deNuevo") != null) { 
			session.invalidate();
			session = request.getSession();
		}    
		ArrayList<Integer> posicionesAdivinadas = new ArrayList<Integer>();
		ArrayList<String> historial = new ArrayList<String>();  
		int vidas; 
		if (session.getAttribute("sHistorial") != null) { 
			historial = (ArrayList<String>) session.getAttribute("sHistorial");
		}else {
			session.setAttribute("sHistorial", historial);
		} 
		if (session.getAttribute("sPosiciones") != null) { 
			posicionesAdivinadas = (ArrayList<Integer>) session.getAttribute("sPosiciones");
		} 
		response.setContentType("text/html"); 
	    PrintWriter out = response.getWriter(); 
		// Creamos el bean para obtener el array de palabras.
		AlmacenPalabras almacenPal = new AlmacenPalabras();
		try {
		    out.println("<html>");  
		    out.println("<head><title>EJER1 SESIONES</title></head>");
		    out.println("<body>");
		    out.println("<h1 style='text-align:center;'>AHORCADO</h1>");
		    // Hacemos un math random para que nos de un numero que este entre la longitud de array
			int numAleatorio = (int) (Math.random()*almacenPal.getPalabra().length);
		    // Sacamos la palabra que se encuentra en ese indice
			String palabraOculta = almacenPal.getPalabra()[numAleatorio];
			if (session.getAttribute("sPalabra") == null) {
				// Comprobamos que no sea repetida 
				while (historial.contains(palabraOculta)) {
					numAleatorio = (int) (Math.random()*almacenPal.getPalabra().length);
					palabraOculta = almacenPal.getPalabra()[numAleatorio];
				}
				session.setAttribute("sPalabra", palabraOculta);
			}else {
				palabraOculta = (String) session.getAttribute("sPalabra");
				palabraOculta = palabraOculta.toUpperCase();
			}  
			int desvelar;
			if (session.getAttribute("sDesvelar") == null) {
				desvelar = palabraOculta.length() / 2;
				session.setAttribute("sDesvelar", desvelar);
			}else {
				desvelar = (Integer) session.getAttribute("sDesvelar");
			}
			if (session.getAttribute("sVidas") != null) { 
				vidas = (int) session.getAttribute("sVidas");
			}else {
				vidas = palabraOculta.length() / 2; 
			} 
			if (request.getParameter("id") != null && desvelar > 0) {
				int idADesvelar = Integer.valueOf(request.getParameter("id"));
				posicionesAdivinadas.add(idADesvelar);
				session.setAttribute("sPosiciones", posicionesAdivinadas);
				// Bajamos el numero de opciones a desvelar y bajamos vidas
				vidas --;
				desvelar --;
				session.setAttribute("sVidas", vidas);
				session.setAttribute("sDesvelar", desvelar);
			}
		    // Comprobamos si le ha dado al btn de comprobar y si ha acertado
		    boolean conseguido = false;
		    if (request.getParameter("acierto") != null) {
				String acertado = request.getParameter("acierto"); 
				if (acertado.equals("true")) {
					conseguido = true;
				}else {
					desvelar--;
					vidas--;
					if (desvelar < 0) {
						desvelar = 0;
					}
					if (vidas < 0) {
						vidas = 0;
					}
					session.setAttribute("sVidas", vidas);
					session.setAttribute("sDesvelar", desvelar); 
				}
			} 
		    // Comprobamos que no haya adivinado ya todas las palabras
			if (historial.size() <= almacenPal.getPalabra().length) {
		    	out.println ("<form action=\"ServletComprobar\" method=\"get\">\r\n"
			    		+ "<table border=1 style='margin:auto;border-collapse:collapse;padding:1em;'>"
			    		+ "<tr>");
		    	if (conseguido) {
		    		for (int i = 0; i < palabraOculta.length(); i++) {
		    			out.println("<td>"+ palabraOculta.charAt(i) +"</td>");
		    		}
				}else if (desvelar == 0) {
		    		for (int i = 0; i < palabraOculta.length(); i++) {
		    			if (posicionesAdivinadas.contains(i)) {
							out.println("<td>"+ palabraOculta.charAt(i) +"</td>");
						}else {
							out.println("<td>?</td>");
						}
					    	
					}
				}else {
					for (int i = 0; i < palabraOculta.length(); i++) {
						if (request.getParameter("resp") != null && request.getParameter("resp").equals(palabraOculta)) {
							out.println("<td>"+ palabraOculta.charAt(i) +"</td>");
						}else if (posicionesAdivinadas.contains(i)) {
							out.println("<td>"+ palabraOculta.charAt(i) +"</td>");
						}else {
							out.println("<td><a href='ServletJuego?id="+ i +"'>Ver</a></td>");
						}
					    	
					}
				}
		    	
			    out.println ("</tr>"
			    		+ "</table>"
			    		+ "<div style='width:30%;margin:auto;'>"
			    		+ "<p>"+ vidas +" vidas restantes</p>"
			    		+ "<label for='resp'>Tu respuesta </label>");
			   if (conseguido) {
				   out.println ("<input type='text' name='resp' id='resp' disabled></input>"
					   		+ "<input type='submit' name='btn' value='Comprobar' disabled>"
					   		+ "<p style='color:green;'>MUY BIEN HAS ADIVINADO LA PALABRA \""+ palabraOculta +"\"!!!</p>");
			   }else if (vidas == 0) {
				   out.println ("<input type='text' name='resp' id='resp' disabled></input>"
				   		+ "<input type='submit' name='btn' value='Comprobar' disabled>"
				   		+ "<p style='color:red;'>LA PALABRA ERA \""+ palabraOculta +"\", EMPIEZA DE NUEVO</p>");
			   }else {
				   out.println ("<input type='text' name='resp' id='resp' required></input>"
				   		+ "<input type='submit' name='btn' value='Comprobar'>");
			   }
			   out.println ("</div>"
			    		+ "</form>"
			    		+ "<form action=\"ServletJuego\" method=\"get\">\r\n"
			    		+ "<input type='submit' name='deNuevo' style='width:15%;margin:auto;' value='EMPEZAR DE NUEVO'>"
			    		+ "</form>");
			}else {
				out.println("<p style='color:green;'>ERES UN CAMPEON, NO HAY MÁS PALABRAS POR ADIVINAR!</p>");
			}
		    
		}finally {
	    	out.println("</body></html>");  
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
