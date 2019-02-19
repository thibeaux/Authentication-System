import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Scanner;

public class UserClass 
{ 
	boolean verify = false; //if true then password and username matches
	
		
	public boolean auth(String fileUsername, String fileHashcode,String newHash, String newUserName)
	{
		/*
		if ((newHash.equals(fileHashcode)) && (fileUsername.equals(newUserName)))//missing username verification
		{
			System.out.println("Password and username matches out records! Please proceed.");
			
		}
		else
		{
			System.out.println("Password or username does not match, please try again.");
			
		} */
		verify = ((newHash.equals((fileHashcode))) && (fileUsername.equals(newUserName)));
		//System.out.println("Test came back as: " + (newHash.contains(hashcode)) + "\nNewHash: "+newHash+"\nOldHash: "+ hashcode);//debugging
		//System.out.println(Arrays.toString(newHashCode.getBytes()));
		//System.out.println("");
		//System.out.println(Arrays.toString(hashcode.getBytes()));
		
		return verify;
	}
	
	String roleFile;
	public void setRole(String role)
	{
		this.roleFile = role;
		try {
			userContent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void userContent() throws IOException 
	{
		String fileContentBuff = ""; String currentCommand = "";
		String source = "roles\\" + roleFile.trim() + ".txt";
		//System.out.println(source;
		//System.out.println(roleFile);
		int lineNum = 0;
		
		try 
		{
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			BufferedReader in = new BufferedReader(new FileReader(source));
			Scanner sc = new Scanner(System.in);
			String line = null;
			
			while ((line = in.readLine()) != null)
			{
				lineNum++;
				pw.println(line);
			}
			//print users profile
			fileContentBuff = sw.toString();
			System.out.println("");
			System.out.println(fileContentBuff);
			
			//wait for log out or next command
			System.out.println("Please enter next command:\n-to log out type 'logout' ");
			currentCommand = sc.next();
			
			if (currentCommand.equals("logout"))
			{
				System.out.println("Logout successful!");
				System.exit(0);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
