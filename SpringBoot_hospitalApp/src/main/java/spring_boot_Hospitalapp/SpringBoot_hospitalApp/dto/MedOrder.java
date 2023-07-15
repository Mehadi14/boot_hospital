package spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int m_id;
	@NotNull
	@NotBlank
	private String doctor;
	@NotBlank
	private String date;
	@ManyToOne
	private Encounter encounter;

}
