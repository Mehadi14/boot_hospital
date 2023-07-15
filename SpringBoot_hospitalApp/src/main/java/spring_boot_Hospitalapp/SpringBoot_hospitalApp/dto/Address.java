package spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.logging.log4j.message.Message;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "city needed")
	private String city;
	@NotBlank
	@NotNull(message = "state needed")
	private String state;
//	@Pattern(regexp = "[1-9][0-9]{5}")
//	@NotNull(message = "pincode required")
	private int pincode;
	
	
	

}
