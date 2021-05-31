package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.abstracts.User;

public interface UserDao<T extends User> extends JpaRepository<T,Integer>{
	
	@Query("from User u where u.email = :mail")
	Optional<User>  getByMail(String mail);

}
