package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.Pet;

/**
 * Servlet implementation class addPetServlet
 */
@WebServlet("/addPetServlet")
public class addPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addPetServlet() {
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PetHelper ph = new PetHelper();
		String act = request.getParameter("doThisToItem");
		System.out.println("act = " + act);
		if(act == null) {
			getServletContext().getRequestDispatcher("/addPet.html").forward(request, response);
		} else if (act.equals("Add Pet")) {
			String name = request.getParameter("name");
			double weight = Double.valueOf(request.getParameter("weight"));
			String shots = request.getParameter("vacination");
		
			char hasShots = 0; 
			if ((shots.contains("Y")) || (shots.contains ("y"))) {
				hasShots = 'Y';
			}else {
				hasShots = 'N';
			}
			
			Customer customer = (Customer)getServletContext().getAttribute("customer"); 
			
			System.out.println("in pet servlet");
			
			Pet pet = new Pet(name, weight, hasShots, customer);
			ph.insertPet(pet);
			getServletContext().setAttribute("pet", pet);
			
			getServletContext().getRequestDispatcher("/makeAppointment.html").forward(request, response);

	}

	}

}