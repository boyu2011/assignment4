package stevens.cs.cs548.health;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Main {

	public static void main(String [ ] args)
	{
		// Create a entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HealthInfoSystemForAssignment4");
		EntityManager em = emf.createEntityManager();
/*	
		// Create a new clinic.
		ClinicDAO clinicDAO = new ClinicDAO(em);
		Clinic clinic = clinicDAO.CreateClinic("Jersey");
	
		//
		// User Case 1: Adding a new patient to a clinic.
		//
		
		// Create a new patient to a clinic.		
		Patient patient = clinic.AddPatient("patient111", em);
		
		//
		// User Case 2: Given a patient's name and birthday, retrieving a list of 
		// patient aggregates with that identifying information from a clinic.
		//
		
		Set<Patient> patients = clinic.getPatients("test", new Date(), em);
		
		//
		// User Case 3: A treatment entity object supports a visitor pattern.
		//

		patient.VisitTreatments(new TreatmentPrintVisitor());
		
		//
		// User Case 4: A patient aggregate returns a list of treatment identifiers.
		//
		
		Patient p1 = clinic.GetPatient("test", em);
		ArrayList<Long> ids = p1.GetTreatmentIds();
		
		//
		// User Case 5: Adding a provider to a clinic.
		//
		
		Physician physician = clinic.AddPhysician(em);
		Radiologist r = clinic.AddRadiologist(em);
		Surgeon s = clinic.AddSurgeon(em);
	
		//
		// User Case 6: Adding a treatment for a patient.
		//
		
		Patient p2 = clinic.GetPatient("ttt", em);
		RadiologyTreatment rt = p2.AddRadiologyTreatment(em);
		
		//
		// User Case 7: Getting a provider aggregate from a clinic.
		//

		clinic.GetProviderAggregateByName("test", em);
		
		//
		// User Case 8: Getting a patient-provider aggregate from a clinic. This provides 
		// access to all of the treatments that a particular provider is providing to a
		// particular patient in the clinic.
		//

		clinic.GetPatientProviderAggreagate(em, physician, p2);
*/	
	}

}
