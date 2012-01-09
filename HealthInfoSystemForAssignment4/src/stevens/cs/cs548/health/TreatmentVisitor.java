package stevens.cs.cs548.health;

import java.util.Date;
import java.util.Set;

import com.sun.tools.javac.util.List;

public interface TreatmentVisitor
{
	public void VisitDrugTreatment(String drug, int dosage);
	public void VisitSurgery(Date date);
	public void VisitRadiology(Set<RadDate> dates);
}
