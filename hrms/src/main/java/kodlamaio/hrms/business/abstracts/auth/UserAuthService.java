package kodlamaio.hrms.business.abstracts.auth;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.dtos.RegisterForUserDto;

public interface UserAuthService<T extends User> {
	
	Result register(RegisterForUserDto registerForUserDto);

}
