package kodlamaio.hrms.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(name="email")	
	private String email;
    
     @Column(name="password")
	private String password;

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
     
     
     
     

}