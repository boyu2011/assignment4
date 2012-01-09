package stevens.cs.cs548.health;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.tools.javac.util.List;

@NamedQuery(name = "findByName",
	query = "select p from Patient p where p.name = :name")
public class PatientDAO {

		private EntityManager em;
		
		public PatientDAO(EntityManager em) { this.em = em; }
		
		public Patient CreatePatient(String name, Clinic clinic)
		{
			Patient newPatient = Clinic.CreatePatient(name);
			newPatient.setName(name);
			newPatient.setClinic(clinic);
			em.getTransaction().begin();
			em.persist(newPatient);
			em.getTransaction().commit();
			return newPatient;
		}
		
		public Set<Patient> GetPatientAggregates(String name, Date birth)
		{
			Query query =
				em.createNamedQuery("findByName") .setParameter("name", name);
			return (Set<Patient>) query.getResultList();
		}
		
		public Patient GetPatient(String name)
		{
			Query query =
				em.createNamedQuery("findByName") .setParameter("name", name);
			List l = (List)query.getResultList();
			return (Patient)l.get(0);
		}
		
		public Patient GetPatient(long id)
		{
			return em.find(Patient.class, id);
		}
}
