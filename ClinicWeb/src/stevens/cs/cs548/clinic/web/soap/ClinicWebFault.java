package stevens.cs.cs548.clinic.web.soap;

public class ClinicWebFault extends Exception {

	private static final long serialVersionUID = 1L;

	public ClinicWebFault(String msg)
	{
		super(msg);
	}
	
	public ClinicWebFault()
	{
		super();
	}
}
