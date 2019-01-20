	package com.test.TestProject;
	
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ClassPathUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
	
	public class Result {

		private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
		
		public void generateAccountAge(String path) {
			 File readFromFile = new File(path+"/Sales.csv");
			 File fileToUpdate = new File(path+"/SalesUpdated.csv");
	try(FileReader filereader = new FileReader(readFromFile); 
	    FileWriter fileWriter=new FileWriter(fileToUpdate);
	    BufferedReader br=new BufferedReader(filereader);
	    BufferedWriter bw=new BufferedWriter(fileWriter)) { 		
	         
			      String line=null;
		          bw.write(br.readLine()+","+"Acount Age");
		          bw.newLine();
		         while((line=br.readLine())!=null) {
		       	  line=line+","+computeaccountAge(line.split(",")[9]);
		       	 bw.write(line);
		         bw.newLine();
		         }
		         bw.flush();
		     	System.out.println("Account Age Column Added Successfully");
	   } 
	  catch (Exception e) { 
		  System.out.println("invalid file.");
	            e.printStackTrace(); 
	        }	
 
		}
		
		
	    
	    public String computeaccountAge(String date) throws ParseException {
	    
	    	Date date1=format.parse(date);
	    	
	    	Date currentDate=Calendar.getInstance().getTime();
	    	
	        long diff = currentDate.getTime() - date1.getTime();
		    long diffDays = diff / (24 * 60 * 60 * 1000);
	
			return diffDays + " days";
				
	    }
		
		public void writeDataToJsonFile(String path) {
	    
	    	ColumnPositionMappingStrategy<Object> strat = new ColumnPositionMappingStrategy<Object>();
	    	strat.setType(Accounts.class);
	    	String[] columns = new String[] {"transactionDate", "product","price","paymentType",
	    			"name","city","state","country","accountCreated","lastLogin","latitude","longitude"}; 
	    	
	    	strat.setColumnMapping(columns);
	        File accountJsonFile=new File(path+"/AccountDetailsJSON.txt");
	        File readFromFile = new File(path+"/Sales.csv");
	    	CsvToBean csv = new CsvToBean();
	    	try( FileWriter fileWriter=new FileWriter(accountJsonFile);) {
	    		
	    		CSVReaderBuilder csvReaderBuilder=new CSVReaderBuilder(new FileReader(readFromFile));
	    		csvReaderBuilder.withSkipLines(1);
	    		CSVReader csvReader=csvReaderBuilder.build();
	    		csv.setCsvReader(csvReader);
	    		csv.setMappingStrategy(strat);
	    		List<Accounts> accountsList=csv.parse();
	    		List<Accounts> filteredAccounts = accountsList.stream()                // convert list to stream
	                    .filter(account ->{
							try {
								return format.parse(account.getAccountCreated()).before(format.parse("01/01/09"));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							return false;
						})
	                    .collect(Collectors.toList()); 	
	    		
	    		ObjectMapper objectMapper = new ObjectMapper();
	  
	        	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	        
	        	fileWriter.write(objectMapper.writeValueAsString(filteredAccounts));
	        	System.out.println("Accounts Details Generated Successfully");
	    	}
	    	catch(Exception e) {
	    		 System.out.println("invalid file.");
	    		e.printStackTrace(); 
	    	}
	    }
	    
	    
	}
