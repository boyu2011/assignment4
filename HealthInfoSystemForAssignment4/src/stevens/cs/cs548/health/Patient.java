package stevens.cs.cs548.health;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.sun.tools.javac.util.List;

/**
 * Entity implementation class for Entity: Patient
 *
 */
@Entity
@Table(name="PATIENT")
public class Patient implements Serializable {
	   
	//
	// data members.
	//
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToMany(mappedBy = "patient", targetEntity=stevens.cs.cs548.health.Treatment.class)
	private Set<Treatment> treatments;

	private String name;
	
	//private Date birthdate;
	
	private Clinic clinic;
	@ManyToOne
	@JoinColumn(name = "clinic_fk", referencedColumnName="id")
	public Clinic getClinic() {
		return this.clinic;
	}
	
	private static final long serialVersionUID = 1L;
	
	//
	// Constructors.
	//
	
	public Patient()
	{
		super();
	}
	
	public Patient(String name) {
		super();
		this.name = name;
	}
	
	//
	// Setter()/Getter.
	//
	
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Set<Treatment> getTreatments() {
		return treatments;
	}
	public void setTreatments(Set<Treatment> treatments) {
		this.treatments = treatments;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//
	// Business Logic.
	//
	
	public ArrayList<Long> GetTreatmentIds()
	{
		ArrayList<Long> ids = new ArrayList<Long>();
		for (Treatment t : this.treatments)
			ids.add(t.getId());
		return ids;
	}
	
	//
	// For User Case 6.
	//
	
	public RadiologyTreatment AddRadiologyTreatment(EntityManager em)
	{
		TreatmentDAO treatmentDAO = new TreatmentDAO(em);
		return treatmentDAO.CreateRadiologyTreatment();
	}
	
	public void VisitTreatments (TreatmentVisitor v) {
		for ( Treatment t : treatments )
			t.Visit(v);
	}
	
	
}

