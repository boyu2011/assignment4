package stevens.cs.cs548.health;

import javax.persistence.EntityManager;

public class ClinicDAO {
	
	private EntityManager em;
	
	public ClinicDAO(EntityManager em)
	{
		this.em = em;
	}

	public Clinic CreateClinic(String name)
	{
		em.getTransaction().begin();
		Clinic c = ClinicFactory.CreateClinic(name);
		em.persist(c);
		em.getTransaction().commit();
		return c;
	}
	
}
