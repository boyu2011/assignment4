package stevens.cs.cs548.health;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

@NamedQuery(name = "getTreatment",
query = "select t from Treatment, Patient where Treatment.PATIENT_FK = ")
public class TreatmentDAO {
	
	private EntityManager em;
	
	public TreatmentDAO ( EntityManager em) {
		this.em = em;
	}
	
	public RadiologyTreatment CreateRadiologyTreatment()
	{
		RadiologyTreatment rt = (RadiologyTreatment) Clinic.CreatTreatment(TreatmentType.RadiologyTreatment);
		return rt;
	}
	
	public Set<Treatment> GetTreatmentSet(Provider provider, Patient patient)
	{
		Set<Treatment> treatments = null;

		Query query =
			em.createNamedQuery("getTreatment") .setParameter(":provider_id", provider.getId()) .setParameter(":patient_id", patient.getId());
		return (Set<Treatment>) query.getResultList();
	}
}
