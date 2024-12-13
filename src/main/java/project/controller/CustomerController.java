package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import project.DAO.CustomerDAO;
import project.model.Customer;

import java.util.List;

@Controller
public class CustomerController {
	@Autowired
	private CustomerDAO customerDAO;

	@GetMapping("/customers")
	public ModelAndView listCustomers(Model model) {
		ModelAndView mv = new ModelAndView("list");
		List<Customer> customers = customerDAO.findAll();
		mv.addObject("customers", customers);
		return mv;
	}
}
