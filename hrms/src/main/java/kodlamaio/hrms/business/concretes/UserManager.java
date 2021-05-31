package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constant.Messages;
import kodlamaio.hrms.business.validators.UserValidator;
import kodlamaio.hrms.core.utilities.helpers.Helpers;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;


@Service
public class UserManager<T extends User> implements UserService<T>{

	private final UserDao<T> userDao;
	

	@Autowired
	public UserManager(UserDao<T> userDao) {
		super();
		this.userDao = userDao;
		
	}

	@Override
	public DataResult<List<T>> getAll() {
		return new SuccessDataResult<List<T>>(this.userDao.findAll(),"data listelendi");
	}

	@Override
	public Result add(T t) {
		Result result = Helpers.BusinessEngine.run(emailExists(t.getEmail()));
		
		if (!result.isSuccess()) {
			
			return result;
			
		}
		
		this.userDao.save(t);
		return new SuccessResult("kullanıcı Eklendi");
	}
	
	private Result emailExists(String email) {
		if(userDao.getByMail(email).isPresent()) {
			return new ErrorResult(Messages.emailExist);
		}
		return new SuccessResult();
	}
	
}
