package kodlamaio.hrms.business.concretes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;

import kodlamaio.hrms.entities.concretes.Employee;

import kodlamaio.hrms.dataAccess.abstracts.UserDao;

@Service
public class EmployeeManager extends UserManager<Employee> implements EmployeeService {

	@Autowired
	public EmployeeManager(UserDao<Employee> userDao) {
		super(userDao);
	}

	
}
