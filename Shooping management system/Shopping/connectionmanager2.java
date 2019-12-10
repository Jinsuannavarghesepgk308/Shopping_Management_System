package Shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionmanager2 {

	public Connection  getConnection() throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
//1)Register the Driver.
Class.forName("com.mysql.jdbc.Driver");//register a driver//Class.forName() method used to load the driver class;
	Connection con=null;//Connection object
//2)Create a Connection
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","");
	//object=class .method  (API:dataBase:/server name:Port Number/DB-Name,username,password) 
	if(con!=null)//Connection checking
	{
		return con;
	}
	else
	{

  return null;
	}
}
}