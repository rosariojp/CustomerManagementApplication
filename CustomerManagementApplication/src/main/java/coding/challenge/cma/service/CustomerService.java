package coding.challenge.cma.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.challenge.cma.model.Customer;
import coding.challenge.cma.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	public void addCustomer(String firstName, String lastName, String email) {
		customerRepo.save(new Customer(firstName, lastName, email));
	}
	
	public Customer saveCustomer(@Valid Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer updateCustomer(@Valid Customer customer) {
		return customerRepo.save(customer);
	}
	
	public void deleteCustomer(long id) {
		Customer customer = customerRepo.findById(id).orElse(null);
		if (Objects.nonNull(customer)) {
			customerRepo.delete(customer);
		}
	}

	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	public Optional<Customer> getCustomerById(long id) {
		return customerRepo.findById(id);
	}
	
	public Optional<Customer> getCustomerByEmail(String email) {
		return customerRepo.findByEmail(email);
	}

}
