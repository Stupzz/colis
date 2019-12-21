package fr.usmb.javaee;

import fr.usmb.m2isc.javaee.comptes.ejb.ColisOperation;
import fr.usmb.m2isc.javaee.comptes.jpa.Colis;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/postParcel", name ="postParcel" )
public class PostColisServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ColisOperation ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostColisServlet() {

    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long weight = Long.parseLong(request.getParameter("weight"));
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		Colis colis = new Colis();
		colis.setPoids(weight);
		colis.setOrigine(source);
		colis.setDestination(destination);
		colis = ejb.createColis(colis);

		PrintWriter out = response.getWriter();
		out.println(
				"<html>" +
					"<head>" +
						"<title>Message de confirmation</title>" +
						"<link rel='stylesheet' href='css/base.css'>" +
					"</head>" +
					"<body>" +
						"<h1> Message de confirmation : </h1>" +
						"<p>Le colis à bien été enregistré !</p>" +
						colis.toString() +
						"<br>" +
						"<a href=\"home\">Retour Accueil</a>" +
					"</body>" +
				"</html>"
		);
	}


}
