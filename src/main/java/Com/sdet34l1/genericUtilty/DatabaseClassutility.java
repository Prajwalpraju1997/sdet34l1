package Com.sdet34l1.genericUtilty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

/**
 * This class contains all common action releted to database
 * @author PRAJWAL
 *
 */

public class DatabaseClassutility {
	
	static  Connection connection;
	static Statement statement;
	
	/**
	 * This method is used to open the database connection and intialize the connection
	 * @throws SQLException
	 */
	
	public static void openDBConnection(String dBUrl, String dbUserName, String dbPassword) throws SQLException {

		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		  connection=DriverManager.getConnection(dBUrl,dbUserName,dbPassword);
	      statement = connection.createStatement();
	}
	
	/**
	 * This method is used to fetch the data from database/to do the DQL actions on database
	 * @param qurey
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	
	public static ArrayList<String> getDataFromDataBase(String qurey, String columnName) throws SQLException
	{
	ArrayList<String> list = new ArrayList<>();
	ResultSet result = statement.executeQuery(qurey); 
	while(result.next())
	{
		list.add(result.getString(columnName));
	}
	return list;
	}
	
	/**
	 * This method is used to validate the data wheather it is present in database or not
	 * @param qurey
	 * @param columnName
	 * @param expecteddata
	 * @return
	 * @throws SQLException
	 */
	public static boolean validateDataInDatabase(String qurey, String columnName, String expecteddata) throws SQLException {
		
		ArrayList<String> list=getDataFromDataBase(qurey, columnName);
		boolean flag = false;
		for(String actualData:list)
		{
			if(actualData.equalsIgnoreCase(expecteddata)) {
				flag=true;
				break;
			}
			}
		return flag;
		}
	
/**
 * This method is used to store/modifiy/insert/delete the data in database/to do the DML and DDl actions on database	
 * @param qurey
 * @throws SQLException
 */
public static void setDataInDataBase(String qurey) throws SQLException {

	int result = statement.executeUpdate(qurey);
	if(result>1) {
		System.out.println("Data entered/modified successfully");
	}
}
/**
 * This method is used to close the database
 */
	
	public static void closeDBConnection() {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("while closing the database connection we got exception");
		}	
	}
}
	