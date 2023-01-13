package servlets;

import dao.GestorBD;
import beans.Autor;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
		if (request.getParameter("tituloLibro") != null) {
			String tituloLibro = request.getParameter("tituloLibro");
			request.setAttribute("errorinsercion", tituloLibro + " | Nuevo prestamo generado.");
		}
		if(request.getParameter("verLibrosDe") == null){
			request.setAttribute("libros", null); 
			request.setAttribute("autorActivo", null); 
		}else {
			int idAutor = Integer.parseInt(request.getParameter("verLibrosDe"));
			String nomAutor = request.getParameter("nombreAutor");
			ArrayList<String> libros = bd.libros(idAutor);
			if (libros.size() <= 0) {
				request.setAttribute("errorinsercion", nomAutor + " | No tiene libros.");
			}else {
				request.setAttribute("libros", libros);
				request.setAttribute("autorActivo", nomAutor); 
			}
			
		}
		if (request.getParameter("tituloLibro") != null) {
			
		}
		request.getSession().setAttribute("autores", bd.autores());
        request.getRequestDispatcher("autores.jsp").forward(request, response); 
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
            }else {
            	try{
	            	//Recuperamos los datos del formulario y creamos un objeto de tipo Autor.
	            	String nombre = request.getParameter("nombre"); 
	                String nacimiento = request.getParameter("nacimiento");  
	                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
	                Date date = null;
					try {
						date = formatter.parse(nacimiento);
					} catch (ParseException e) { 
						e.printStackTrace();
					}
	                String nacionalidad = request.getParameter("nacionalidad"); 
	                Autor autor = new Autor(nombre, date, nacionalidad);
	                boolean existe = bd.existeAutor(autor);
	                if(existe){
	                    request.setAttribute("errorinsercion", "El autor " 
	                            + autor.getNombre() + " ya existe");
	                }else{
	                    int id = bd.insertarAutor(autor);
	                    if(id == -1){
	                        request.setAttribute("errorinsercion", "No se ha podido insertar el autor");
	                        request.setAttribute("autorerroneo", autor);
	                    }else{ 
	                        autor.setIdAutor(id);
	                        ((ArrayList<Autor>) request.getSession().getAttribute("autores")).add(autor);
	                    }
	                }
	            }catch(NumberFormatException e){
	                request.setAttribute("errorinsercion", "Numero de p�ginas erroneo");
	            }
        }
		request.getRequestDispatcher("autores.jsp").forward(request, response);
	}
	}
}
