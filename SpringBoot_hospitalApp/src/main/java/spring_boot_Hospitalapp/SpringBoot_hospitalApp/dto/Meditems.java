package spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Meditems {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "fill the field")
	private String name;
//	@NotBlank(message = "fill this cost")
	private int cost;

	@ManyToOne
	private MedOrder medOrder;
}
