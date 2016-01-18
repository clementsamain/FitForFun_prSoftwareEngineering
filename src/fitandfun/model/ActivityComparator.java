package fitandfun.model;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * Comparator to Compare two Dates from Activity used in RecentActivities to
 * sort all Activities
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 *
 */
public class ActivityComparator implements Comparator<Activity> {

	@Override
	public int compare(Activity a1, Activity a2) {
		LocalDate d1 = a1.getDate();
		LocalDate d2 = a2.getDate();
		return d1.compareTo(d2);
	}
}