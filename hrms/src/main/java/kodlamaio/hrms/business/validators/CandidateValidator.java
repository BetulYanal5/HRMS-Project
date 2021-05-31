package kodlamaio.hrms.business.validators;



import com.google.common.base.Strings;

import kodlamaio.hrms.business.constant.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateValidator extends UserValidator implements CandidateValidatorService{

	@Override
	public Result candidateNullCheck(Candidate candidate) {

		if (Strings.isNullOrEmpty(candidate.getFirstName().trim()) || Strings.isNullOrEmpty(candidate.getIdentityNumber().trim()) || Strings.isNullOrEmpty(candidate.getLastName().trim()) || candidate.getBirthDate() == null) {
			
			return new ErrorResult(Messages.notNull);
			
		}
		return super.userNullCheck(candidate);
		
	}

	@Override
	public Result nationalIdentityCheck(String nationalIdentity) {
		if (nationalIdentity.length() != 11) {
			
			return new ErrorResult(Messages.nationalIdentityInvalid);
			
		}
		return new SuccessResult();
	}

}
