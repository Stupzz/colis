package fr.usmb.javaee;

import fr.usmb.m2isc.javaee.comptes.ejb.ColisOperation;
import fr.usmb.m2isc.javaee.comptes.ejb.SuivisOperation;
import fr.usmb.m2isc.javaee.comptes.jpa.Colis;
import fr.usmb.m2isc.javaee.comptes.jpa.Status;
import fr.usmb.m2isc.javaee.comptes.jpa.Suivis;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet(value = "/postTrack", name ="postTrack" )
public class PostSuivisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ColisOperation ejbParcel;

	@EJB
	private SuivisOperation ejbTrack;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostSuivisServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/AfficherColis.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date date = new Date();

		int id = Integer.parseInt(request.getParameter("id"));
		String location = request.getParameter("location");
		Status status = Status.valueOf(request.getParameter("status"));
		Suivis suivis = new Suivis();
		suivis.setDate(date);
		suivis.setLocalisation(location);
		suivis.setColis(ejbParcel.getColis(id));
		suivis.setStatus(status);
		suivis = ejbTrack.createTrack(suivis);
		Colis colis = ejbParcel.getColis(id);
		colis.getSuivis().add(suivis);
		ejbParcel.updateColis(colis);

        request.setAttribute("colis", colis);

        //adding possible states
        request.setAttribute("states", Status.values());

		doGet(request,response);





	}


}
