package stevens.cs.cs548.cliniclookup.domain;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ClinicDAO
 */
@Stateless(name="ClinicDAO")

public class ClinicDAO {

	@PersistenceContext(unitName="HealthInfoSystemForAssignment4")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ClinicDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public ClinicDAO(EntityManager em)
    {
    	this.em = em;
    }
    
    public String GetClinicURL(String clinicName)
    {
    	//...
    	return "http://www.example.org";
    }

}
