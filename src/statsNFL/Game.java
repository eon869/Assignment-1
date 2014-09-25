package statsNFL;
import java.util.*;

/**
 * @course COMP 2631-001
 * @assignment #1
 * @author Eric On
 * @date September 24 2014
 */

public class Game 
{
	private int year;
	private String week;
	private String dow;
	private String home;
	private int homeScore;
	private String away;
	private int awayScore;
	private String date;
	private char result;
	private int homeYards;
	private int awayYards;
	private int homeTurnovers;
	private int awayTurnovers;
	
	/**
	 * Constructor
	 */
	public Game()
	{
		year = 0;
		week = "";
		dow = "";
		home = "";
		homeScore = 0;
		away = "";
		awayScore = 0;
		date = "";
		result = ' ';
		homeYards = 0;
		awayYards = 0;
		homeTurnovers = 0;
		awayTurnovers = 0;
	}
	
	/**
	 * Constructor
	 * String format: Year,Week,Day,Home,Home Score,Away,Away Score,Date,Result,Home Yards,Away Yards,Home Turnovers,Away Turnovers
	 * String format: int,string,string,string,int,string,int,string,char,int,int,int,int
	 * @param string is a string that contains all data needed to create a game
	 */
	public Game(String string)
	{
		Scanner scan = new Scanner(string);
		String temp;
		
		//read up to next ','
		scan.useDelimiter(",");
		
		temp = scan.next();
		//convert from string to int
		year = Integer.parseInt(temp);
		
		temp = scan.next();
		week = temp;
		
		temp = scan.next();
		dow = temp;
		
		temp = scan.next();
		home = temp;
		
		temp = scan.next();
		//convert from string to int
		homeScore = Integer.parseInt(temp);
		
		temp = scan.next();
		away = temp;
		
		temp = scan.next();
		awayScore = Integer.parseInt(temp);
		
		temp = scan.next();
		date = temp;
		
		temp = scan.next();
		result = temp.charAt(0);
		
		temp = scan.next();
		homeYards = Integer.parseInt(temp);
		
		temp = scan.next();
		awayYards = Integer.parseInt(temp);
		
		temp = scan.next();
		homeTurnovers = Integer.parseInt(temp);
		
		temp = scan.next();
		awayTurnovers = Integer.parseInt(temp);
		
		scan.close();
	}
	
	public String getWeek()
	{
		return week;
	}
	
	public int getHomeYards()
	{
		return homeYards;
	}
	
	public int getAwayYards()
	{
		return awayYards;
	}
	
	public char getResult()
	{
		return result;
	}
	
	public int getHomeScore()
	{
		return homeScore;
	}
	
	public int getAwayScore()
	{
		return awayScore;
	}
	
	public String getHome()
	{
		return home;
	}
	
	public String getAway()
	{
		return away;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String toString()
	{
		return "Game Statistics:" + '\n' +
				"Year: " + year + '\n' + 
				"Week: " + week + '\n' + 
				"Day of the Week: " + dow + '\n' +
				"Home Team: " + home + '\n' + 
				"Home Score: " + homeScore + '\n' +
				"Away Team: " + away + '\n' +
				"Away Score: " + awayScore + '\n' +
				"Date: " + date + '\n' +
				"Result: " + result + '\n' +
				"Home Yards: " + homeYards + '\n' +
				"Away Yards: " + awayYards + '\n' +
				"Home Turnovers: " + homeTurnovers + '\n' +
				"Away Turnovers: " + awayTurnovers + '\n';
	}
}