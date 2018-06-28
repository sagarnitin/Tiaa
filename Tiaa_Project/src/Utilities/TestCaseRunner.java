package Utilities;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class TestCaseRunner {
	
	public static TestConfig testconfig=new TestConfig();
	private static String testdatapath;
	private static String ScreenShotpath;
	
	public static void testTestNGprogramer(Class<?> className,String outputloc)
	{
		TestListenerAdapter tla =new TestListenerAdapter();
		TestNG testng=new TestNG();
		testng.setTestClasses(new Class[] {className});
		
		testng.setOutputDirectory(outputloc);
		testng.addListener(tla);
		testng.run();
	}
	

	public static void main(String[] args) {
		try
		{
			initConfig(args);
			testTestNGprogramer(Class.forName(getTestConfig().getTestcasename()),getTestConfig().getResultpath());
			
			
			
			
		}
		catch(Exception e)
		{   
			e.printStackTrace();
		}

	}


	public static void initConfig(String[] Configvalue) {
		
		String basepath=Configvalue[3];
		System.out.println(basepath);
		String resultpath=Configvalue[1]+"\\"+Configvalue[2];
		testconfig.setTestcasename(Configvalue[0]);
		testconfig.setResultpath(resultpath);
		testconfig.setBasepath(basepath);
		String env=ectractenvfromresultpath(resultpath);
		String testdatapath=basepath+"\\test-input\\TestData"+"_"+env+".xlsx";
		String configrationpath=basepath+"\\test-input\\config.xml";
		String ScreenShotpath=resultpath.replace("\\\\", "\\\\\\\\");
		ScreenShotpath=ScreenShotpath+"\\\\";
		testconfig.setEnv(env);
		testconfig.setConfigpath(configrationpath);
		testconfig.setTestdatapath(testdatapath);
		testconfig.setScreenshotpath(ScreenShotpath);
		TestCaseRunner.testdatapath=testconfig.getTestdatapath();
		TestCaseRunner.ScreenShotpath=testconfig.getScreenshotpath();
		
		
		
		
		
	}

	
	private static String ectractenvfromresultpath(String outputpath) {
		String env="";
		env=outputpath.substring(outputpath.indexOf("TestResults")+"TestResults".length()+1);
		env=env.substring(0,env.indexOf("\\"));
		if(outputpath.contains("ST2"))
			env="ST2";
		else if(outputpath.contains("ST4"))
			env="ST4";
		else if(outputpath.contains("ST4"))
			env="ATA";
		else if(outputpath.contains("ST4"))
			env="DEVINT2";
		else if(outputpath.contains("ST4"))
			env="ST4";
		else if(outputpath.contains("ST4"))
			env="CT";
		else if(outputpath.contains("ST4"))
			env="IT1";
		
			
		return env;
	}


	public static TestConfig getTestConfig()
	{
		return testconfig;
	}
}
