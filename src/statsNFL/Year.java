package statsNFL;

/**
 * @course COMP 2631-001
 * @assignment #1
 * @author Eric On
 * @date September 24 2014
 */

public class Year 
{
	private Game [] totalGames;
	private int elements;
	private int year;
	
	/**
	 * Constructor
	 */
	public Year()
	{
		totalGames = new Game[1000];
		elements = 0;
		year = 0;
	}
	
	/**
	 * Adds a game object to the Game array
	 * @param game the object to be added
	 */
	public void addGame(Game game)
	{
		if (totalGames[0] == null)
		{
			year = game.getYear();
			totalGames[0] = game;
			elements++;
		}
		else
		{
			totalGames[elements] = game;
			elements++;
		}
	}
	
	/**
	 * Prints all game entries
	 */
	public void printAll()
	{
		if (elements == 0)
		{
			System.out.println("No game entries found");
		}
		else
		{
			for (int x = 0; x < elements; x++)
			{
				System.out.println(totalGames[x].toString());
			}
		}
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String getWeek(int gameNumber)
	{
		return totalGames[gameNumber].getWeek();
	}
	
	public int getAwayYards(int gameNumber)
	{
		return totalGames[gameNumber].getAwayYards();
	}
	
	public int getHomeYards(int gameNumber)
	{
		return totalGames[gameNumber].getHomeYards();
	}
	
	public char getGameResult(int gameNumber)
	{
		return totalGames[gameNumber].getResult();
	}
	
	public int getHomeScore(int gameNumber)
	{
		return totalGames[gameNumber].getHomeScore();
	}
	
	public int getAwayScore(int gameNumber)
	{
		return totalGames[gameNumber].getAwayScore();
	}
	
	public String getHomeGame(int gameNumber)
	{
		return totalGames[gameNumber].getHome();
	}
	
	public String getAwayGame(int gameNumber)
	{
		return totalGames[gameNumber].getAway();
	}
	
	public int getNumGames()
	{
		return elements;
	}
	
	public void numofGames()
	{
		System.out.println("Number of games this year: " + elements);
	}
}
