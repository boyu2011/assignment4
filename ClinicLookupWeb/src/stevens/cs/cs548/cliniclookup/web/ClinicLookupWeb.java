package stevens.cs.cs548.cliniclookup.web;

import javax.ejb.EJB;
import javax.jws.WebService;
import stevens.cs.cs548.cliniclookup.service.ejb.IClinicLookupRemote;

@WebService(endpointInterface="stevens.cs.cs548.cliniclookup.web.IClinicLookupWeb")
public class ClinicLookupWeb implements IClinicLookupWeb {

	@EJB(beanName="ClinicLookupBean")
	private IClinicLookupRemote clinic;
	
	@Override
	public String GetClinicURL(String clinicName)
	{
		return clinic.GetClinicURL(clinicName);
	}
}
