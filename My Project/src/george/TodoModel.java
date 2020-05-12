package george;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TodoModel {
	public String removeCategory(String catName)
	{
		
		if(!(checkIfCategoryExists(catName)))
		{
			return "category doesnt exist"; 
		}
		else
		{
			File file=new File(catName+".todo");
			file.delete();
			return "Category removed successfully";
		}
		
		
		
	}
	public boolean checkIfTaskExists(String catName,String taskName)
	{
		String line;
		BufferedReader br=null;
		try {
		if(!(checkIfCategoryExists( catName)))
		{
			System.out.println("Category only doesnt exist");
		}
		br=new BufferedReader(new FileReader(catName+".todo"));
		while((line=br.readLine())!=null)
		{
		String[] sa=line.split(":");
		if(sa[0].equals(taskName))
		{
			return true;
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br!=null)
			{
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
			return false;
	}
	public boolean checkIfCategoryExists(String catName)
	{
		
		return new File(catName+".todo").exists();
	}
	
	public String removeTask(String catName,String taskName)
	{ 	
	
	    if(!(checkIfCategoryExists(catName)))
		{
		 return "Category dont exist to remove your task";
		}
		File file=new File(catName+".todo");
		
		List<TaskBean> li=getTask(catName) ;
		file.delete();
		
		for (TaskBean task : li) {
		if(!(task.getTaskName().equals(taskName)))
				{
			    addTask(task, catName);
			    
				}
		}
		return "Task Successfully removed";
	}

	public String addTask(TaskBean task,String catName)
	{
		BufferedWriter bw=null;
		
		try {
			bw=new BufferedWriter(new FileWriter(catName+".todo",true));
			Date d = new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			String plDt = sdf.format(d); 
			bw.write(task.getTaskName()+":"+task.getDesc()+":"+plDt+":"+task.getPriority()+":"+task.getTags()+":"+d.getTime());
		    bw.newLine();
		    return "Success";
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return "Something bad happened the msg is "+e.getMessage();
			
		}
		finally {
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}	
		
	}
	@SuppressWarnings("resource")
	
	public List<TaskBean> searchTask(String search,String catName)
	{
		BufferedReader br=null;
		
		String line;
			try {
				List<TaskBean> tasks=new ArrayList<TaskBean>();
				TaskBean task;    
				br=new BufferedReader(new FileReader(catName+".todo"));
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				
				while((line=br.readLine())!=null)
				{
					String[] sa= line.split(":");

					try {
						task=new TaskBean(sa[0],sa[1],sdf.parse(sa[2]),Integer.parseInt(sa[3]),sa[4]);
						tasks.add(task);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("in NFE");
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("in PE");
						
					}
					
				}
				return tasks;
			}
			catch(IOException e)
			{
				e.printStackTrace();
				return null;
			}
			finally
			{
				if(br!=null)
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
			}
		
	}
	
	     
	public List<TaskBean> getTask(String catName){
	BufferedReader br=null;
	
	String line;
		try {
			List<TaskBean> tasks=new ArrayList<TaskBean>();
			TaskBean task;    
			br=new BufferedReader(new FileReader(catName+".todo"));
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			
			while((line=br.readLine())!=null)
			{
				String[] sa= line.split(":");

				try {
					task=new TaskBean(sa[0],sa[1],sdf.parse(sa[2]),Integer.parseInt(sa[3]),sa[4]);
					tasks.add(task);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("in NFE");
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("in PE");
					
				}
				
			}
			return tasks;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
			return null;
		}
		finally
		{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
		}
		
		//List<TaskBean> li=new ArrayList<TaskBean>();
		
	}
	
	
	public List<String> getSortedTaskname(String catName){
		BufferedReader br=null;
		String line;
		try {
			List<String> arr=new ArrayList<String>();
			TaskBean task;    
			br=new BufferedReader(new FileReader(catName+".todo"));
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			while((line=br.readLine())!=null)
			{
				String[] sa=line.split(":");
				arr.add(sa[0]);
			}
			Collections.sort(arr);
			return arr;
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally {
			if(br!=null)
			{
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

	public String update(TaskBean old, TaskBean neww)
	{
		return "";
	}
	
}
