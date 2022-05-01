package coding.challenge.cma.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding.challenge.cma.model.Customer;
import coding.challenge.cma.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	@Autowired
	private CustomerRepository customerRepo;
	
	@GetMapping("/list")
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable (value = "id") long id) throws Exception {
		return customerRepo.findById(id)
			.orElseThrow(() -> new Exception("Customer not found for this id: " + id));
	}
	
	@GetMapping("/add")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
	
	@PutMapping("/update/{id}")
	public Customer updateCustomer(@PathVariable (value = "id") long id,
			@Valid @RequestBody Customer customerDetails) throws Exception {
		Customer customer = customerRepo.findById(id)
			.orElseThrow(() -> new Exception("Customer not found for this id: " + id));
		customer.setFirstName(customerDetails.getFirstName());
		customer.setLastName(customerDetails.getLastName());
		customer.setEmail(customerDetails.getEmail());
		return customerRepo.save(customer);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable (value = "id") long id) throws Exception {
		Customer customer = customerRepo.findById(id)
			.orElseThrow(() -> new Exception("Customer not found for this id: " + id));
		customerRepo.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
