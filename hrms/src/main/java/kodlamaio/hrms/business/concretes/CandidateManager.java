package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.constant.Messages;
import kodlamaio.hrms.business.validators.CandidateValidatorService;
import kodlamaio.hrms.core.utilities.helpers.Helpers;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateManager extends UserManager<Candidate> implements CandidateService{

	private final CandidateValidatorService candidateValidatorService;
	private final CandidateDao candidateDao;
	
	public CandidateManager(UserDao<Candidate> userDao, CandidateValidatorService candidateValidatorService) {
		super(userDao);
		this.candidateValidatorService = candidateValidatorService;
		this.candidateDao = (CandidateDao) userDao;
	}

	@Override
	public Result add(Candidate t) {
		Result result = Helpers.BusinessEngine.run(candidateValidatorService.candidateNullCheck(t),candidateValidatorService.nationalIdentityCheck(t.getIdentityNumber()),nationalIdentityExist(t.getIdentityNumber()));
		
		if (!result.isSuccess()) {
			
			return result;
			
		}
		return super.add(t);
	}
	
	private Result nationalIdentityExist(String nationalIdentity) {
		
		if (candidateDao.findByIdentityNumber(nationalIdentity).isPresent()) {
			
			return new ErrorResult(Messages.nationalityIdentityExist);
			
		}
		return new SuccessResult();
		
	}
	

}
