package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletComprobar
 */
@WebServlet(name="ServletComprobar", urlPatterns="/ServletComprobar")
public class ServletComprobar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletComprobar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("btn") != null && request.getParameter("resp") != null) {
			String resp = (String) request.getParameter("resp");
			resp = resp.toUpperCase();
			String palabraOculta =  (String) session.getAttribute("sPalabra");
			if (palabraOculta.toUpperCase().equals(resp)) {
				response.sendRedirect("ServletJuego?acierto=" + true);
			}else {
				response.sendRedirect("ServletJuego?acierto=" + false);
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
