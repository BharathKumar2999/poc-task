import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Student1 {
	public static void main(String[] args) throws Exception{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		 FileReader fr=new FileReader("C:\\Users\\B.Seenivasan\\Downloads\\POC-Data\\input.txt");    
		   BufferedReader br =   new BufferedReader(fr);
		try {	
	  
       //int i;    
		//while((i=fr.read())!=-1)    
      // System.out.print((char)i);    
		 //fr.close();    
			Class.forName("com.mysql.cj.jdbc.Driver");

		String st;
		while((st = br.readLine() ) != null)  
	     {
		
		System.out.println(st);
		String[] fileData = st.split("	");
		//System.out.println(fileData[0]);
		int studentId = Integer.valueOf(fileData[0]);
		String fullName = fileData[1];
		String lastName = fileData[2];
		String departmentId = fileData[3];
		String joiningDate = fileData[4];
		String studentDob = fileData[5];
		String mobileNo = fileData[6];
		String email = fileData[7];

	

		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";		
		String pass = "student";
		String query = " insert into demo.student (studentId, fullName, lastName, departmentId, joiningDate, studentDob, mobileNo, email)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
		myConn = DriverManager.getConnection(dbUrl, user, pass);
		PreparedStatement ps = myConn.prepareStatement(query);
		ps.setInt(1, studentId);
		ps.setString(2, fullName);
		ps.setString(3, lastName);
		ps.setString(4, departmentId);
		ps.setString(5, "2021-01-01");
		//ps.setString(5, joiningDate);
		ps.setString(6, studentDob);
		ps.setString(7, mobileNo);
		ps.setString(8, email);
		
		ps.execute();
		ps.close();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
		fr.close();br.close();	
		}
		/*try {
		  String dbUrl="";
			String user="";
			String pass="";
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from employees");
			
			// 4. Process the result set
			while (myRs.next()) {
				
			}
		}
		catch (Exception exc) {
			//exc.printStackTrace();
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
		}*/
	}