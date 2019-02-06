package runner;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.CustomerDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRunner {

	public void method1() throws SQLException {
		String ssn;
		String ssnPattern = "\\d{9}?";// ADDED BY CV

		String selection1 = "\nPlease enter a valid Social Security Number \n" + "";
		System.out.print(selection1);
		Scanner input = new Scanner(System.in);
		ssn = input.next();
		while (ssn.length() != 9 || !ssn.matches(ssnPattern)) // ADDED SSN VALIDATION --CV
		{
			System.out.print("************************************\n");
			System.out.print("***You have entered invalid SSN***\n");
			System.out.print("************************************\n");
			System.out.print(selection1);
			ssn = input.next();
		}

		CustomerDaoImpl CustDaoimpl1 = new CustomerDaoImpl();
		CustDaoimpl1.CheckCustomer(ssn);
	}

	public void method2() throws SQLException {
		Boolean found;
		Boolean flag = false;//ADDED BY CV
		String CUST_ZIP, CUST_PHONE;
		String FIRST_NAME, MIDDLE_NAME, LAST_NAME, CREDIT_CARD_NO, APT_NO, STREET_NAME, CUST_CITY, CUST_STATE;
		String CUST_COUNTRY, CUST_EMAIL, SSN;
		String validcustinfo = "^[a-zA-Z\\\\s]*$";// ADDED BY CV

		int menu = 0;//ADDED BY CV
		String expression = "AK|AL|AR|AZ|CA|CO|CT|DC|DE|FL|GA|HI|IA|ID|IL|IN|KS|KY|LA|MA|MD|ME|MI|MN|MO|MS|MT|NC|ND|NE|NH|NJ|NM|NV|NY|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VA|VT|WA|WI|WV|WY|ak|al|ar|az|ca|co|ct|dc|de|fl|ga|hi|ia|id|il|in|ks|ky|la|ma|md|me|mi|mn|mo|ms|mt|nc|nd|ne|nh|nj|nm|nv|ny|oh|ok|or|pa|ri|sc|sd|tn|tx|ut|va|vt|wa|wi|wv|wy";

		Scanner input = new Scanner(System.in);

		String selection1 = "\nPlease enter a valid Social Security Number to modify the record \n" + "";
		System.out.print(selection1);
		SSN = input.next();
		String ssnPattern = "\\d{9}?";// ADDED BY CV
		String zipCodePattern = "\\d{5}?";// ADDED BY CV
		String phonePattern = "\\d{7}?";// ADDED BY CV
		String emailPattern = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";// ADDED BY CV

		while (SSN.length() != 9 || !SSN.matches(ssnPattern)) {// ADDED BY CV
			System.out.print("*************************************\n");
			System.out.print("***You have entered invalid Number***\n");
			System.out.print("*************************************\n");
			System.out.print(selection1);
			SSN = input.next();
		} // try catch needs to be added
		String selection = "\nSelect the number from the following menu you would like to modify. \n \n"
				+ "1. Name Fields \n" + "2. Address \n" + "3. Phone \n" + "4. Email \n";

		do// ADDED BY CV
		{
			try {
				System.out.print(selection);
				menu = input.nextInt();
				input.nextLine();

				while (menu < 1 || menu > 4) {
					System.out.print("******************************************\n");
					System.out.print("*** You have entered invalid selection ***\n");
					System.out.print("******************************************\n");
					System.out.print(selection);
					menu = input.nextInt();
					input.nextLine();
				}

				flag = true;
			} catch (Exception e) {
				System.out.println(e + "Please enter correct number from 1 to 4");
				input.next();
				flag = false;
			}
		} while (flag == false);// ADDED BY CV

		switch (menu) {
		case 1:
			System.out.print("Enter First Name: ");
			FIRST_NAME = input.next();
			while (!FIRST_NAME.matches(validcustinfo)) {// ADDED BY CV
				System.out.print("************************************\n");
				System.out.print("***You have entred invalid first name ***\n");
				System.out.print("************************************\n");
				System.out.print("Enter First Name: ");
				FIRST_NAME = input.next();
			}
			System.out.print("Enter Middle Name: ");
			MIDDLE_NAME = input.next();
			while (!MIDDLE_NAME.matches(validcustinfo)) {// ADDED BY CV
				System.out.print("************************************\n");
				System.out.print("***You have entred invalid middle name ***\n");
				System.out.print("************************************\n");
				System.out.print("Enter Middle Name: ");
				MIDDLE_NAME = input.next();
			}
			System.out.print("Enter Last Name: ");
			LAST_NAME = input.next();
			while (!LAST_NAME.matches(validcustinfo)) {// ADDED BY CV
				System.out.print("************************************\n");
				System.out.print("***You have entred invalid last name ***\n");
				System.out.print("************************************\n");
				System.out.print("Enter Last Name: ");
				LAST_NAME = input.next();
			}
			CustomerDaoImpl CustDaoimpl2a = new CustomerDaoImpl();
			CustDaoimpl2a.ModifyCustomerName(SSN, FIRST_NAME, MIDDLE_NAME, LAST_NAME);
			break;
		case 2:
			System.out.print("Enter Apartment NO: ");
			APT_NO = input.nextLine();
			System.out.print("Enter Street Name: ");
			STREET_NAME = input.nextLine();
			System.out.print("Enter City: ");
			CUST_CITY = input.nextLine();
			while (!CUST_CITY.matches(validcustinfo)) {// ADDED BY CV
				System.out.print("************************************\n");
				System.out.print("***You have entred invalid city***\n");
				System.out.print("************************************\n");
				System.out.print("Enter City: ");
				CUST_CITY = input.nextLine();
			}
			System.out.print("Enter State: ");
			CUST_STATE = input.nextLine();
			CharSequence inputStr = CUST_STATE;
			Pattern pattern = Pattern.compile(expression);
			Matcher matcher = pattern.matcher(inputStr);

			while (!matcher.matches()) {
				System.out.print("************************************\n");
				System.out.print("***You have entered invalid State***\n");
				System.out.print("************************************\n");
				System.out.print("Enter State: ");
				CUST_STATE = input.nextLine();
				inputStr = CUST_STATE;
				pattern = Pattern.compile(expression);
				matcher = pattern.matcher(inputStr);
			}

			System.out.print("Enter Country: ");
			CUST_COUNTRY = input.nextLine();

			while (!CUST_COUNTRY.matches(validcustinfo)) {// ADDED BY CV
				System.out.print("************************************\n");
				System.out.print("***You have entred invalid country***\n");
				System.out.print("************************************\n");
				System.out.print("Enter Country: ");
				CUST_COUNTRY = input.nextLine();
			}
			System.out.print("Enter Zip: ");
			CUST_ZIP = input.next();
			while (CUST_ZIP.length() != 5 || !CUST_ZIP.matches(zipCodePattern)) {// ADDED BY CV
				System.out.print("****************************************\n");
				System.out.print("***You have entered invalid zip code ***\n");
				System.out.print("****************************************\n");
				System.out.print("Enter Zip: ");
				CUST_ZIP = input.next();
			}
			CustomerDaoImpl CustDaoimpl2b = new CustomerDaoImpl();
			CustDaoimpl2b.ModifyCustomerAdd(SSN, APT_NO, STREET_NAME, CUST_CITY, CUST_STATE, CUST_COUNTRY, CUST_ZIP);
			break;
		case 3:
			System.out.print("Enter 7 digit Phone number: ");
			CUST_PHONE = input.next();
			while (CUST_PHONE.length() != 7 || !CUST_PHONE.matches(phonePattern)) {
				System.out.print("********************************************\n");
				System.out.print("***You have entered invalid Phone number ***\n");
				System.out.print("********************************************\n");
				System.out.print("Enter Phone number:  ");
				CUST_PHONE = input.next();
			}
			CustomerDaoImpl CustDaoimpl2c = new CustomerDaoImpl();
			CustDaoimpl2c.ModifyCustomerPhone(SSN, CUST_PHONE);
			break;
		case 4:
			System.out.print("Enter Email: ");
			CUST_EMAIL = input.next();
			while (!CUST_EMAIL.matches(emailPattern)) {// ADDED BY CV
				System.out.print("*************************************\n");
				System.out.print("***You have entered invalid emailr***\n");
				System.out.print("*************************************\n");
				System.out.print("Enter Email: ");
				CUST_EMAIL = input.next();
			}
			CustomerDaoImpl CustDaoimpl2d = new CustomerDaoImpl();
			CustDaoimpl2d.ModifyCustomerEmail(SSN, CUST_EMAIL);
			break;
		default:
			System.out.println("It is not a correct #");
		}
	}

	public void method3() throws SQLException {
		String creditCard;
		int month =0, year=0;//ADDED BY CV
		String ccPattern = "^[0-9]{16}?";
		Scanner input = new Scanner(System.in);
		Boolean flag = false;//ADDED BY CV

		String selection1 = "\nPlease enter a valid Credit Card Number \n" + "";
		System.out.print(selection1);
		creditCard = input.next();

		while (creditCard.length() != 16 || !creditCard.matches(ccPattern)) {
			System.out.print("*************************************\n");
			System.out.print("***You have entered invalid Number***\n");
			System.out.print("*************************************\n");
			System.out.print(selection1);
			creditCard = input.next();
		}

		do// ADDED BY CV
		{
			try {// ADDED BY CV
				String selection2 = "\nPlease enter a valid Month as MM \n" + "";
				System.out.print(selection2);
				month = input.nextInt();
				while (month < 1 || month > 12) {
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
				String selection3 = "\nPlease enter a valid year between " + "1950 to 2018 as YYYY  \n" + "";
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
				System.out.println(e); 
			//	System.out.println(" Please enter correct Valid Year");
				input.next();
				flag = false;
			}
		} while (flag == false);

		CustomerDaoImpl CustDaoimpl3 = new CustomerDaoImpl();
		CustDaoimpl3.GenerateBill(creditCard, month, year);
	}

	
	public void method4() throws SQLException {
		String ssn;
		int fromYear=0, toYear=0, fromMonth=0, toMonth=0, fromDay=0, toDay=0;//ADDED BY CV
		String ssnPattern = "\\d{9}?";// ADDED BY CV
		Scanner input = new Scanner(System.in);
		Boolean flag=false;

		String selection1 = "\nPlease enter a valid Social Security Number \n" + "";
		System.out.print(selection1);
		ssn = input.next();

		while (ssn.length() != 9 || !ssn.matches(ssnPattern)) { // ADDED SSN VALIDATION --CV
			System.out.print("*************************************\n");
			System.out.print("***You have entered invalid Number***\n");
			System.out.print("*************************************\n");
			System.out.print(selection1);
			ssn = input.next();
		}
		
		do// ADDED BY CV
		{	
		try {// ADDED BY CV
			String selection2 = "\nPlease enter a valid year between " + "1950 to 2018 as YYYY from  \n" + "";
			System.out.print(selection2);

			fromYear = input.nextInt();
			while (fromYear < 1950 || fromYear > 2018) {
				System.out.print("***********************************\n");
				System.out.print("***You have entered invalid Year***\n");
				System.out.print("***********************************\n");
				System.out.print(selection2);
				fromYear = input.nextInt();
			}
				
		flag = true;
	} catch (Exception e) {
		System.out.println(e); 
	//	System.out.println(" Please enter correct  Valid From Year");
		input.next();
		flag = false;
	}
} while (flag == false);
			// ENTER CHECK FOR TO AND FROM YEAR-CV
		do// ADDED BY CV
		{	
		try {// ADDED BY CV
			String selection3 = "\nPlease enter a valid year between " + "1950 to 2018 as YYYY to \n" + "";
			System.out.print(selection3);
			toYear = input.nextInt();
			while (toYear < 1950 || toYear > 2018) {
				System.out.print("***********************************\n");
				System.out.print("***You have entered invalid Year***\n");
				System.out.print("***********************************\n");
				System.out.print(selection3);
				toYear = input.nextInt();
			}
			
			flag = true;
		} catch (Exception e) {
			System.out.println(e); 
	//		System.out.println(" Please enter correct  Valid To Year");
			input.next();
			flag = false;
		}
	} while (flag == false);

		// ENTER CHECK FOR TO AND FROM Months-CV
		
		do// ADDED BY CV
		{	
		try {//ADDED BY CV
			String selection4 = "\nPlease enter a valid Month as MM from \n" + "";
			System.out.print(selection4);
			fromMonth = input.nextInt();
			while (fromMonth < 1 || fromMonth > 12) {
				System.out.print("************************************\n");
				System.out.print("***You have entered invalid Month***\n");
				System.out.print("************************************\n");
				System.out.print(selection4);
				fromMonth = input.nextInt();
			}
			flag = true;
		} catch (Exception e) {
			System.out.println(e); 
		//	System.out.println(" Please enter correct  Valid from Month");
			input.next();
			flag = false;
		}
	} while (flag == false);
			
								
		do// ADDED BY CV
		{	
		try {//ADDED BY CV
			String selection5 = "\nPlease enter a valid Month as MM to \n" + "";
			System.out.print(selection5);
			toMonth = input.nextInt();
			while (toMonth < 1 || toMonth > 12) {
				System.out.print("************************************\n");
				System.out.print("***You have entered invalid Month***\n");
				System.out.print("************************************\n");
				System.out.print(selection5);
				toMonth = input.nextInt();
			}
		flag = true;
	} catch (Exception e) {
		System.out.println(e); 
	//	System.out.println(" Please enter correct Valid to Month");
		input.next();
		flag = false;
	}
} while (flag == false);
			
		// ENTER CHECK FOR TO AND FROM DAYS-CV
		do// ADDED BY CV
		{	
		try {//ADDED BY CV		
			
			String selection6 = "\nPlease enter a valid Day as DD from \n" + "";
			System.out.print(selection6);
			fromDay = input.nextInt();
			while (fromDay < 1 || fromDay > 31) {
				System.out.print("************************************\n");
				System.out.print("***You have entered invalid Day ***\n");
				System.out.print("************************************\n");
				System.out.print(selection6);
				fromDay = input.nextInt();
			}
			flag = true;
		} catch (Exception e) {
			System.out.println(e); 
		//	System.out.println(" Please enter correct Valid from Day");
			input.next();
			flag = false;
		}
	} while (flag == false);
						
		do// ADDED BY CV
		{	
		try {//ADDED BY CV		
			
			String selection7 = "\nPlease enter a valid Day as DD to \n" + "";
			System.out.print(selection7);
			toDay = input.nextInt();
			while (toDay < 1 || toDay > 31) {
				System.out.print("************************************\n");
				System.out.print("***You have entered invalid Day ***\n");
				System.out.print("************************************\n");
				System.out.print(selection7);
				toDay = input.nextInt();
			}
			flag = true;
		} catch (Exception e) {
			System.out.println(e); 
		//	System.out.println(" Please enter correct Valid to Day");
			input.next();
			flag = false;
		}
	} while (flag == false);
		
			CustomerDaoImpl CustDaoimpl4 = new CustomerDaoImpl();
			CustDaoimpl4.DisplayTrans(ssn, fromYear, toYear, fromMonth, toMonth, fromDay, toDay);

		} 

	}
