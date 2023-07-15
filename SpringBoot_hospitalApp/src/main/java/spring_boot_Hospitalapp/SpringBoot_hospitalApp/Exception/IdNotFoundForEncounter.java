package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception;

import lombok.Getter;
import lombok.Setter;

public class IdNotFoundForEncounter extends RuntimeException {
	
	@Getter
	@Setter
	private String sms="id not found for the encounter";

	public IdNotFoundForEncounter(String sms) {
		super();
		this.sms = sms;
	}

	public IdNotFoundForEncounter() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
