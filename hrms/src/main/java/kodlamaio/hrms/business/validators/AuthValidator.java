package kodlamaio.hrms.business.validators;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.constant.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.dtos.RegisterForUserDto;

public class AuthValidator implements AuthValidatorService{

	@Override
	public Result registerNullCheck(RegisterForUserDto registerForUserDto) {
		if (Strings.isNullOrEmpty(registerForUserDto.getConfirmPassword().trim())) {
			
			return new ErrorResult(Messages.notNull);
			
		}
		return new SuccessResult();
	}

	@Override
	public Result confirmPassword(RegisterForUserDto registerForUserDto) {
		if (!registerForUserDto.getConfirmPassword().equals(registerForUserDto.getPassword())) {
			
			return new ErrorResult(Messages.PasswordNotConfirmed);
			
		}
		return new SuccessResult();
	}

}
