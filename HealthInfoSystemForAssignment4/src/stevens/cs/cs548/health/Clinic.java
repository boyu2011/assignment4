package stevens.cs.cs548.health;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clinic
 *
 */
@Entity
@Table(name="CLINIC")
public class Clinic implements Serializable {
	
	//
	// data members.
	//
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy = "clinic", targetEntity=stevens.cs.cs548.health.Provider.class)
	private Set<Provider> providers;
	
	@OneToMany(mappedBy = "clinic", targetEntity=stevens.cs.cs548.health.Patient.class)
	private Set<Patient> patients;

	private static final long serialVersionUID = 1L;
	
	//
	// Constructors.
	//
	
	public Clinic() {
		super();
	}
	
	public Clinic(String name) {
		this.name = name;
	}

	//
	// Setter / Getter
	//
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Set<Provider> getProviders() {
		return providers;
	}
	public void setProviders(Set<Provider> providers) {
		this.providers = providers;
	}
	
	public Set<Patient> getPatients() {
		return patients;
	}
	
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//
	// Patient Factory.
	//
	
	public static Patient CreatePatient(String name)
	{
		return new Patient(name);
	}
	
	//
	// Provider Factory.
	//
	
	public static Provider CreateProvider(ProviderType providerType)
	{
		Provider provider = null;
		if ( ProviderType.Physician == providerType)
			provider = new Physician();
		else if (ProviderType.Surgeon == providerType)
			provider = new Surgeon();
		else if (ProviderType.Radiologist == providerType)
			provider = new Radiologist();
		
		return provider;
	}
	
	//
	// Treatment Factory.
	//
	
	public static Treatment CreatTreatment(TreatmentType treatmentType)
	{
		Treatment treatment = null;
		if ( TreatmentType.DrugTreatment == treatmentType)
			treatment = new DrugTreatment();
		else if ( TreatmentType.SurgeryTreatment == treatmentType)
			treatment = new SurgeryTreatment();
		else if ( TreatmentType.RadiologyTreatment == treatmentType)
			treatment = new RadiologyTreatment();
		
		return treatment;
	}
	
	//
	// Business logic functions.
	//

	//
	// For User Case 1.
	//
	
	public Patient AddPatient(String name, EntityManager em)
	{
		PatientDAO patientDAO = new PatientDAO(em);
		Patient p = patientDAO.CreatePatient(name, this);
		return p;
	}
	
	//
	// For User Case 2.
	//
	
	public Set<Patient> getPatients(String name, Date birth, EntityManager em) {
		PatientDAO patientDAO = new PatientDAO(em);
		Set<Patient> patients = patientDAO.GetPatientAggregates(name, birth);
		return patients;
	}
	
	//
	// For User Case 4.
	//
	
	//
	// For User Case 5.
	//
	
	public Physician AddPhysician(EntityManager em)
	{	
		ProviderDAO providerDAO = new ProviderDAO(em);
		Physician p = providerDAO.CreatePhysician();
		return p;
	}
	
	public Radiologist AddRadiologist(EntityManager em)
	{	
		ProviderDAO providerDAO = new ProviderDAO(em);
		Radiologist r = providerDAO.CreateRadiologist();
		return r;
	}
	
	public Surgeon AddSurgeon(EntityManager em)
	{
		ProviderDAO providerDAO = new ProviderDAO(em);
		Surgeon s = providerDAO.CreateSurgeon();
		return s;
	}
	
	//
	// For User Case 6.
	//
	
	public Patient GetPatient (String name, EntityManager em)
	{
		PatientDAO patientDAO = new PatientDAO(em);
		Patient p = patientDAO.GetPatient(name);
		return p;
	}

	//
	// For User Case 7.
	//

	public Set<Long> GetProviderAggregateByName(String name, EntityManager em)
	{
		Set<Long> pids = null;
		ProviderDAO providerDAO = new ProviderDAO(em);
		pids = providerDAO.GetProviderIdSetByName(name, this);
		return pids;
	}
	
	//
	// For User Case 8.
	//
	
	public Set<Treatment> GetPatientProviderAggreagate(EntityManager em, Provider provider, Patient patient)
	{
		TreatmentDAO treatmentDAO = new TreatmentDAO(em);
		return treatmentDAO.GetTreatmentSet(provider, patient);
		
	}
}
