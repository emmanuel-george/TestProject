package george;

import java.util.Comparator;

public class TaskNameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {

		TaskBean t1=(TaskBean) o1;
		TaskBean t2=(TaskBean)o2;
		return t1.getTaskName().compareTo(t2.getTaskName());	}
	

}
