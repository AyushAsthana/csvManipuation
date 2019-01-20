package com.test.TestProject;

/**
 * Main Class
 *
 */
public class App 
{
   
	public static void main( String[] args )
    {
     Result res=new Result();
  if(args.length<2) {
	  System.out.println("Provide file path and selection parameter(1--for accountAge , 2-- for account data fetch) .");
      return;
  }
  else if(args[1].equals("1")) {
	  res.generateAccountAge(args[0]);
  }
  else if(args[1].equals("2")) {
	  res.writeDataToJsonFile(args[0]);  
  }
  else {

	  System.out.println("Provide file path and selection parameter(1--for accountAge , 2-- for account data fetch) .");
  }
             
    }
    
}
