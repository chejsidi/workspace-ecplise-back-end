package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Alumno;
import daos.ActividadesDao;
import daos.ParticipaDao;

/**
 * Servlet implementation class ServletInscripcion
 */

public class ServletInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscripcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alumno alum = (Alumno) request.getSession().getAttribute("alumno");
		// SI NO ESTA DECLARADA LA VARIABLE EN SESSION SIGNIFICA QUE ES LA PRIMERA VEZ QUE ENTRA.
		if (request.getSession().getAttribute("actParticipa") == null || request.getSession().getAttribute("actNoParticipa") == null) {
			request.getSession().setAttribute("actParticipa", ActividadesDao.getActividades(alum.getDni()));
			request.getSession().setAttribute("actNoParticipa", ActividadesDao.getNoParticipaActividades(alum.getDni())); 
		}
		if(request.getParameter("idAct") != null) {
			int idAct = Integer.valueOf(request.getParameter("idAct"));
			ArrayList<Integer> actSelec = new ArrayList<Integer>();
			if (request.getSession().getAttribute("actClicadas") != null) {
				actSelec = (ArrayList<Integer>) request.getSession().getAttribute("actClicadas");
			}
			if (!actSelec.contains(idAct)) {
				actSelec.add(idAct);
			}
			request.getSession().setAttribute("actClicadas", actSelec);
		}else if (request.getParameter("idActElim") != null) {
			ArrayList<Integer> actSelec = (ArrayList<Integer>) request.getSession().getAttribute("actClicadas");
			actSelec.remove(Integer.valueOf(request.getParameter("idActElim")));
			request.getSession().setAttribute("actClicadas", actSelec);
		}else if(request.getParameter("confirmado") != null) {
			ArrayList<Integer> idsEliminar = (ArrayList<Integer>) request.getSession().getAttribute("actClicadas");
			String fechaAux = java.time.LocalDate.now()+"";
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String fecha = formatter.format(date);
			for(Integer id: idsEliminar) {
				ParticipaDao.participar(alum.getDni(), id, fecha);
			}
			request.getSession().setAttribute("actClicadas", null);
			request.getSession().setAttribute("actParticipa", ActividadesDao.getActividades(alum.getDni()));
			request.getSession().setAttribute("actNoParticipa", ActividadesDao.getNoParticipaActividades(alum.getDni()));  
		}
		request.getRequestDispatcher("alumno.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 
	}

}
