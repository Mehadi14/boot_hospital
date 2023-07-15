package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception;

import lombok.Getter;
import lombok.Setter;

public class IdNotFoundForBranchException extends RuntimeException {
	
	@Getter
	@Setter
	private String sms="id not found for brach";


	public IdNotFoundForBranchException(String sms) {
		super();
		this.sms = sms;
	}

	public IdNotFoundForBranchException() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
