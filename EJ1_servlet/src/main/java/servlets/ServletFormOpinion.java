package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Extiende HttpServlet class
@WebServlet(name="ServletFormOpinion", urlPatterns = {"/ServletFormOpinion"})
public class ServletFormOpinion extends HttpServlet {
 
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String title = "Ejercicio2";
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//es\">\n";
       
      out.println(docType +
         "<html>\n" 
            + "<head><title>" + title + "</title></head>\n" 
            + "<body bgcolor = \"#f0f0f0\">\n" +
               "<h1 align = \"center\">" + title + "</h1>\n");

      boolean isSet = (request.getParameter("your_parameter_goes_here") == null);
      if(isSet) {
    	  
      }
      out.println("<form action=\"ServletFormOpinion\" method=\"post\">\r\n"
               + "		  <label for=\"nom\">Nombre:</label>\r\n"
               + "		  <input type=\"text\" id=\"nom\" name=\"nom\"><br>\r\n"
               + "		  <label for=\"nom\">Apellidos:</label>\r\n"
               + "		  <input type=\"text\" id=\"nom\" name=\"nom\"><br>\r\n"
               + "		  <p>Opinión que le ha parecido este sitio web</p>\r\n"
               + "		  <input type=\"radio\" id=\"buena\" name=\"opinion\" value=\"B\">\r\n"
               + "		  <label for=\"buena\">Buena</label><br>\r\n"
               + "		  <input type=\"radio\" id=\"regular\" name=\"opinion\" value=\"R\">\r\n"
               + "		  <label for=\"regular\">Regular</label><br>\r\n"
               + "		  <input type=\"radio\" id=\"mala\" name=\"opinion\" value=\"M\">\r\n"
               + "		  <label for=\"mala\">Mala</label><br>\r\n"
               + "		  <p><label for=\"comentarios\">Comentarios</label></p>\r\n"
               + "		  <textarea id=\"comentarios\" name=\"comentarios\" rows=\"4\" cols=\"50\"></textarea><br>\r\n"
               + "		  <p>Tus secciones favoritas</p> \r\n");
      		   String txtFilePath = request.getServletContext().getRealPath("opciones.txt");
      		   BufferedReader reader = new BufferedReader(new FileReader(txtFilePath)); 
      		   String linea;
      		   while((linea = reader.readLine())!= null){
	      			out.println("<label>\r\n"
	      	               + "		  	<input type=\"checkbox\" name=\"cbox[]\" value=\""+linea+"\"> "+linea+"\r\n"
	      	               + "		  </label><br>\r\n");
	           }
               out.println( 
                 "		  <input type=\"submit\" value=\"Enviar opinion\">\r\n"
               + "  	</form>"
            + "</body>" +
         "</html>"
      );
   }
}