package stevens.cs.cs548.health;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

@NamedQuery(name = "findByName",
	query = "select p from Provider p where p.name = :name")
public class ProviderDAO {
	
	private EntityManager em;
	
	public ProviderDAO(EntityManager em)
	{
		this.em = em;
	}

	public Provider CreateProvider(String npi, String name, ProviderType pt, Clinic clinic)
	{
		em.getTransaction().begin();
		Provider p = Clinic.CreateProvider(ProviderType.Physician);
		em.persist(p);
		em.getTransaction().commit();
		return p;
	}
	
	public Set<Long> GetProviderIdSetByName(String name, Clinic clinic)
	{
		Set<Long> providerIdSet = new HashSet<Long>();
		Query query = em.createNamedQuery("findByName") .setParameter("name", name);
		Set<Provider> providerSet = (Set<Provider>) query.getResultList();
		for (Provider p : providerSet )
		{
			providerIdSet.add(p.getId());
		}
		return providerIdSet;
	}
	
	public Set<Provider> GetProviderSetByNpi(String name, Clinic clinic)
	{
		Set<Provider> providerSet = null;
		
		//....
		
		return providerSet;
	}
	
	public Physician CreatePhysician ()
	{
		Physician p = (Physician)Clinic.CreateProvider(ProviderType.Physician);
		return p;
	}
	
	public Radiologist CreateRadiologist()
	{
		Radiologist r = (Radiologist)Clinic.CreateProvider(ProviderType.Radiologist);
		return r;
	}
	
	public Surgeon CreateSurgeon()
	{
		Surgeon s = (Surgeon)Clinic.CreateProvider(ProviderType.Surgeon);
		return s;
	}
}
