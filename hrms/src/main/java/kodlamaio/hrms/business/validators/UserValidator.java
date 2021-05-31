package kodlamaio.hrms.business.validators;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.constant.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.abstracts.User;


public abstract class UserValidator {

	public Result userNullCheck(User user) {
		
		if (Strings.isNullOrEmpty(user.getEmail().trim()) || Strings.isNullOrEmpty(user.getPassword().trim())) {
			
			return new ErrorResult(Messages.notNull);
			
		}
		return new SuccessResult();
		
	}
	
}
