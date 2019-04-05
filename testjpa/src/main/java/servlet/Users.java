package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.EntityManagerHelper;
import jpa.Utilisateur;

@WebServlet(name = "users", urlPatterns = { "/rest/home/addUser" })
public class Users extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML>\n<BODY>\n"
				+ "<H1>Ajout d'un utilisateur</H1>\n"
				+ " <form id='addUser' method='post'> <UL>"
				+ " <LI>Nom: <input type='text' name='nom'></LI>\n"
				+ " <LI>Prenom: <input type='text' name='prenom'></LI>\n"
				+ " <LI>Email: <input type='text' name='email'></LI></UL>\n"
				+ " <input type='submit' value ='valider'> </form>"
				+ "</BODY></HTML>");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String nom = request.getParameter("nom"), prenom = request.getParameter("prenom"), email = request.getParameter("email");
		Utilisateur user = new Utilisateur(nom,prenom,email);
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(user);
		EntityManagerHelper.commit();
	}
}