package stevens.cs.cs548.cliniclookup.service.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import stevens.cs.cs548.cliniclookup.domain.ClinicDAO;

/**
 * Session Bean implementation class ClinicLookupEJB
 */
@Stateless(name="ClinicLookupBean")

public class ClinicLookupEJB implements IClinicLookupRemote, IClinicLookupLocal {

	@EJB(beanName="ClinicDAO")
	ClinicDAO clinicDAO;
	
    /**
     * Default constructor. 
     */
    public ClinicLookupEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public String GetClinicURL(String clinicName)
    {
    	return clinicDAO.GetClinicURL(clinicName);
    }

}
