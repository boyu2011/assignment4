package stevens.cs.cs548.health;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Provider
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PTYPE")
public abstract class Provider implements Serializable {
	
	//
	// Data members.
	//
	
	@Id
	@GeneratedValue
	private long id;
	
	private String npi;
	
	private String name;
	
	private String providerType;
	@Column(name="PTYPE", length=2)
	public String getProviderType() {
		return providerType;
	}
	
	@ManyToOne
	@JoinColumn(name = "clinic_fk", referencedColumnName = "id")
	private Clinic clinic;
	
	private static final long serialVersionUID = 1L;

	//
	// Constructors.
	//
	
	public Provider() {
		super();
	}
	
	//
	// Getter/Setter.
	//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNpi() {
		return npi;
	}

	public void setNpi(String npi) {
		this.npi = npi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clinic getClinic() {
		return clinic;
	}
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
}

enum ProviderType
{
	Physician,
	Surgeon,
	Radiologist
}
