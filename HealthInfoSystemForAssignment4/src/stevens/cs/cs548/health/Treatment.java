package stevens.cs.cs548.health;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Treatment
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TTYPE")
public abstract class Treatment implements Serializable {
	
	//
	// Data members.
	//
	
	@Id
	@GeneratedValue
	private long id;
	
	private String treatmentType;
	@Column(name="TTYPE", length=2)
	public String getTreatmentType() {
		return treatmentType;
	}

	@ManyToOne
	@JoinColumn(name = "patient_fk", referencedColumnName = "id")
	private Patient patient;
	
	private static final long serialVersionUID = 1L;
	
	//
	// Constructors.
	//
	
	public Treatment() {
		super();
	}
	
	//
	// Getter/Setter.
	//

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public abstract void Visit(TreatmentVisitor v);
	
}

enum TreatmentType
{
	DrugTreatment,
	RadiologyTreatment,
	SurgeryTreatment
}


