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
		//Declaring Objects
		User1 u1 = new User1();
		User2 u2 = new User2();
		User3 u3 = new User3();
		User4 u4 = new User4();
		User5 u5 = new User5();
		User6 u6 = new User6();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		Scanner scnr = new Scanner(System.in);
		//Declaring Variables
		boolean whileVerify = false;
		boolean verify1 = false; boolean verify2 = false; boolean verify3 = false;
		boolean verify4 = false; boolean verify5 = false; boolean verify6 = false;
		int attempts = 0;
		String userName = ""; String password = ""; String[] fileContent = {}; String fileContentBuff="";
		String newHash = ""; String source = "credentials/credentials.txt"; 
		/* ---------------------------------------------------------------------------------------------------------------------------------------------------------*/
		while (whileVerify == false)
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
			
			//Open file 
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
			String[] user1 = buffLine.split("\t"); i++;buffLine = fileContent[i];//creating 6 users to store new data from file
			String[] user2 = buffLine.split("\t"); i++;buffLine = fileContent[i];
			String[] user3 = buffLine.split("\t"); i++;buffLine = fileContent[i];
			String[] user4 = buffLine.split("\t"); i++;buffLine = fileContent[i];
			String[] user5 = buffLine.split("\t"); i++;buffLine = fileContent[i];
			String[] user6 = buffLine.split("\t"); i++;
			
			//Sort Strings from file to UserClass to interpret and verify information
			verify1 = u1.userProfile(user1[0], user1[1], user1[2], user1[3],newHash,userName);//User1.java class
			verify2 = u2.userProfile(user2[0], user2[1], user2[2], user2[3],newHash,userName);//User2.java class
			verify3 = u3.userProfile(user3[0], user3[1], user3[2], user3[3],newHash,userName);//User3.java class
			verify4 = u4.userProfile(user4[0], user4[1], user4[2], user4[3],newHash,userName);//User4.java class
			verify5 = u5.userProfile(user5[0], user5[1], user5[2], user5[3],newHash,userName);//User5.java class
			verify6 = u6.userProfile(user6[0], user6[1], user6[2], user6[3],newHash,userName);//User6.java class
			//FIXME: Sort through all 6 users and see who was verified
			//FIXME: Create a method in MainClass to determine what user has been verified out of the 6 users
			if (verify1 == true)
			{
				System.out.println("Password and user name match out records. Please proceed.");
				whileVerify = true;
				u1.getContent();
			}
			else if(verify2 == true)
			{
				System.out.println("Password and user name match out records. Please proceed.");
				whileVerify = true;
				u2.getContent();
			}
			else if(verify3 == true)
			{
				System.out.println("Password and user name match out records. Please proceed.");
				whileVerify = true;
				u3.getContent();
			}
			else if(verify4 == true)
			{
				System.out.println("Password and user name match out records. Please proceed.");
				whileVerify = true;
				u4.getContent();
			}
			else if(verify5 == true)
			{
				System.out.println("Password and user name match out records. Please proceed.");
				whileVerify = true;
				u5.getContent();
			}
			else if(verify6 == true)
			{
				System.out.println("Password and user name match out records. Please proceed.");
				whileVerify = true;
				u6.getContent();
			}
			else
			{
				System.out.println("Password and username does not match our records. Please try again.");
				whileVerify = false;
			}
			
		//System.out.println(user6[0].toString()); // debugging
		}
		else
		{
			System.out.println("There has been 3 failed attempts... program is exiting.");
			System.exit(0);
			break;
		}
		}
		//FIXME: Clean up code and make documents and more readable notes
		//FIXME: create a method in User# classes that displays users profile as described in the Final Rubric
		//this only happens if user enters credentials successfully within 3 tries.
		scnr.close();
		return;
	}
}
