package george;

import java.util.Date;

public class TaskBean {
	private String taskName;
	private String desc;
	private Date plannedDatet;
	//private Date end_dt;
	private	int  priority;
//	String status;
	private	String tags;
	
	public TaskBean()
	{
		
	}
	
	
	public TaskBean(String taskName, String desc, Date plannedDatet, int priority, String tags) {
		
		this.taskName = taskName;
		this.desc = desc;
		this.plannedDatet = plannedDatet;
		this.priority = priority;
		this.tags = tags;
	}


	


	@Override
	public String toString() {
		return "TaskBean [taskName=" + taskName + ", desc=" + desc + ", plannedDatet=" + plannedDatet + ", priority="
				+ priority + ", tags=" + tags + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((plannedDatet == null) ? 0 : plannedDatet.hashCode());
		result = prime * result + priority;
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskBean other = (TaskBean) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (plannedDatet == null) {
			if (other.plannedDatet != null)
				return false;
		} else if (!plannedDatet.equals(other.plannedDatet))
			return false;
		if (priority != other.priority)
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (taskName == null) {
			if (other.taskName != null)
				return false;
		} else if (!taskName.equals(other.taskName))
			return false;
		return true;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getPlannedDatet() {
		return plannedDatet;
	}
	public void setPlannedDatet(Date plannedDatet) {
		this.plannedDatet = plannedDatet;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	

}
