package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="activation_codes")
public class ActivationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="activation_code")
	private String activationCode;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed = false;
	
	@Column(name="confirmed_date")
	private LocalDateTime confirmedDate = null;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="created_date")
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@Column(name="expiration_date")
	private LocalDateTime expirationDate = LocalDateTime.now().plusDays(1);

	public ActivationCode(String activationCode, int userId) {
		super();
		this.activationCode = activationCode;
		this.userId = userId;
	}
	
	
	

}
