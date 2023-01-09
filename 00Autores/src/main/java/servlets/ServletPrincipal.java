package servlets;

import dao.GestorBD;
import beans.Autor;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPrincipal
 */
@WebServlet(name = "ServletPrincipal", urlPatterns = {"/ServletPrincipal"})
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestorBD bd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrincipal() {
        super();
        // TODO Auto-generated constructor stub
    } 
    
    public void init(ServletConfig config) throws ServletException { 
    	super.init(config);
        this.bd = new GestorBD();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("autores", bd.autores());
        request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("insertar") == null){
            doGet(request, response);
        }else {
        	if(request.getParameter("nombre").equals("") || 
                    request.getParameter("nacimiento").equals("") || 
                    request.getParameter("nacionalidad").equals("")){
                request.setAttribute("errorinsercion", "Hay que rellenar todos los datos");
            }
        }
	}

}
