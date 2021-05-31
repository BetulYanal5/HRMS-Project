package kodlamaio.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.validators.EmployerValidatorService;

import kodlamaio.hrms.core.utilities.helpers.Helpers;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;


@Service
public class EmployerManager extends UserManager<Employer> implements EmployerService{
	
	private final EmployerValidatorService employerValidatorService;
  
	@Autowired
	public EmployerManager(UserDao<Employer> userDao, EmployerValidatorService employerValidatorService) {
		super(userDao);
		this.employerValidatorService = employerValidatorService;
	}

	@Override
	public Result add(Employer employer) {
		Result result = Helpers.BusinessEngine.run(employerValidatorService.employerNullCheck(employer), employerValidatorService.domainCheck(employer));
		
		if(!result.isSuccess()) {
			return result;
		}
		
		return super.add(employer);
	}


}
