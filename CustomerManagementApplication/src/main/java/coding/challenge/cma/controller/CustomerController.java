package coding.challenge.cma.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import coding.challenge.cma.model.Customer;
import coding.challenge.cma.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list-customers")
	public String showCustomers(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "list-customers";
	}
	
	@GetMapping("/add-customer")
	public String showAddCustomerPage(Model model) {
		model.addAttribute("customer", new Customer());
		return "add-customer";
	}
	
	@GetMapping("/view-customer")
	public String showCustomerPage(@RequestParam long id, Model model) {
		Customer customer = customerService.getCustomerById(id).orElseGet(null);
		if (Objects.nonNull(customer)) {
			model.addAttribute("customer", customer);
		}
		return "view-customer";
	}
	
	@GetMapping("/update-customer")
	public String showUpdateCustomerPage(@RequestParam long id, Model model) {
		Customer customer = customerService.getCustomerById(id).orElseGet(null);
		if (Objects.nonNull(customer)) {
			model.addAttribute("customer", customer);
		}
		return "update-customer";
	}
	
	@GetMapping("/delete-customer")
	public String deleteCustomer(@RequestParam long id) {
		customerService.deleteCustomer(id);
		return "redirect:/list-customers";
	}
	
	@PostMapping("/add-customer")
	public String addCustomer(Model model, @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return "add-customer";
		}
		customerService.saveCustomer(customer);
		return "redirect:/list-customers";
	}
	
	@PostMapping("/update-customer")
	public String updateCustomer(Model model, @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return "update-customer";
		}
		customerService.updateCustomer(customer);
		return "redirect:/list-customers";
	}
	
}
