package fitandfun.model;

import java.time.LocalDate;
import java.util.Comparator;

public class ActivityComparator implements Comparator<Activity>{
	
	@Override
	public int compare(Activity a1, Activity a2)
	{
		LocalDate d1 = a1.getDate();
		LocalDate d2 = a2.getDate(); 
		return d1.compareTo(d2);
	}

}
