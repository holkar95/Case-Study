package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public void getbyZipcode(String zip, int month, int year) throws SQLException {

		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp","root","root");

			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.prepareStatement(SqlFile.query1);

			// 2a. set the parameter;
			myStmt.setString(1, zip);
			myStmt.setInt(2, month);
			myStmt.setInt(3, year);//ADDED STATMENT FOR PARAMETR 3-CV

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println("Date" + "\t\t" +"CREDIT_CARD_NO" + "\t\t" + "CUST_SSN" + "\t" + "BRANCH_CODE"
				+ "\t" + "TRANSACTION_TYPE" + "\t" + "TRANSACTION_VALUE");//ADDED BY CV
				System.out.println(myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR")
						+ "\t" + myRs.getString("CREDIT_CARD_NO") + "\t" + myRs.getString("CUST_SSN")+ "\t" + myRs.getString("BRANCH_CODE")
						+ "\t\t" + myRs.getString("TRANSACTION_TYPE") + "\t\t\t" + myRs.getString("TRANSACTION_VALUE"));
			}
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR")
				+ "\t" + myRs.getString("CREDIT_CARD_NO") + "\t" + myRs.getString("CUST_SSN")+ "\t" + myRs.getString("BRANCH_CODE")
				+ "\t\t" + myRs.getString("TRANSACTION_TYPE") + "\t\t\t" + myRs.getString("TRANSACTION_VALUE"));
			}
		} 
		finally {
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
	public void getbyType(String type) throws SQLException {

		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp","root","root");

			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.prepareStatement(SqlFile.query2);

			// 2a. set the parameter;
			myStmt.setString(1, type);

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println("# of Transaction" + "\t" + "Transaction Amount");//ADDED BY CV   
				System.out.println(" " +myRs.getString("# of Transaction") + "\t\t\t" + myRs.getString("Transaction Amount"));
						
			}
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(" "+myRs.getString("# of Transaction") + "\t\t\t" + myRs.getString("Transaction Amount"));
				
			}
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			
		}

	}

	@Override
	public void getbyState(String state) throws SQLException {
		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp","root","root");

			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.prepareStatement(SqlFile.query3);

			// 2a. set the parameter;
			myStmt.setString(1, state);

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println("# of Transaction" + "\t" + "Transaction Amount");//ADDED BY CV   
				System.out.println(" " +myRs.getString("# of Transaction") + "\t\t\t" + myRs.getString("Transaction Amount"));
			}
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(" " +myRs.getString("# of Transaction") + "\t\t\t" + myRs.getString("Transaction Amount"));
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
}