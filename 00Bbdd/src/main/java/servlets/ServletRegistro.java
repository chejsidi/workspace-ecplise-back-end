package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import dao.ClienteDAO;
import dao.KeysDAO;

/**
 * Servlet implementation class ServletRegistro
 */

public class ServletRegistro extends HttpServlet {
	private ClienteDAO c = new ClienteDAO();
	private KeysDAO k = new KeysDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistro() {
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
		if (request.getParameter("registrarse") != null) {
			String user = request.getParameter("user");
			String contra = request.getParameter("contra");
			String dom = request.getParameter("dom");
			int zip = Integer.parseInt(request.getParameter("zip"));
			int num = Integer.parseInt(request.getParameter("num"));
			String email = request.getParameter("email");
			if (c.buscaCliente(user) == false && Integer.parseInt(getInitParameter("maxCli")) > c.contClientes()) {
				request.getSession().setAttribute("userValido", true);
				int id = k.siguienteId("clientes");
				Cliente cli = new Cliente(id, user, contra, dom, zip, num, email);
				boolean todobn = c.guardarCliente(cli);
				if (todobn) {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else {
					request.getSession().setAttribute("userInvalido", true);
					request.getRequestDispatcher("registro.jsp").forward(request, response);
				}
				
			}else {
				request.getSession().setAttribute("userInvalido", true);
				request.getRequestDispatcher("registro.jsp").forward(request, response);
			}
		}
	}

}
