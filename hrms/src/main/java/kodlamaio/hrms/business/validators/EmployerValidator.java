package kodlamaio.hrms.business.validators;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.constant.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

@Component
public class EmployerValidator extends UserValidator implements EmployerValidatorService {

	@Override
	public Result employerNullCheck(Employer employer) {
		
		if (Strings.isNullOrEmpty(employer.getCompanyName().trim()) || Strings.isNullOrEmpty(employer.getPhoneNumber().trim()) || Strings.isNullOrEmpty(employer.getWebAddress().trim())) {
			
			return new ErrorResult(Messages.notNull);
			
		}
		return super.userNullCheck(employer);
		
	}

	@Override
	public Result domainCheck(Employer employer) {
		String domain = employer.getWebAddress().split("www.")[1]; // www.betül.com  String[] args = {"","betül.com"};
		String emailDomain = employer.getEmail().split("@")[1]; // betül@betül.com String[] args = {"betül","betül.com"}
		if (!domain.equals(emailDomain)) {
			
			return new ErrorResult(Messages.domainNotEquals);
			
		}
		return new SuccessResult();
	}

}
