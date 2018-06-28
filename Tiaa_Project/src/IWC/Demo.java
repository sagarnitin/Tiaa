package IWC;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		
		ArrayList al=new ArrayList();
		ArrayList a2=new ArrayList();
		ArrayList jobname= new ArrayList();
		
		
		al.add("jobname1"+"instance1");
		al.add("jobname2"+"instance2");
		al.add("jobname3"+"instance3");
		al.add("jobname4"+"instance4");
		
		a2.add("jobname5"+"instance5");
		a2.add("jobname6"+"instance6");
		a2.add("jobname7"+"instance7");
		a2.add("jobname4"+"instance4");
		//System.out.println(a2.size());
		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j <a2.size(); j++) {
				
				if(al.get(i).equals(a2.get(j)))
				{
					
				break;
				}
				else if((j==a2.size()-1)&&(!(al.get(i).equals(a2.get(j)))))
				{
					jobname.add(al.get(i));
				}
				
				
			}
			
		}
		
		for (int j2 = 0; j2 < jobname.size(); j2++) {
			System.out.println(jobname.get(j2)+"               Y");
		}
	}
	
	
	
	
}
