package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

	//private static final String FIRST_NAME = null;

	@Override
	public void CheckCustomer(String ssn) throws SQLException {

		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp","root","root");

			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			// myStmt = myConn.createStatement();
			myStmt = myConn.prepareStatement(SqlFile.query4);

			// 2a. set the parameter;
			myStmt.setString(1, ssn);

			// 3. Execute SQL query
			// myRs = myStmt.executeQuery("select * from school_customer");
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println("FIRST_NAME" + " \t" + "MIDDLE_NAME" + "\t "
						+ "LAST_NAME" + "\t " +"SSN" + "\t\t\t "
						+ "CREDIT_CARD_NO" + "\t\t" +"APT_NO" + " "
						);//ADDED BY CV
				System.out.println(myRs.getString("FIRST_NAME") + "\t\t " + myRs.getString("MIDDLE_NAME") + "\t "
						+ myRs.getString("LAST_NAME") + "\t\t " + myRs.getString("SSN") + "\t\t "
						+ myRs.getString("CREDIT_CARD_NO") + "\t " + myRs.getString("APT_NO") + "\t "
						);
			}
			// 4. Process the result set
			while (myRs.next()) { 
				System.out.println(myRs.getString("FIRST_NAME") + " " + myRs.getString("MIDDLE_NAME") + " "
						+ myRs.getString("LAST_NAME") + " " + myRs.getString("SSN") + " "
						+ myRs.getString("CREDIT_CARD_NO") + " " + myRs.getString("APT_NO") + " "
						);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}

	}

	@Override
	public void ModifyCustomerName(String SSN, String FIRST_NAME,String MIDDLE_NAME,String LAST_NAME ) throws SQLException {
			                       
		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp","root","root");

			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.prepareStatement(SqlFile.query5a);
	
			// 2a. set the parameter;
			
			myStmt.setString(1, FIRST_NAME);
			myStmt.setString(2, MIDDLE_NAME);//ADDED BY CV
			myStmt.setString(3, LAST_NAME);
			myStmt.setString(4, SSN);
			
									
			// 3. Execute SQL query
			int Rows = myStmt.executeUpdate();
	
		
			if (Rows == 0) {
				System.out.println("******************************************");
				System.out.println("There is no record for the SSN to update !");
				System.out.println("******************************************");
			} else {
				System.out.println( "Infromation  Updated for SSN " + SSN);
				System.out.println("FIRST_NAME" + " \t" + "MIDDLE_NAME" + "\t "	+ "LAST_NAME" + "\t " +"SSN" );//ADDED BY CV
				System.out.println(FIRST_NAME + "\t " + MIDDLE_NAME + "\t\t " + LAST_NAME + "\t\t" + SSN);//ADDED BY CV
					
			}
			
		}  finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}

	}

	@Override
	public void ModifyCustomerAdd(String SSN, String APT_NO, String STREET_NAME,String CUST_CITY, String CUST_STATE, String CUST_COUNTRY,
			String CUST_ZIP) throws SQLException {
		
	
	
		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp","root","root");

			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.prepareStatement(SqlFile.query5b);
	
			// 2a. set the parameter;
			
			
			myStmt.setString(1, APT_NO);
			myStmt.setString(2, STREET_NAME);
			myStmt.setString(3, CUST_CITY);//ADDED BY CV
			myStmt.setString(4, CUST_STATE);
			myStmt.setString(5, CUST_COUNTRY);
			myStmt.setString(6, CUST_ZIP);
			myStmt.setString(7, SSN);
									
			// 3. Execute SQL query
			int Rows = myStmt.executeUpdate();
	
		
			if (Rows == 0) {
				System.out.println("******************************************");
				System.out.println("There is no record for the SSN to update !");
				System.out.println("******************************************");
			} else {
				System.out.println( "Infromation  Updated for SSN " + SSN);
				System.out.println("APT_NO" + " \t" + "STREET_NAME" + "\t "	+ "CUST_CITY" +"\t "+ "CUST_STATE" +"\t "+ "CUST_COUNTRY" +"\t "+ "CUST_ZIP" + "\t " +"SSN" );//ADDED BY CV
				System.out.println(APT_NO + "\t " + STREET_NAME + "\t " + CUST_CITY  + "\t"+ CUST_STATE + "\t\t"+ CUST_COUNTRY + "\t\t"+ CUST_ZIP + "\t\t" + SSN );//ADDED BY CV
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}

	}

	
	@Override
	public void ModifyCustomerPhone(String SSN, String Phone) throws SQLException {
		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp","root","root");
			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.prepareStatement(SqlFile.query5c);
	
			// 2a. set the parameter;
			
			
			myStmt.setString(1, Phone);
			myStmt.setString(2, SSN);
									
			// 3. Execute SQL query
			int Rows = myStmt.executeUpdate();
	
		
			if (Rows == 0) {
				System.out.println("******************************************");
				System.out.println("There is no record for the SSN to update !");
				System.out.println("******************************************");
			} else {
				System.out.println( "Infromation  Updated for SSN " + SSN);
				System.out.println("Phone" + "\t\t"+"SSN" );//ADDED BY CV
				System.out.println(Phone + "\t\t" + SSN );//ADDED BY CV
			}
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}

	}

	@Override
	public void ModifyCustomerEmail(String SSN, String Email) throws SQLException {
		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp","root","root");
			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.prepareStatement(SqlFile.query5d);
	
			// 2a. set the parameter;
			
			
			myStmt.setString(1, Email);
			myStmt.setString(2, SSN);
									
			// 3. Execute SQL query
			int Rows = myStmt.executeUpdate();
	
		
			if (Rows == 0) {
				System.out.println("******************************************");
				System.out.println("There is no record for the SSN to update !");
				System.out.println("******************************************");
			} else {
				System.out.println( "Infromation  Updated for SSN " + SSN);
				System.out.println("Email" + "\t\t\t\t"+"SSN" );//ADDED BY CV
				System.out.println(Email + "\t\t" + SSN );//ADDED BY CV
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}

	}

	@Override
	public void GenerateBill(String creditCard, int month, int year) throws SQLException {

		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp","root","root");
			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.prepareStatement(SqlFile.query6);

			// 2a. set the parameter;
			myStmt.setString(1, creditCard);
			myStmt.setInt(2, month);
			myStmt.setInt(3, year);

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println("creditCard" +"\t\t" + "month" + "\t" + "year" +"\t" + "BILL");
				System.out.println(creditCard +"\t" + month + "\t" + year + "\t" + myRs.getString("BILL"));
			}
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("BILL"));

			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}

	}

	@Override
	public void DisplayTrans(String ssn, int frYear, int toYear, int frMonth,  int toMonth, int frDay, int toDay)
			throws SQLException {

			
		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp","root","root");
			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			// myStmt = myConn.createStatement();
			myStmt = myConn.prepareStatement(SqlFile.query7);

			// 2a. set the parameter;
			myStmt.setString(1, ssn);
			myStmt.setInt(2, frYear);
			myStmt.setInt(3, toYear);
			myStmt.setInt(4, frMonth);
			myStmt.setInt(5, toMonth);
			myStmt.setInt(6, frDay);
			myStmt.setInt(7, toDay);
			
			

			// 3. Execute SQL query
			// myRs = myStmt.executeQuery("select * from school_customer");
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println("TRANSACTION_ID"+ "\t" + "DATE" + "\t\t" + "CREDIT_CARD_NO"  + "\t\t" + "CUST_SSN" + "\t\t" + "BRANCH_CODE" + "\t\t" + "TRANSACTION_TYPE");
				System.out.println(myRs.getString("TRANSACTION_ID")+ "\t\t" + myRs.getString("MONTH") + "/"
				+ myRs.getString("DAY") + "/" + myRs.getString("YEAR") + "\t"  
				+ myRs.getString("CREDIT_CARD_NO") + "\t" + myRs.getString("CUST_SSN") + "\t\t"
				+ myRs.getString("BRANCH_CODE") + "\t\t\t" + myRs.getString("TRANSACTION_TYPE") + " "
				);
			}
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("TRANSACTION_ID")+ "\t\t" + myRs.getString("MONTH") + "/"
				+ myRs.getString("DAY") + "/" + myRs.getString("YEAR") + "\t"  
				+ myRs.getString("CREDIT_CARD_NO") + "\t" + myRs.getString("CUST_SSN") + "\t\t"
				+ myRs.getString("BRANCH_CODE") + "\t\t\t" + myRs.getString("TRANSACTION_TYPE") + " "
				);

			}
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}
	}
}