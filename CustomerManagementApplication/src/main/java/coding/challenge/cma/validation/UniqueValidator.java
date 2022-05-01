package coding.challenge.cma.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import coding.challenge.cma.repository.CustomerRepository;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String>{

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return customerRepo.findByEmail(value).isPresent() ? false : true;
	}
	
}