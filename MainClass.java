import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.File;
import java.io.FileNotFoundException;

public class MainClass 
{
	static String parseFile(String fileName, String searchStr)
	{
		String text = "";
		try
		{
			Scanner scnr = new Scanner(new File(fileName));
			while(scnr.hasNextLine())
			{
				text = text + scnr.next() + " ";
			}
			scnr.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not found");
		}
		
		return text;
	}
	static String hashString(String str)
	{
		//MD5 section 
		String original = str;  //Replace "password" with the actual password inputted by the user
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
		
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		//Declare variables and objects
		Scanner scnr = new Scanner(System.in);
		String userName = ""; String password = ""; //String hashOnFile = "";
		String newHash = ""; String source = "D:\\documents\\SNHU ClassFiles\\IT-145-R3992 19EW3\\Final Project Authentication System\\credentials\\credentials.txt"; 
		
		//input
		System.out.println("Please enter username: ");
		userName = scnr.nextLine();
		System.out.println("Please enter password: ");
		password = scnr.nextLine();
		scnr.close();
		/* ---------------------------------------------------------------------------*/
		newHash = hashString(password);
		System.out.println("Original : " + password); //debugging
		System.out.println("Digested: " + newHash); // debugging
		
		//test two hash strings
		String content =parseFile(source, newHash); //inputs the source file that hold credentials and inputs the hash file from hashString()
		System.out.println(content); //debugging
		
		return;
	}
}
