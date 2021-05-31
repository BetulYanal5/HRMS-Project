package kodlamaio.hrms.business.validators;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerValidatorService {
	
	Result employerNullCheck(Employer employer);
	Result domainCheck(Employer employer);

}
