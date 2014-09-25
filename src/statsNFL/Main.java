package statsNFL;

/**
 * @course COMP 2631-001
 * @assignment #1
 * @author Eric On
 * @date September 24 2014
 * 
 * The purpose of this program is to generate statistics on the current teams
 * in the NFL. An interactive menu is displayed to carry out various functions.
 * The data is read from a folder which is provided by the user.
 * 
 * The possible functions that the program can execute are:
 * 		- display a team's overall statistics
 * 		- compare the stats of two teams
 * 		- display all history between two teams
 */

public class Main 
{
	public static void main(String [] args)
	{
		readStats read = new readStats();
		Menu menu = new Menu();
		Statistics stats = new Statistics();
		
		//C:/Users/eon/workspace/ASG1/Files/
		//H:/EclipseData/ASG1/Files/
		if (read.read(stats))
		{
			menu.run(stats);
		}
		else
		{
			System.out.println("Closing Program...");
		}
	}
}
