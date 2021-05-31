package kodlamaio.hrms.business.abstracts.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constant.Messages;
import kodlamaio.hrms.business.validators.AuthValidatorService;
import kodlamaio.hrms.core.utilities.email.EmailSenderService;
import kodlamaio.hrms.core.utilities.helpers.Helpers;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.dtos.RegisterForUserDto;

@Service
public abstract class UserAuthManager<T extends User> implements UserAuthService<T>{
	
	private final AuthValidatorService authValidatorService;
	private final UserService<T> userService;
	private final ActivationCodeService activationCodeService;
	private final EmailSenderService emailSenderService;
	
	@Autowired
	public UserAuthManager(AuthValidatorService authValidatorService, UserService<T> userService,
			ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
		super();
		this.authValidatorService = authValidatorService;
		this.userService = userService;
		this.activationCodeService = activationCodeService;
		this.emailSenderService = emailSenderService;
	}

	@Override
	public Result register(RegisterForUserDto registerForUserDto) {
		Result result = Helpers.BusinessEngine.run(authValidatorService.registerNullCheck(registerForUserDto),authValidatorService.confirmPassword(registerForUserDto));
		
		if (!result.isSuccess()) {
			
			return result;
			
		}
		T user = newUserInstance(registerForUserDto);
		Result userResult = userService.add(user);
		
		if (!userResult.isSuccess()) {
			
			return userResult;
			
		}
		
		Result activationResult  = emailVerification(user.getId());
		
		if (!activationResult.isSuccess()) {
			
			return activationResult;
			
			
		}
		
		return new SuccessResult(Messages.userAdded);
		
		
	}
	
	public abstract T newUserInstance(RegisterForUserDto registerForUserDto);
	
	public Result emailVerification(int userId) {
		String code = Helpers.CodeGenerator.generateUUIDCode();
		ActivationCode activationCode = new ActivationCode(code,userId);
		Result activatedResult = activationCodeService.add(activationCode);
		if (!activatedResult.isSuccess()) {
			
			return activatedResult;
			
		}
		emailSenderService.send("avtivasyon kodunuz: " + code);
		return new SuccessResult();
		
	}
	

}
