import java.util.Arrays;

public class UserClass 
{ 
	boolean verify = false; //if true then password and username matches
	
		
	public boolean auth(String fileUsername, String fileHashcode,String newHash, String newUserName)
	{
		if ((newHash.equals(fileHashcode)) && (fileUsername.equals(newUserName)))//missing username verification
		{
			System.out.println("Password and username matches out records! Please proceed.");
			
		}
		else
		{
			System.out.println("Password or username does not match, please try again.");
			
		}
		verify = ((newHash.equals((fileHashcode))) && (fileUsername.equals(newUserName)));
		//System.out.println("Test came back as: " + (newHash.contains(hashcode)) + "\nNewHash: "+newHash+"\nOldHash: "+ hashcode);//debugging
		//System.out.println(Arrays.toString(newHashCode.getBytes()));
		//System.out.println("");
		//System.out.println(Arrays.toString(hashcode.getBytes()));
		
		return verify;
	}

}
