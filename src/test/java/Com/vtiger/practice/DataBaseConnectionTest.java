package Com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseConnectionTest {
	
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet34ty","root","root");
		Statement Statement = connection.createStatement();
		ResultSet result = Statement.executeQuery("select * from sdet34ty");
		while(result.next())
		{
			System.out.println(result.getString(2));
		}
		}
	finally {
		connection.close();	
	}
}
}
