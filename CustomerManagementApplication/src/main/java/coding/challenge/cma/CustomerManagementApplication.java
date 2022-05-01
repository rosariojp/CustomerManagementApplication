package coding.challenge.cma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import coding.challenge.cma.model.Customer;
import coding.challenge.cma.repository.CustomerRepository;

@SpringBootApplication
public class CustomerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
	}

    @Bean
    public CommandLineRunner demoData(CustomerRepository repo) {
        return args -> { 
            repo.save(new Customer("John", "Warton", "warton@gmail.com"));
            repo.save(new Customer("Mike", "Lanister", "lanister@gmail.com"));
            repo.save(new Customer("Steve", "Reeves", "reeves@yahoo.com"));
            repo.save(new Customer("Ronald", "Connor", "connor@hotmail.com"));
            repo.save(new Customer("Jim", "Salvator", "sal@gmail.com"));
            repo.save(new Customer("Richard", "Carson", "carson@linkedin.com"));
            repo.save(new Customer("Honor", "Miles", "miles@gmail.com"));
        };
    }
	
}
