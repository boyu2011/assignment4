package stevens.cs.cs548.health;

import java.util.Set;

import javax.persistence.*;

import com.sun.tools.javac.util.List;

/**
 * Entity implementation class for Entity: RadiologyTreatment
 *
 */
@Entity
@DiscriminatorValue("R")
public class RadiologyTreatment extends Treatment {
	
	@Override
	public void Visit(TreatmentVisitor v) {
		v.VisitRadiology(dates);
	}
	
	private String type;
	
	@OneToMany(mappedBy = "radiologyTreatment", targetEntity=stevens.cs.cs548.health.RadDate.class)
	private Set<RadDate> dates;	// must be Set? how is List??
	public Set<RadDate> getDates() {
		return dates;
	}
	public void setDates(Set<RadDate> dates) {
		this.dates = dates;
	}
	
	@ManyToOne
	@JoinColumn(name = "radiologist_fk", referencedColumnName = "id")
	private Radiologist radiologist;
	public Radiologist getRadiologist() {
		return radiologist;
	}
	public void setRadiologist(Radiologist radiologist) {
		this.radiologist = radiologist;
	}
	
	private static final long serialVersionUID = 1L;

	public RadiologyTreatment() {
		super();
	}

}
