package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception;

import lombok.Getter;
import lombok.Setter;

public class IdNotFoundForPersonException extends RuntimeException {
	
	
	@Getter
	@Setter
	private String msg=" id not found for the person";

	public IdNotFoundForPersonException(String msg) {
		super();
		this.msg = msg;
	}

	public IdNotFoundForPersonException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
