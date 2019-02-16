import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;


public class MainClass 
{	
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
	
	public static void main(String[] args) throws IOException
	{
		//Declare variables and objects
		User1 u1 = new User1();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		Scanner scnr = new Scanner(System.in);
		boolean verify1 = false;
		int attempts = 0;
		String userName = ""; String password = ""; String[] fileContent = {}; String fileContentBuff="";
		String newHash = ""; String source = "D:\\documents\\SNHU ClassFiles\\IT-145-R3992 19EW3\\Final Project Authentication System\\credentials\\credentials.txt"; 
		/* ---------------------------------------------------------------------------------------------------------------------------------------------------------*/
		while ((verify1 == false))
		{
		attempts++;
		if (attempts != 4)
		{
			//input
			System.out.println("Please enter username: ");
			userName = scnr.nextLine();
			System.out.println("Please enter password: ");
			password = scnr.nextLine();
			
			//Hash password
			newHash = hashString(password);
			//System.out.println("Original : " + password); //debugging
			//System.out.println("Digested: " + newHash); // debugging
			
			//open file 
			//I was unable to find any sources to help me make a method that entirely handled the files opening, testing, and closing, so i put this in main.
			int lineNum = 0;
			try 
			{
				BufferedReader in = new BufferedReader(new FileReader(source));
				String line = null; 
				
				while((line = in.readLine()) != null)
				{
					lineNum++;
					pw.println(line);
					//System.out.println("Line " + lineNum + ": " + line );//debugging
				}
				fileContentBuff = sw.toString();//takes the content from the StringWriter and stores it in a varaible
				//System.out.println("\n\n"+ sw.toString());//debugging
			} 
			catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Format File
			int i = 0;
			fileContent = fileContentBuff.split("\n");
			List<String[]> myList = new ArrayList<String[]>();
			
			String buffLine = fileContent[i];
			String[] user1 = buffLine.split("\t"); i++;//creating 6 users to store new data from file
			String[] user2 = buffLine.split("\t"); i++;
			String[] user3 = buffLine.split("\t"); i++;
			String[] user4 = buffLine.split("\t"); i++;
			String[] user5 = buffLine.split("\t"); i++;
			String[] user6 = buffLine.split("\t"); i++;
			
			//Sort Strings from file to UserClass to interpret and verify information
			verify1 = u1.userProfile(user1[0], user1[1], user1[2], user1[3],newHash,userName);//User1.java class
		}
		else
		{
			System.out.println("There has been 3 failed attempts... program is exiting.");
			System.exit(0);
			break;
		}
		}
		//FIXME: Create a method in MainClass to determine what user has been verified out of the 6 users
		//FIXME!: create a method in User1 class that displays users profile as described in the Final Rubric
		//this only happens if user enters credentials successfully within 3 tries.
		scnr.close();
		return;
	}
}
