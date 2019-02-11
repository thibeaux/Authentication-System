import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MainClass 
{
	public static void main(String[] args)
	{
		//Declare variables and objects
		Scanner scnr = new Scanner(System.in);
		String userName = ""; String password = ""; String hash = "";
		
		//input
		System.out.println("Please enter username: ");
		userName = scnr.nextLine();
		System.out.println("Please enter password: ");
		password = scnr.nextLine();
		scnr.close();
		/* ---------------------------------------------------------------------------*/
		
		//MD5 section 
		String original = password;  //Replace "password" with the actual password inputted by the user
		MessageDigest md = null;
		try 
		{
			md = MessageDigest.getInstance("MD5");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(original.getBytes());
		byte[] digest = md.digest();
      StringBuffer sb = new StringBuffer();
		for (byte b : digest) 
		{
			sb.append(String.format("%02x", b & 0xff));
		}
		
		System.out.println("Original : " + original);
		System.out.println("Digested: " + sb.toString());
		
		return;
	}
}
