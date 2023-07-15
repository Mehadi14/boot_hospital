package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception;

public class IdNotFoundException  extends RuntimeException{
	
	
	private String sms="Id not found";

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public IdNotFoundException(String sms) {
		super();
		this.sms = sms;
	}

	public IdNotFoundException() {
		super();
	}
	

}
