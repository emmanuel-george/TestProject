package george;

import java.util.Comparator;

public class plannedDateComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		TaskBean t1=(TaskBean) o1;
		TaskBean t2=(TaskBean) o2;
		if((t1.getPlannedDatet()).before(t2.getPlannedDatet()))
		{
		return -1;
	    }
		else if ((t1.getPlannedDatet()).after(t2.getPlannedDatet()))
		{
		return 1;
	    }
		else
			return 0;
	}
}
