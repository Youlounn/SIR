package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.Utilisateur;

@WebServlet(name = "users", urlPatterns = { "/Users" })
public class Users extends HttpServlet {
	EntityManager manager;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		manager = factory.createEntityManager();

		PrintWriter out = response.getWriter();
		ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) manager.createQuery("Select a From Utilisateur a", Utilisateur.class).getResultList();
	       
		out.println("taille = "+users.size());
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<HTML>\n<BODY>\n"
				+ "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n"
				+ " <LI>Nom: " + request.getParameter("name") + "\n"
				+ " <LI>Prenom: " + request.getParameter("firstname") + "\n"
				+ " <LI>Age: " + request.getParameter("age") + "\n" + "</UL>\n"
				+ "</BODY></HTML>");
	}
}