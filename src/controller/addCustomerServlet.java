package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.Pet;

/**
 * Servlet implementation class addCustomerServlet
 */
@WebServlet("/addCustomerServlet")
public class addCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCustomerServlet() {
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
		CustomerHelper ch = new CustomerHelper();
		PetHelper ph = new PetHelper();
		
		String act = request.getParameter("doThisToCustomer");
		if(act == null) {
			getServletContext().getRequestDispatcher("/findCustomer.html").forward(request, response);
		} else if (act.equals("Select Customer")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Customer c = ch.searchForCustomerById(tempId);
			getServletContext().setAttribute("customer", c);
			List<Pet> pets = ph.searchForPetByCustomer(c);
			request.setAttribute("matchingPets", pets);
			if(pets.isEmpty()) {
				request.setAttribute("matchingPets", " ");
			}
			getServletContext().getRequestDispatcher("/selectPet.jsp").forward(request, response);
		} else if (act.equals("New Customer")) {
			getServletContext().getRequestDispatcher("/addCustomer.html").forward(request, response);
			
		} else if (act.equals("Submit")) {
			
			String firstName = request.getParameter("customerFirstName");
			String lastName = request.getParameter("customerLastName");
			String address = request.getParameter("streetAddress");
			String city = request.getParameter("city");
			String state = request.getParameter("state"); 
			String zip = request.getParameter("zip");
			String phone = request.getParameter("phone");

			Customer customer = new Customer(firstName, lastName, address, city, state, zip, phone);
			ch.insertCustomer(customer);
			
			getServletContext().setAttribute("customer", customer);
			
			getServletContext().getRequestDispatcher("/addPet.html").forward(request, response);
		}else if (act.equals("Select Pet")) {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Pet p = ph.searchForPetById(tempId);
				getServletContext().setAttribute("pet", p);
				getServletContext().getRequestDispatcher("/makeAppointment.html").forward(request, response);
}
	}
}
