package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Appointment;
import model.Customer;
import model.Pet;
import model.Services;

/**
 * Servlet implementation class viewAppointmentServlet
 */
@WebServlet("/viewAppointmentServlet")
public class viewAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAppointmentServlet() {
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
		AppointmentHelper ah = new AppointmentHelper();
		PetHelper ph = new PetHelper();
		ServicesHelper sh = new ServicesHelper();
		CustomerHelper ch = new CustomerHelper();
		
		String act = request.getParameter("doThisToAppt");
		if(act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAppointment.html").forward(request, response);
		} else if (act.equals("Submit")) {
			String lastName = request.getParameter("lastName");
			String name = request.getParameter("name");

			List<Appointment> appts = ah.searchForAppointmentByCustomerAndPet(lastName, name);
			
			request.setAttribute("matchingAppointments", appts);
			if(appts.isEmpty()) {
				request.setAttribute("matchingAppointments", " ");
			}
			getServletContext().getRequestDispatcher("/selectAppointment.jsp").forward(request, response);
		} else if (act.equals("Back to Menu")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else if (act.equals("Select Appointment")) {
			Integer tempId = Integer.parseInt(request.getParameter("appointment_id"));
			
			System.out.println("Appointment ID Value: " + tempId);
			
			Appointment appointment = ah.searchForAppointmentById(tempId);
			System.out.println("Appointment: " + appointment.toString());
			
			Pet pet = ph.searchForPetByAppointment(appointment);
			System.out.println("Pet:" + pet.toString());
			
			Services service = sh.searchForServiceByAppointment(appointment);
			System.out.println("Service: " + service.toString());
			
			Customer customer = ch.searchForCustomerByPet(pet);
			System.out.println("Customer" + customer.toString());
			
			getServletContext().setAttribute("selectedAppointment", appointment);
			getServletContext().setAttribute("selectedPet", pet);
			getServletContext().setAttribute("selectedService", service);
			getServletContext().setAttribute("selectedCustomer", customer);
			
			request.setAttribute("appointment", appointment);
			request.setAttribute("pet", pet);
			request.setAttribute("service", service);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/viewAppointment.jsp").forward(request, response);
		} else if (act.equals("New Appointment")) {
			getServletContext().getRequestDispatcher("/startAppointment.html").forward(request, response);
		}
	}
}
	
	
	



