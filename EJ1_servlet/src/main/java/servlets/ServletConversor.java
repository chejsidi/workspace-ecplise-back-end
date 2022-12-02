
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Locale;

import beans.beanConversion;

@WebServlet(name="ServletConversor", urlPatterns = {"/ServletConversor"})
public class ServletConversor extends HttpServlet{  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HashSet<String> mapa = new HashSet<String>(); 
		
		// CAMBIO 2
        if (request.getAttribute("mapa") == null) {
        	mapa.add(request.getLocale().toString()); 
        	request.setAttribute("mapa", mapa);
		} else {
			mapa = (HashSet<String>) request.getAttribute("mapa");  
	        mapa.add(request.getLocale().toString()); 
			request.setAttribute("mapa",mapa);
		}
        String cambio2 = "Se han establecido conexiones desde "+mapa.size()+" distintos locale’s"; 
        
        //Obtener datos del formulario
        request.setCharacterEncoding("utf-8");
        if(request.getParameter("aFahrenheit")!=null){	// Cómo isset pero para JSP.
        	String celsius = request.getParameter("celsius");
        	if(celsius != null && celsius.length()>0) {	// Compruebo que haya celsius para convertir.
        		// String result = String.format("%.1f",( Integer.valueOf(celsius) * 1.8f) + 32); 
        		// Cambio 1
        		beanConversion bean = new beanConversion(celsius, "celsius");
        		String result = bean.getFahrenheit();
        		response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try {
                out.println("<html>"); 
                out.println("<head><title>RESULTADO CONVERSION</title></head>");
                out.println("<body>");
                out.println("<h1>RESULTADO</h1>"); 
                out.println("<p><strong>Valor en celsius:</strong> "+celsius+" </p>");
                out.println("<p><strong>Valor en fahrenheit:</strong> "+result+" </p>");
                }finally {
                	out.println("<p>"+cambio2+"</p>");
                	 out.println("</body>");
                     out.println("</html>");
                }
        	}else{
        		//Crear respuesta de error
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try {
                    out.println("<html>"); 
                    out.println("<head><title>ERROR CONVERSION</title></head>");
                    out.println("<body>");
                    out.println("<p style=\'border: 1px solid red;width:20em;paddin:1em;margin:auto;'><strong>ERROR:</strong> Debes indicar los grados celsius.</p>");
                }finally { 
                	out.println("</body>");
                    out.println("</html>");
                }
        	}
        }else {	// Si entra aquí es para convertir de fahrenheit a celsius
        	String fahrenheit = request.getParameter("fahrenheit"); 
        	if(fahrenheit != null && fahrenheit.length()>0) {
        		//String result = String.format("%.1f", (( Integer.valueOf(fahrenheit) - 32) / 1.8f)); 
        		// Cambio 1
        		beanConversion bean = new beanConversion(fahrenheit, "fahrenheit");
        		String result = bean.getCelsius();
        		response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try {
	                out.println("<html>"); 
	                out.println("<head><title>RESULTADO CONVERSION</title></head>");
	                out.println("<body>");
	                out.println("<h1>RESULTADO</h1>"); 
	                out.println("<p><strong>Valor en celsius:</strong> "+result+" </p>");
	                out.println("<p><strong>Valor en fahrenheit:</strong> "+fahrenheit+" </p>");
                }finally {
                	out.println("<p>"+cambio2+"</p>");
                	out.println("</body>");
 	                out.println("</html>");
                }
        	}else {
        		response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try {
                    out.println("<html>"); 
                    out.println("<head><title>ERROR CONVERSION</title></head>");
                    out.println("<body>");
                    out.println("<p style=\'border: 1px solid red;width:20em;paddin:1em;margin:auto;'><strong>ERROR:</strong> Debes indicar los fahrenheits.</p>");
                }finally { 
                	out.println("</body>");
 	                out.println("</html>");
                }
        	}
        }
        
        
    } 
	
}
