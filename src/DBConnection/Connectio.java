package DBConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectio extends Config {
 Connection con;
 
 public Connection getConnection() throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 String str="jdbc:mysql://"+Config.dbhost+":"+Config.dbport+"/"+Config.dbname+"?"+Config.dbSSL;
	 //jdbc:mysql://localhost:3306/myfirstproject?user=root&SSL=DHE-RSA-AES128-GCM-SHA256
	 con= DriverManager.getConnection(str);
	 
	 return con;
	 
 }
}
