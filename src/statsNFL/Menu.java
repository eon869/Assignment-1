package statsNFL;
import java.util.*;

/**
 * An interface that is used to perform certain functions with the data
 * regarding NFL teams
 * @course COMP 2631-001
 * @assignment #1
 * @author Eric On
 * @date September 24 2014
 */

public class Menu 
{
	//the possible choices for the menu
	public static char TEAM = 'T';
	public static char MATCHUP = 'M';
	public static char HISTORY = 'H';
	public static char QUIT = 'Q';


	/**
	 * Prompts user for input and runs certain functions given the proper input
	 * @param stats is the object that stores all data
	 */
	public void run(Statistics stats)
	{
		char entry = 'z';
		String str;
		Scanner scan = new Scanner(System.in);
		
		while (entry != QUIT)
		{
			printChoices();
			System.out.print("Please enter your choice: ");
			
			scan.reset();
			str = scan.nextLine();
			str = str.toUpperCase();
			
			//error check for menu selection
			if (str.length() > 1 || str.length() == 0)
			{
				System.out.println("Invalid entry");
			}
			else
			{
				entry = str.charAt(0);
			
				if (entry == TEAM)
				{
					System.out.print("Please enter a team: ");
					String teamName = scan.nextLine();
					teamName = teamName.toUpperCase();
					System.out.println();
					
					if (checkName(teamName))
					{
						System.out.println(stats.calcTeamStats(teamName));
					}
					else
					{
						System.out.println("Cannot find " + teamName + " in database");
					}
				}
				else if(entry == MATCHUP)
				{
					System.out.print("Please enter the first team: ");
					String teamOne = scan.nextLine();
					System.out.print("Please enter the second team: ");
					String teamTwo = scan.nextLine();
					teamOne = teamOne.toUpperCase();
					teamTwo = teamTwo.toUpperCase();
					System.out.println();
					
					//check that the two entered teams exist
					if (stats.searchTeam(teamOne) && stats.searchTeam(teamTwo))
					{
						System.out.println(stats.calcMatchupStats(teamOne, teamTwo));
					}
					else if(!stats.searchTeam(teamOne) && !stats.searchTeam(teamTwo))
					{
						System.out.println("Cannot find " + teamOne + " and " + teamTwo + " in database");
					}
					else if (!stats.searchTeam(teamOne))
					{
						System.out.println("Cannot find " + teamOne + " in database");
					}
					else if (!stats.searchTeam(teamTwo))
					{
						System.out.println("Cannot find " + teamTwo + " in database");
					}
				}
				else if (entry == HISTORY)
				{
					System.out.print("Please enter the first team: ");
					String teamOne = scan.nextLine();
					System.out.print("Please enter the second team: ");
					String teamTwo = scan.nextLine();
					teamOne = teamOne.toUpperCase();
					teamTwo = teamTwo.toUpperCase();
					System.out.println();
					
					//check if the two entered teams exist
					if (stats.searchTeam(teamOne) && stats.searchTeam(teamTwo))
					{
						stats.getAllMatchups(teamOne, teamTwo);
					}
					else if(!stats.searchTeam(teamOne) && !stats.searchTeam(teamTwo))
					{
						System.out.println("Cannot find " + teamOne + " and " + teamTwo + " in database");
					}
					else if (!stats.searchTeam(teamOne))
					{
						System.out.println("Cannot find " + teamOne + " in database");
					}
					else if (!stats.searchTeam(teamTwo))
					{
						System.out.println("Cannot find " + teamTwo + " in database");
					}
				}
				else if (entry == QUIT)
				{
					System.out.println("Quitting Program...");
				}
				else
				{
					System.out.println("Invalid Entry");
				}
			}
		}
		
		scan.close();
	}
	
	/**
	 * The menu interface
	 */
	private void printChoices()
	{
		System.out.println("Available Options" + '\n' +
				" T - Get Team Statistics" + '\n' +
				" M - Get Matchup Statistics" + '\n' +
				" H - Show Matchup History" + '\n' +
				" Q - Quit" + '\n' + '\n');
	}
	
	/**
	 * Checks to see if the team name entered by user is in correct format
	 * @param name is the string entered by user
	 * @return a boolean value representing the validity of the input
	 */
	private boolean checkName(String name)
	{
		boolean valid = false;
		Statistics stats = new Statistics();
		
		if (name.length() > 3 || name.length() == 0)
		{
			valid = false;
		}
		else
		{
			if (stats.searchTeam(name))
			{
				valid = true;
			}
		}
		
		return valid;
	}
}