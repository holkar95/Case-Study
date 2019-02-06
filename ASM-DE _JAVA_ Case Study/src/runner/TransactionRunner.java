package runner;

import java.util.Arrays;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



import dao.TransactionDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;

public class TransactionRunner {

		
	public void method1() throws SQLException {
		int month=0, year=0;//ADDED BY CV
		String zip;
		String zipCodePattern = "\\d{5}?";//ADDED BY CV
	//	String monthPattern = "\\d{2}?";//ADDED BY CV
	//	String yearPattern = "\\d{4}?";//ADDED BY CV
		Boolean flag=false;
		Scanner input = new Scanner(System.in);

		String selection1 = "\nPlease enter a valid Zipcode. \n" + "";
		System.out.print(selection1);
		zip = input.next();
	
		
	while(zip.length() != 5 || !zip.matches(zipCodePattern)) //ADDED BY CV
 
			{
			System.out.print("************************************\n");
			System.out.print("***You have entered invalid Zipcode***\n");
			System.out.print("************************************\n");
			System.out.print(selection1);
			zip = input.next();
		}
		
		
	do// ADDED BY CV
	{
		try {// ADDED BY CV
		String selection2 = "\nPlease enter a valid Month as MM \n" + "";
		System.out.print(selection2);
		month = input.nextInt();
		
		while (month < 1 || month > 12 ) {
			System.out.print("************************************\n");
			System.out.print("***You have entered invalid Month***\n");
			System.out.print("************************************\n");
			System.out.print(selection2);
			month = input.nextInt();
		}
	
		flag = true;
		} catch (Exception e) {
			System.out.println(e );
			input.next();
			flag = false;
		}
	} while (flag == false);
		

	do// ADDED BY CV
	{
		try {// ADDED BY CV
		String selection3 = "\nPlease enter a valid year between "
				+ "1950 to 2018 as YYYY  \n" + "";
		System.out.print(selection3);
		year = input.nextInt();
		while (year < 1950 || year > 2018) {
			System.out.print("***********************************\n");
			System.out.print("***You have entered invalid Year***\n");
			System.out.print("***********************************\n");
			System.out.print(selection3);
			year = input.nextInt();
		}

		flag = true;
		} catch (Exception e) {
			System.out.println(e );
			input.next();
			flag = false;
		}
	} while (flag == false);
	
	
		TransactionDaoImpl TXDaoimpl1 = new TransactionDaoImpl();
		TXDaoimpl1.getbyZipcode(zip, month, year);
	} 

	public void method2() throws SQLException {
		 		
		String type, word;
		Boolean found;
		String text = "Education|Entertainment|Grocery|Gas|Bills|Test|Healthcare|education|entertainment|grocery|gas|bills|test|healthcare";//ADDED BY CV
		
		Scanner input = new Scanner(System.in);
		
		String selection1 = "\nPlease select and enter the type from the list below. \n" + "" 
		                   + "\n'Education', 'Entertainment', 'Grocery', 'Gas', 'Bills', 'Test', 'Healthcare'\n ";
		                  
		System.out.print(selection1);
		type = input.next();
		CharSequence inputStr = type;//ADDED BY CV 
        Pattern pattern = Pattern.compile(text);
        Matcher matcher = pattern.matcher(inputStr);
			
		while (!matcher.matches()) 
		{
			System.out.print("***********************************\n");
			System.out.print("***You have entered invalid Type***\n");
			System.out.print("***********************************\n");
			System.out.print(selection1);
			type = input.next();
			inputStr = type;//ADDED BY CV
            pattern = Pattern.compile(text);
            matcher = pattern.matcher(inputStr);
			
		}
		TransactionDaoImpl TXDaoimpl2 = new TransactionDaoImpl();
		TXDaoimpl2.getbyType(type);
		
	}

	
	public void method3() throws SQLException {
		//ADDED BY CV
		String expression = "AK|AL|AR|AZ|CA|CO|CT|DC|DE|FL|GA|HI|IA|ID|IL|IN|KS|KY|LA|MA|MD|ME|MI|MN|MO|MS|MT|NC|ND|NE|NH|NJ|NM|NV|NY|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VA|VT|WA|WI|WV|WY|ak|al|ar|az|ca|co|ct|dc|de|fl|ga|hi|ia|id|il|in|ks|ky|la|ma|md|me|mi|mn|mo|ms|mt|nc|nd|ne|nh|nj|nm|nv|ny|oh|ok|or|pa|ri|sc|sd|tn|tx|ut|va|vt|wa|wi|wv|wy";
        
	//	Boolean found;
		String state, word;
		Scanner input = new Scanner(System.in);

		String selection1 = "\nPlease enter a valid two character State code \n";
		                  
		System.out.print(selection1);
		state = input.next();
				
		CharSequence inputStr = state;//ADDED BY CV
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
       
        while (!matcher.matches()) {
			System.out.print("***********************************\n");
			System.out.print("***You have entered invalid state***\n");
			System.out.print("***********************************\n");
			System.out.print(selection1);
			state = input.next();
			inputStr = state;// ADDED BY CV
            pattern = Pattern.compile(expression);
            matcher = pattern.matcher(inputStr);
		
		}

		TransactionDaoImpl TXDaoimpl3 = new TransactionDaoImpl();
		TXDaoimpl3.getbyState(state);
	}
}