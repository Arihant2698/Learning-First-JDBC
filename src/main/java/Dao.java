import java.sql.SQLException;

public class Dao {

	public static void main(String[] args) throws SQLException   {
		// TODO Auto-generated constructor stub
		Main main1=new Main();
		
		User user =new User();
		user.setUsername("navimumbai");
		user.setEmail("navimumbai@gmail.com");
		user.setPassword("123456");
			
			//readAllUser();
		main1.insertUser(user);
		//main1.UpdateUser(user);
		//	main1.DeleteUser(user);
		}
}
