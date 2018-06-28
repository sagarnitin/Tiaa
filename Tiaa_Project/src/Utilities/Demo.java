package Utilities;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import IWC.IWCLogin;

public class Demo {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		TimerTask tt = new TimerTask(){
			public void run(){
				Calendar cal = Calendar.getInstance(); //this is the method you should use, not the Date(), because it is desperated.
 
				int hour = cal.get(Calendar.HOUR_OF_DAY);//get the hour number of the day, from 0 to 23
 
				IWCLogin login=new IWCLogin();
				login.openBrowser();
				login.login();
				login.Close();
			}
		};
		timer.schedule(tt, 1000, 1000*60);//	delay the task 1 second, and then run task every five seconds
		
	}

}
