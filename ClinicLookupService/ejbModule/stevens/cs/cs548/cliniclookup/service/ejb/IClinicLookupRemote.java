package stevens.cs.cs548.cliniclookup.service.ejb;
import javax.ejb.Remote;

@Remote
public interface IClinicLookupRemote {

	public String GetClinicURL(String clinicName);
}
