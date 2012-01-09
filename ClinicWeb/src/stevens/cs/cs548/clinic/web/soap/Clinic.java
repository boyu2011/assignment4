package stevens.cs.cs548.clinic.web.soap;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import stevens.cs.cs548.clinic.service.ClinicServiceExn;
import stevens.cs.cs548.clinic.service.dto.PatientDTO;
import stevens.cs.cs548.clinic.service.ejb.IClinicBeanLocal;

@WebService(endpointInterface="stevens.cs.cs548.clinic.web.soap.IClinic")
public class Clinic implements IClinic {

	@EJB(beanName="ClinicBean")
	IClinicBeanLocal clinic;
	
	@Override
	public void addPatient(String name, Date dob, int age)
			throws ClinicWebFault {
		try 
		{
			clinic.addPatient(name, dob, age);
		}
		catch(ClinicServiceExn e)
		{
			throw new ClinicWebFault(e.getMessage());
		}
	}

	@Override
	public List<PatientDTO> getPatientByName(String name, Date dob) {
		return clinic.getPatient(name, dob);
	}

	@Override
	public PatientDTO getPatientById(long id) {
		return clinic.getPatient(id);
	}

	@Override
	public List<Long> getPatients() {
		return clinic.getPatients();
	}

	@Override
	public String getClinicName() {
		return clinic.getClinicName();
	}

	@Override
	public void ping() {
		return;
	}

}
