package stevens.cs.cs548.health;

import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Surgeon
 *
 */
@Entity
@DiscriminatorValue("S")
public class Surgeon extends Provider {

	@OneToMany(mappedBy = "surgeon", targetEntity=stevens.cs.cs548.health.SurgeryTreatment.class)
	private Set<SurgeryTreatment> surgeryTreatments;
	
	private static final long serialVersionUID = 1L;

	public Surgeon() {
		super();
	}

	public Set<SurgeryTreatment> getSurgeryTreatments() {
		return surgeryTreatments;
	}
	public void setSurgeryTreatments(Set<SurgeryTreatment> surgeryTreatments) {
		this.surgeryTreatments = surgeryTreatments;
	}
   
}
