package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class TestJDBCNonSelectQuery {

	public static void main(String[] args) throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");

		Statement stat = conn.createStatement();

		String query = "insert into student(first_name,last_name,address)values('pavan','BN','INDIA')";

		int result = stat.executeUpdate(query);

		if(result==1) {
			System.out.println("User is Created");
		}
		else {
			System.out.println("User is not Created");
		}
		conn.close();
	}

}
