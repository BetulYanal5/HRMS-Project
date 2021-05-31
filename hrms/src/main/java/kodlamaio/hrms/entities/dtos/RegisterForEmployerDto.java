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
public class RegisterForEmployerDto extends RegisterForUserDto {
	
	
	private String companyName;
	
	
	private String webAddress;
	
	
	private String phoneNumber;

}
