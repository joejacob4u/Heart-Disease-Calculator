import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Database {
	
	
	public void insDatabase(int sex,int age,int chest,int chol,int pressure,int sugar,int heartbeat,int disease,String dbs)
	{
		
		Connection con = null;
    	String url = "jdbc:mysql://localhost:8889/";
    	String db = "Health";
    	String driver = "com.mysql.jdbc.Driver";
    	String user = "root";
    	String pass = "root";
    	try{
	    	Class.forName(driver);
	    	con = DriverManager.getConnection(url+db, user, pass);
	    	Statement st = con.createStatement();
	    	if(dbs.contains("Training"))
	    	st.executeUpdate("INSERT INTO "+dbs+" " + "VALUES ('"+age+"','"+sex+"','"+chest+"','"+pressure+"','"+chol+"','"+sugar+"','"+heartbeat+"','"+disease+"')");
	    	else
	    		st.executeUpdate("INSERT INTO "+dbs+" " + "VALUES ('"+age+"','"+sex+"','"+chest+"','"+pressure+"','"+chol+"','"+sugar+"','"+heartbeat+"','"+disease+"')");
	    		
	}
    	catch(Exception e){
	    	System.out.println(e.getMessage());
	    	}

}
	
}
