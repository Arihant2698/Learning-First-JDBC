import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	public static String driver="com.mysql.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/test";
	public static String username="root";
	public static String pass="root";
	public  void readAllUser() throws SQLException {
		Connection con = DriverManager.getConnection(url, username, pass);
		
		Statement stmt= con.createStatement();
		
		String sql="Select * From user";
		ResultSet rs=  stmt.executeQuery(sql);
		con.close();
		while(rs.next()) {
			int id=rs.getInt("ID");
			String username=rs.getString("Username");
			String email=rs.getString("email");
			
			System.out.println("ID :: "+id+" USERNAME :: "+username+" EMAIL :: "+email);
					
		}
	}
	
public  void insertUser(User user) throws SQLException {
//	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, username, pass);
		

		String sql="Insert into user (Username,Password,Email) values (?,?,?)";
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setString(1,user.getUsername());
		ps.setString(2,user.getPassword());
		ps.setString(3,user.getEmail());
		ps.executeUpdate();
		con.close();
			
			System.out.println("User added");
					
		}

	public  void UpdateUser(User user) throws SQLException {
		//Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, pass);
		
		String sql="Update user set Username=?,Email=? where ID=?";
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setString(1,user.getUsername());
		ps.setString(2,user.getEmail());
		ps.setInt(3,user.getId());
		ps.executeUpdate();
		con.close();
			
			System.out.println("User Updated");
					
		}

	public  void DeleteUser(User user) throws SQLException {
	//	Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, pass);
		
		String sql="Delete From user where ID=?";
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setInt(1,user.getId());
		ps.executeUpdate();
		con.close();
			
			System.out.println("User Deleted");
					
		}
	
	
}
