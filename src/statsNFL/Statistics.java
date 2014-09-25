package statsNFL;
import java.text.*;

/**
 * @course COMP 2631-001
 * @assignment #1
 * @author Eric On
 * @date September 24 2014
 * Holds all data of NFL teams and does specific calculations using the
 * stored data
 */

public class Statistics 
{
	private Year [] years;
	private int numOfYears;
	private String [] teams;
	
	/**
	 * Constructor
	 */
	public Statistics()
	{
		years = new Year[1000];
		numOfYears = 0;
		//name of current teams in the NFL
		teams = new String[]{"ATL", "ARI", "BAL", "BUF", "CAR", "CHI", "CIN", "CLE",
				"DAL", "DEN", "DET", "GB", "HOU", "IND", "JAC", "KC", "MIA", "MIN", "NE",
				"NO", "NYG", "NYJ", "OAK", "PHI", "PIT", "SD", "SEA", "SF", "STL", "TB",
				"TEN", "WAS"};
	}
	
	/**
	 * Adds a year object to the private year array
	 * @param year is the object to be added
	 */
	public void addYear(Year year)
	{
		if (years[0] == null)
		{
			years[0] = year;
			numOfYears++;
		}
		else
		{
			years[numOfYears] = year;
			numOfYears++;
		}
	}
	
	/**
	 * Searches through the array of team names and compares each element to the given
	 * parameter. True is returned if a match is found, false is returned otherwise
	 * @param name is the name of the team
	 * @return a boolean value representing if a team has been found or not
	 */
	public boolean searchTeam(String name)
	{
		boolean found = false;
		
		for (int x = 0; x < teams.length; x++)
		{
			if (name.equals(teams[x]))
			{
				found = true;
			}
		}
		
		return found;
	}
	
	/**
	 * Calculates specific stats (wins, losses, ties, games played, and win %) 
	 * for a given team
	 * @param name is the name of the team
	 * @return a string which is concatenated of all the calculated data
	 */
	public String calcTeamStats(String name)
	{
		int wins = calcTeamWins(name);
		int losses = calcTeamLosses(name);
		int ties = calcTeamTies(name);
		int games = calcTotalGames(name);
		double percentage = (double) wins/(double) games;
		//http://stackoverflow.com/questions/7415733/how-to-convert-double-to-2-number-after-the-dot
		NumberFormat formatter = new DecimalFormat("##.####");
		String temp = formatter.format(percentage);
		percentage = Double.valueOf(temp);
		
		return "Stats for " + name + '\n' + 
				"Wins:               " + wins + '\n' +
				"Losses:             " + losses + '\n' +
				"Ties:               " + ties + '\n' +
				"Total Games Played: " + games + '\n' +
				"Winning Percentage: " + percentage + '\n' + '\n';
	}
	
	/**
	 * Calculates the total number of games played for a given team
	 * @param name is the name of the team
	 * @return an integer which is the total number of games played
	 */
	private int calcTotalGames(String name)
	{
		int total = 0;
		
		for (int x = 0; x < numOfYears; x++)
		{
			for (int y = 0; y < years[x].getNumGames(); y++)
			{
				if (name.equals(years[x].getHomeGame(y)) || name.equals(years[x].getAwayGame(y)))
				{
					total++;
				}
			}
		}
		
		return total;
	}
	
	/**
	 * Calculates the total number of wins for a given team
	 * @param name is the name of the team
	 * @return the total number of wins
	 */
	private int calcTeamWins(String name)
	{
		int total = 0;
		
		for (int x = 0; x < numOfYears; x++)
		{
			for (int y = 0; y < years[x].getNumGames(); y++)
			{
				if (name.equals(years[x].getHomeGame(y)))
				{
					if (years[x].getGameResult(y) == 'H')
					{
						total++;
					}
				}
				else if(name.equals(years[x].getAwayGame(y)))
				{
					if (years[x].getGameResult(y) == 'A')
					{
						total++;
					}
				}
			}
		}
		
		return total;
	}
	
	/**
	 * Calculates the total number of losses
	 * @param name is the name of the team
	 * @return an integer representing the number of losses
	 */
	private int calcTeamLosses(String name)
	{
		int total = 0;
		
		for (int x = 0; x < numOfYears; x++)
		{
			for (int y = 0; y < years[x].getNumGames(); y++)
			{
				if (name.equals(years[x].getHomeGame(y)))
				{
					if (years[x].getGameResult(y) == 'A')
					{
						total++;
					}
				}
				else if(name.equals(years[x].getAwayGame(y)))
				{
					if (years[x].getGameResult(y) == 'H')
					{
						total++;
					}
				}
			}
		}
		
		return total;
	}
	
	/**
	 * Calculates how many ties a team has
	 * @param name is the name of the team
	 * @return an integer representing the number of ties
	 */
	private int calcTeamTies(String name)
	{
		int total = 0;
		
		for (int x = 0; x < numOfYears; x++)
		{
			for (int y = 0; y < years[x].getNumGames(); y++)
			{
				if (name.equals(years[x].getHomeGame(y)) || name.equals(years[x].getAwayGame(y)))
				{
					if (years[x].getGameResult(y) == 'T')
					{
						total++;
					}
				}
			}
		}
		
		return total;
	}
	
