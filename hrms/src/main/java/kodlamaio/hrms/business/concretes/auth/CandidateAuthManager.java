package kodlamaio.hrms.business.concretes.auth;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.auth.CandidateAuthService;
import kodlamaio.hrms.business.abstracts.auth.UserAuthManager;
import kodlamaio.hrms.business.validators.AuthValidatorService;
import kodlamaio.hrms.core.utilities.email.EmailSenderService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.RegisterForCandidateDto;
import kodlamaio.hrms.entities.dtos.RegisterForUserDto;

public class CandidateAuthManager extends UserAuthManager<Candidate> implements CandidateAuthService {

	public CandidateAuthManager(AuthValidatorService authValidatorService, UserService<Candidate> userService,
			ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
		super(authValidatorService, userService, activationCodeService, emailSenderService);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Candidate newUserInstance(RegisterForUserDto registerForUserDto) {
		RegisterForCandidateDto dto = (RegisterForCandidateDto) registerForUserDto;
		return new Candidate(dto.getEmail(),dto.getPassword(),dto.getFirstName(),dto.getLastName(), dto.getIdentityNumber(),dto.getBirthDate());
		
	}

}
