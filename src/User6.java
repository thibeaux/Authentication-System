
public class User6 extends UserClass
{
		String userName; String hashcode; String role;
		boolean verify = false;
		
		public boolean userProfile(String username, String hashcodeBuff, String password, String role,String newPass,String newUsername)
		{
			this.userName = username; 
			this.hashcode = hashcodeBuff;
			this.role = role;
			
			verify = auth(userName,hashcodeBuff,newPass, newUsername);
			
			if (verify == true)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}

		public void getContent()
		{
			setRole(role);
		}
}
