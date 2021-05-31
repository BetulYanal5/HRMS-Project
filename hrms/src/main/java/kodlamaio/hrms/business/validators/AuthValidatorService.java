package kodlamaio.hrms.business.validators;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.RegisterForUserDto;

public interface AuthValidatorService {
	
	Result registerNullCheck(RegisterForUserDto registerForUserDto);
	
	Result confirmPassword(RegisterForUserDto registerForUserDto);

}
