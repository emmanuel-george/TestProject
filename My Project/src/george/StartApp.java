package george;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StartApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Scanner sc1= new Scanner(System.in);
		Scanner sc2= new Scanner(System.in);
		String catName,taskName,desc,tags,splDt;
		int priority;
		int ch1=0;
		int ch2 =0;
		int ch3=0;
		TodoModel model=new TodoModel();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Logger.getInstance().log("Starting task manager...");
		while(ch1!=7)
		{   
			System.out.println("");
			System.out.println("Press 1 to create a category");
			System.out.println("Press 2 to modify a category");
			System.out.println("Press 3 to remove a category");
			System.out.println("Press 4 to list a category");
			System.out.println("Press 5 to exit");
			while(!sc1.hasNextInt())
			{
				System.out.println("Enter integer input only boss!!!");
				sc1.next();
			}
			
			ch1=sc1.nextInt();
			switch(ch1)
			{
				case 1:      
					System.out.println("Creating Category..");
					System.out.println("Enter Category name");
					catName=sc2.nextLine();

/* Check 1:first check input validation*/
					while(!(TaskUtil.validateName(catName)))
					{
					
						System.out.println("Category must be single word,Start with alwtter,only alphanumeric.... Enter another Ca1tegoryname");
					catName=sc2.nextLine();
					}
					/* Check 2: bussiness validation ie whether already an category with same name exist */
					
					if(model.checkIfCategoryExists(catName))
					{
						System.out.println("You Duplicate enter Unique category name");
					}
					else
					{
						while(ch2!=6)
						{
							System.out.println("Press 1 to create a Task");
							System.out.println("Press 2 to update a Task");
							System.out.println("Press 3 to remove a Task");
							System.out.println("Press 4 to list a Task");
							System.out.println("Press 5 to Search a Task");
							System.out.println("Press 6 to go back");
							
							ch2= sc1.nextInt();
							
							switch(ch2)
							{
							
							case 1:
								Logger.getInstance().log("Creating Task....");
								System.out.println("Enter the task name");
								taskName=sc2.nextLine();
								
								while(!(TaskUtil.validateName(catName)))
								{
								
									System.out.println("Category must be single word,Start with alwtter,only alphanumeric.... Enter another Ca1tegoryname");
								taskName=sc2.nextLine();
								}
								System.out.println("Enter the description");
								desc=sc2.nextLine();
								System.out.println("Enter tags(comma separated)");
								tags=sc2.nextLine();
								System.out.println("Enter Planned End date(dd/mm/yyyy)");
								splDt=sc2.nextLine();
								
								System.out.println("Enter the priority(1-very low,10-very high");
								priority=sc1.nextInt();
								
								Date dt=sdf.parse(splDt);
								TaskBean bean = new TaskBean(taskName,desc,dt,priority,tags); 
								String result=model.addTask(bean,catName);
								if(result.contentEquals("Success"))
									System.out.println("Task "+taskName+" got added Successfully");
								else
									System.out.println("Task addition failed. the message is "+result);
								break;
								
							
							case 4: 
							
								List<TaskBean> tasks= model.getTask(catName);
							
								for ( TaskBean task : tasks) {
								
									System.out.println("Name: "+task.getTaskName()+" desc: "+task.getDesc()+" Planned Date: "+task.getPlannedDatet()+" Priority: "+task.getPriority()+" tags: "+task.getTags());
									
								}
									break;
							case 5:
								System.out.println("Enter the TaskName to search");
								String search=sc2.nextLine();
								System.out.println("Enter the Category Name ");
								String cateName=sc2.nextLine();
							List<TaskBean> li =model.searchTask(search, catName);
							for ( TaskBean task	 : li) {
								
								System.out.println("Name: "+task.getTaskName()+" desc: "+task.getDesc()+" Planned Date: "+task.getPlannedDatet()+" Priority: "+task.getPriority()+" tags: "+task.getTags());
								
							}
							
								
								break;
								
							case 6:   
								System.out.println("going back");
								break;
							
							
							}
							
						}
					}
					break;
				
				
				case 2:
					while(ch3!=3) {
					System.out.println("Press 1 to add a task into category");
					System.out.println("Press 2 to remove a task from category");
					System.out.println("Press 3 to update a task from category");
					System.out.println("Press 4 to go back");
					ch3=sc1.nextInt();
					
					
					switch(ch3)
					{
					
					case 1:
						System.out.println("Enter the category name to load");
					catName=sc2.nextLine();
					if(model.checkIfCategoryExists(catName)==false)
					{
						System.out.println("Category doesnt Exist you need to create new category ");
						break;
					}
					else
						System.out.println("Enter the task name");
					taskName=sc2.nextLine();
					System.out.println("Enter the description in single word");
					desc=sc2.nextLine();
					System.out.println("Enter tags(comma separated)");
					tags=sc2.nextLine();
					System.out.println("Enter Planned End date(dd/mm/yyyy)");
					splDt=sc2.nextLine();
					
					System.out.println("Enter the priority(1-very low,10-very high");
					priority=sc1.nextInt();
					
					Date dt1=sdf.parse(splDt);
					TaskBean bean1 = new TaskBean(taskName,desc,dt1,priority,tags); 
				if(	(model.addTask(bean1,catName)).equals("Success"))
				{
					System.out.println("Task added sucessfully");
				}
				else
					System.out.println(model.addTask(bean1,catName));
					
						break;
					
						
					case 2:
						System.out.println("Enter the Category name");
						catName=sc2.nextLine();
						System.out.println("Enter the task name");
						taskName=sc2.nextLine();
						System.out.println(model.removeTask(catName, taskName));
						break;
					case 3:
						System.out.println("Enter the category name");
						catName=sc2.nextLine();
						System.out.println("Enter the task name to remove");
						String removeTask=sc2.nextLine();
						System.out.println("Enter the task name to update");
						taskName=sc2.nextLine();
						System.out.println("Enter the description in single word");
						desc=sc2.nextLine();
						System.out.println("Enter tags(comma separated)");
						tags=sc2.nextLine();
						System.out.println("Enter Planned End date(dd/mm/yyyy)");
						splDt=sc2.nextLine();
						
						System.out.println("Enter the priority(1-very low,10-very high");
						priority=sc1.nextInt();
						
						Date dt=sdf.parse(splDt);
						TaskBean update = new TaskBean(taskName,desc,dt,priority,tags);
						if(model.checkIfTaskExists(catName, removeTask))
						{
								
						model.removeTask(catName, removeTask);
						model.addTask(update, catName);
						System.out.println("Task has been updated");
						}
						else
							System.out.println("task doesnt exist to update");
						break;
					case 4:
						System.out.println("Going back...");
						break;
					}
					}	
					break;
				case 3:
					System.out.println("Enter the category name to remove");
					catName=sc2.nextLine();
					System.out.println(model.removeCategory(catName));
					break;
               case 4: 
					System.out.println("Enter the category name");
					String name=sc2.nextLine();
					List<TaskBean> tasks= model.getTask(name);
				
					for ( TaskBean task : tasks) {
					
						System.out.println("Name: "+task.getTaskName()+" desc: "+task.getDesc()+" Planned Date: "+task.getPlannedDatet()+" Priority: "+task.getPriority()+" tags: "+task.getTags());
						
					}
						break;
               case 5:
					System.out.println("Exiting bye bye");
					break;
			    default:
			    	System.out.println("option not supported..");
			    	break;
				
			}
		}

	}
		catch(Throwable t)
		{
			t.printStackTrace();
		}

}
}
