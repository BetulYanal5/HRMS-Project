package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.constant.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService{
	
	private final ActivationCodeDao activationCodeDao;
	
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}

	@Override
	public DataResult<List<ActivationCode>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ActivationCode>>(activationCodeDao.findAll(), Messages.activationCodeListed);
	}

	@Override
	public DataResult<Optional<ActivationCode>> getByUserId(int userId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Optional<ActivationCode>>(activationCodeDao.findByUserId(userId));
	}

	@Override
	public Result add(ActivationCode activationCode) {
		// TODO Auto-generated method stub
		activationCodeDao.save(activationCode);
		return new SuccessResult(Messages.activationCodeAdded);
	}

	@Override
	public Result update(ActivationCode activationCode) {
		// TODO Auto-generated method stub
		activationCodeDao.save(activationCode);
		return new SuccessResult(Messages.activationCodeUpdated);
	}

}
