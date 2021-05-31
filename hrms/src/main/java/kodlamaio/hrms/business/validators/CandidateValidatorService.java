package kodlamaio.hrms.business.validators;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateValidatorService {
	
	Result candidateNullCheck(Candidate candidate);
	Result nationalIdentityCheck(String nationalIdentity);

}
