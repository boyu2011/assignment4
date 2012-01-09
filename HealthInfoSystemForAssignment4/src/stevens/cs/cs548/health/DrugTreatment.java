package stevens.cs.cs548.health;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DrugTreatment
 *
 */
@Entity
@DiscriminatorValue("D")
public class DrugTreatment extends Treatment {
	
	//
	// data members.
	//
	
	private String drug;

	@ManyToOne
	@JoinColumn(name = "physician_fk", referencedColumnName = "id")
	private Physician physician;
	
	private int dosage;
	
	private static final long serialVersionUID = 1L;

	//
	// Constructor.
	//
	
	public DrugTreatment() {
		super();
	}

	//
	// Setter/Getter.
	//
	
	public String getDrug() {
		return drug;
	}
	public void setDrug(String drug) {
		this.drug = drug;
	}

	public int getDosage() {
		return dosage;
	}
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
	
	public Physician getPhysician() {
		return physician;
	}
	public void setPhysician(Physician physician) {
		this.physician = physician;
	}
   
	@Override
	public void Visit(TreatmentVisitor v) {
		v.VisitDrugTreatment(drug, dosage);
	}
}
