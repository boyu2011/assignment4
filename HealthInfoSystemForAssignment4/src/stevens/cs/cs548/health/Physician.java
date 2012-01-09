package stevens.cs.cs548.health;

import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Physician
 *
 */
@Entity
@DiscriminatorValue("P")
public class Physician extends Provider {
	
	//
	// Data members.
	//
	
	@OneToMany(mappedBy = "physician", targetEntity=stevens.cs.cs548.health.DrugTreatment.class)
	private Set<DrugTreatment> drugTreatments;
	
	private static final long serialVersionUID = 1L;

	//
	// Constructor.
	//
	
	public Physician() {
		super();
	}

	//
	// Getter/Setter.
	//
	
	public Set<DrugTreatment> getDrugTreatments() {
		return drugTreatments;
	}
	public void setDrugTreatments(Set<DrugTreatment> drugTreatments) {
		this.drugTreatments = drugTreatments;
	}
   
}
