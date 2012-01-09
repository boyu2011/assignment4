package stevens.cs.cs548.health;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SurgeryTreatment
 *
 */
@Entity
@DiscriminatorValue("S")
public class SurgeryTreatment extends Treatment {

	@Override
	public void Visit(TreatmentVisitor v) {
		///v.VisitSurgery(d);
	}
	
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "surgeon_fk", referencedColumnName = "id")
	private Surgeon surgeon;
	public Surgeon getSurgeon() {
		return surgeon;
	}
	public void setSurgeon(Surgeon surgeon) {
		this.surgeon = surgeon;
	}
	
	//debug
	//private Date d;
/*	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
*/
	
	private static final long serialVersionUID = 1L;

	public SurgeryTreatment() {
		super();
	}

}
