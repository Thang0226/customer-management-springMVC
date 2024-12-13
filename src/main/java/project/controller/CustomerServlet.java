package project.controller;

import project.DAO.CustomerDAO;
import project.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
	CustomerDAO customerDAO = new CustomerDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch (action) {
			case "view":
				viewCustomer(req, resp);
				break;
			default:
				listCustomers(req, resp);
				break;
		}
	}

	private void viewCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("customer_id"));
		Customer customer = customerDAO.findById(id);
		req.setAttribute("customer", customer);
		req.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(req, resp);
	}

	private void listCustomers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Customer> customers = customerDAO.findAll();
		req.setAttribute("customers", customers);
		req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch (action) {
			case "update":
				break;
			default:
				break;
		}
	}
}
