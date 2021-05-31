package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RegisterForCandidateDto extends RegisterForUserDto {
	
	
	private String firstName;
	
	
	private String LastName;
	
	
	private String identityNumber;
	
	
	private Date birthDate;

}
