package stevens.cs.cs548.health;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RadDate
 *
 */
@Entity
@Table(name="RADDATE")
public class RadDate {
	
	@Id
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//private Date date;
	
	@ManyToOne
	@JoinColumn(name = "radiologytreatment_fk", referencedColumnName = "id")
	private RadiologyTreatment radiologyTreatment;
	public RadiologyTreatment getRadiologyTreatment() {
		return radiologyTreatment;
	}
	public void setRadiologyTreatment(RadiologyTreatment radiologyTreatment) {
		this.radiologyTreatment = radiologyTreatment;
	}

	private static final long serialVersionUID = 1L;

	public RadDate() {
		super();
	}
   
}
