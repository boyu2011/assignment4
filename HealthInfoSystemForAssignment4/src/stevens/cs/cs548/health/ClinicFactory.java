package stevens.cs.cs548.health;

public class ClinicFactory {

	public static Clinic CreateClinic(String name)
	{
		return new Clinic(name);

	}
}
