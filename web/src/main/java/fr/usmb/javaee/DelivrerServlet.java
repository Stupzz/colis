package fr.usmb.javaee;

import fr.usmb.m2isc.javaee.comptes.ejb.ColisOperation;
import fr.usmb.m2isc.javaee.comptes.jpa.Status;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delivrer", name ="delivrer" )
public class DelivrerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ColisOperation ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelivrerServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/AfficherColis.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int id = Integer.parseInt(request.getParameter("id"));
		ejb.delivrer(ejb.getColis(id));

		request.setAttribute("colis", ejb.getColis(id));

		//adding possible states
		request.setAttribute("states", Status.values());

		doGet(request,response);
	}




}