	/**
	 * Brings all the data together from both teams
	 * @param team1 is the first given team
	 * @param team2 is the second given team
	 * @return a string which is a concatenation of all calculated stats
	 */
	public String calcMatchupStats(String team1, String team2)
	{
		int [] calculations = new int[5];
		
		for (int x = 0; x < calculations.length; x++)
		{
			calculations[x] = 0;
		}
		
		calcTwoTeams(team1, team2, calculations);
		
		return "Stats for " + team1 + " vs. " + team2 + ": '\n" +
		"Games Played:        " + calculations[0] + '\n' +
		team1 + " won:             " + calculations[1] + '\n' +
		team2 + " won:             " + calculations[2] + '\n' +
		team1 + "'s Total Yardage: " + calculations[3] + '\n' +
		team2 + "'s Total Yardage: " + calculations[4] + '\n' + '\n';
	}

	/**
	 * Calculates the stats between two teams in the NFL
	 * @param team1 is the first given team
	 * @param team2 is the second given team
	 * @param calc is the array that stores all calculations
	 */
	private void calcTwoTeams(String team1, String team2, int [] calc)
	{
		for (int x = 0; x < numOfYears; x++)
		{
			for (int y = 0; y < years[x].getNumGames(); y++)
			{
				if (team1.equals(years[x].getHomeGame(y)) && team2.equals(years[x].getAwayGame(y)))
				{
					if (years[x].getGameResult(y) == 'H')
					{
						calc[1]++;
						calc[0]++;
						calc[3] = calc[3] + years[x].getHomeYards(y);
					}
					else if(years[x].getGameResult(y) == 'A')
					{
						calc[2]++;
						calc[0]++;
						calc[4] = calc[4] + years[x].getAwayYards(y);
					}
				}
				else if (team1.equals(years[x].getAwayGame(y)) && team2.equals(years[x].getHomeGame(y)))
				{
					if (years[x].getGameResult(y) == 'H')
					{
						calc[2]++;
						calc[0]++;
						calc[4] = calc[4] + years[x].getHomeYards(y);
					}
					else if (years[x].getGameResult(y) == 'A')
					{
						calc[1]++;
						calc[0]++;
						calc[3] = calc[3] + years[x].getAwayYards(y);
					}
				}
			}
		}
	}
	
	/**
	 * Gets the all the stats of the games played between two NFL teams
	 * @param team1 is the first given team
	 * @param team2 is the second given team
	 */
	public void getAllMatchups(String team1, String team2)
	{
		final int MINDEX = 500;
		int [] year = new int[MINDEX];
		String [] week = new String[MINDEX];
		String [] away = new String[MINDEX];
		int [] awayScore = new int[MINDEX];
		String [] home = new String[MINDEX];
		int [] homeScore = new int[MINDEX];
		int index = 0;
		
		for (int x = 0; x < numOfYears; x++)
		{
			for (int y = 0; y < years[x].getNumGames(); y++)
			{
				if (team1.equals(years[x].getHomeGame(y)) && team2.equals(years[x].getAwayGame(y)))
				{
					year[index] = years[x].getYear();
					week[index] = years[x].getWeek(y);
					away[index] = years[x].getAwayGame(y);
					awayScore[index] = years[x].getAwayScore(y);
					home[index] = years[x].getHomeGame(y);
					homeScore[index] = years[x].getHomeScore(y);
					index++;
				}
				else if (team1.equals(years[x].getAwayGame(y)) && team2.equals(years[x].getHomeGame(y)))
				{
					year[index] = years[x].getYear();
					week[index] = years[x].getWeek(y);
					away[index] = years[x].getAwayGame(y);
					awayScore[index] = years[x].getAwayScore(y);
					home[index] = years[x].getHomeGame(y);
					homeScore[index] = years[x].getHomeScore(y);
					index++;
				}
			}
		}

		printAllMatchups(year, week, away, awayScore, home, homeScore, index);
	}
	
	/**
	 * Prints all the stats calculated in function: getAllMatchups()
	 * @param year is the array that stores the year that the game occurs
	 * @param week is the array that the game was played on
	 * @param away is the array that stores the name of the away team for the game
	 * @param awayScore is the array that stores the score of the away team
	 * @param home is the array that stores the name of the home team for the game
	 * @param homeScore is the array that stores the score of the home team
	 * @param index is the max number of elements in above arrays
	 */
	private void printAllMatchups(int [] year, String [] week, String [] away, int [] awayScore,
			String [] home, int [] homeScore, int index)
	{
		
		System.out.printf("%s\n", "Year Week Away Away Score Home Home Score");
		
		for (int x = 0; x < index; x++)
		{
			System.out.printf("%4d %4s %4s %10d %4s %10d\n", year[x], week[x], away[x], awayScore[x],
					home[x], homeScore[x]);
		}
		
		System.out.print('\n');
	}
}