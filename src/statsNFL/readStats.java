package statsNFL;
import java.io.*;
import java.util.*;

/**
 * @course COMP 2631-001
 * @assignment #1
 * @author Eric On
 * @date September 24 2014
 */

public class readStats 
{
	/**
	 * Reads all the files found in a folder from a path that is taken from the user
	 * @param stats is the object that stores all the data read
	 * @return the stored data
	 */
	public boolean read(Statistics stats)
	{
		Scanner sc = new Scanner(System.in);
		String path;
		boolean valid = false;
		System.out.println("Enter the path in which the folder with the files is located in: ");
		path = sc.nextLine();
		
		//http://stackoverflow.com/questions/1844688/read-all-files-in-a-folder
		File folder = new File(path);
		File [] listOfFiles = folder.listFiles();	//holds the name of the files in the folder
		String str;
		
		try
		{	
			System.out.println("Reading data...");
			
			//go through all files
			for (int i = 0; i < listOfFiles.length; i++)
			{
				Year year = new Year();
				
				try
				{
					//open file
					File readFile = new File(path + listOfFiles[i].getName());
					Scanner scan = new Scanner(readFile);
			
					scan.nextLine();
					
					while (scan.hasNextLine())
					{
						str = scan.nextLine();
						Game game = new Game(str);
						year.addGame(game);
					}
			
					scan.close();
					stats.addYear(year);
				}
				catch (FileNotFoundException e)
				{
					System.out.println("Cannot find file");
				}
			}
			
			System.out.println("Successful read!");
			valid = true;
		}
		catch (Exception f)
		{
			System.out.println("No files found with given path");
		}
		
		return valid;
	}
}
