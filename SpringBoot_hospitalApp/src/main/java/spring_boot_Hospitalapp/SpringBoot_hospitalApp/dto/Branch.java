package spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
//	@NotBlank
//	@Pattern(regexp = "[6-9][0-9]{9}",message = "enter valid phonenumber format")
	private long phone;
	@NotNull
	private String manager;
	@OneToOne
	private Address address;
	@ManyToOne
private Hospital hospital;

	
	
}
