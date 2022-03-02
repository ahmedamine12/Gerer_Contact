package ma.fstm.ilisi2.models.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBD {
	
  
public static Connection con ;

public static Connection getCon() 
{
	return con;
}
static {
	
try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ContactBD","root","");
		System.out.println("reussssssssssi");
	} catch (Exception e) {
		System.out.println("errrrrrrreur");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
