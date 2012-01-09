package stevens.cs.cs548.health;

import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Radiologist
 *
 */
@Entity
@DiscriminatorValue("R")
public class Radiologist extends Provider {

	@OneToMany(mappedBy = "radiologist", targetEntity=stevens.cs.cs548.health.RadiologyTreatment.class)
	private Set<RadiologyTreatment> treatments;
	
	private static final long serialVersionUID = 1L;

	public Radiologist() {
		super();
	}
	
	public Set<RadiologyTreatment> getRadiologyTreatments() {
		return treatments;
	}
	public void setRadiologyTreatments(Set<RadiologyTreatment> radiologyTreatments) {
		this.treatments = treatments;
	}
}
