package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.DAO.CustomerDAO;
import project.model.Customer;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerDAO customerDAO;

	@GetMapping()
	public ModelAndView listCustomers() {
		ModelAndView mv = new ModelAndView("list");
		List<Customer> customers = customerDAO.findAll();
		mv.addObject("customers", customers);
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView viewCustomer(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("view");
		Customer customer = customerDAO.findById(id);
		mv.addObject("customer", customer);
		return mv;
	}

	@PostMapping("/{id}")
	public String updateCustomer(Customer customer) {
//	public String updateCustomer(@RequestParam int id,
//	                             @RequestParam String name,
//	                             @RequestParam String email,
//	                             @RequestParam String address) {
//		Customer customer = new Customer(id, name, email, address);
		customerDAO.update(customer);
		return "redirect:/customers";
	}
}
