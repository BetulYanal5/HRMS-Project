package kodlamaio.hrms.core.utilities.email;

public class EmailSender implements EmailSenderService{

	@Override
	public void send(String body) {
		System.out.println(body);
		
	}

}
