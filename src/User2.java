
public class User2 extends UserClass
{
		String userName; String hashcode;
		boolean verify = false;
		
		public boolean userProfile(String username, String hashcodeBuff, String password, String role,String newPass,String newUsername)
		{
			this.userName = username; 
			this.hashcode = hashcodeBuff;
			
			verify = auth(userName,hashcodeBuff,newPass, newUsername);
			//System.out.println("\n"+hashcode + "\n" + verify);
			
			if (verify == true)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		//FIXME: Create method that displays users content as described in Finals Rubric
}
