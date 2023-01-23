package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import dao.ClienteDAO;
import dao.PedidoDAO;

/**
 * Servlet implementation class ServletLogin
 */

public class ServletLogin extends HttpServlet {
	private ClienteDAO c = new ClienteDAO();
	private PedidoDAO p = new PedidoDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("login") != null) {
			String user = request.getParameter("user");
			String pass = request.getParameter("contra");
			Cliente cli = c.buscaCliente(user, pass);
			if (cli == null) {
				request.getSession().setAttribute("userInvalido", true);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.getSession().setAttribute("cliente", cli);
				request.getSession().setAttribute("items", p.todosItems());
				request.getRequestDispatcher("tienda.jsp").forward(request, response);
			}
			
		}
	}

}
