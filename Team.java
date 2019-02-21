/**
 * The class Team can creates Team object by taking a team name as parameter
 * A team has a name, a coach and 16-28 players
 * Teams can be compared in terms of their points and goal differences
 *
 * @author Wei Liu, Zubair
 * @version 2018.11.15
 */
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;

public class Team implements Comparable<Team>
{
    private String teamName;
    private Coach coach; 
    private HashSet<Player> players;
    private int win;
    private int draw;
    private int loss;
    private int netGoal;
    
    String[] playerNames = { "Patrick van Aanholt", "Rolando Aarons" ,"Almen Abdi" ,"Mehdi Abeid" ,"Nabil Abidallah" ,"Gary Ablett", "Samassi Abou" ,"Tammy Abraham" ,"Milenko Ačimovič" ,"Clarence Acuña" 
    ,"Charlie Adam", "Micky Adams", "Neil Adams" ,"Tony Adams","Miles Addison","Emmanuel Adebayor","Albert Adomah","Adrián", "Ibrahim Afellay","Benik Afobe","Kieran Agard","Didier Agathe","Gabriel Agbonlahor",
    "Daniel Agger","Julius Aghahowa","Steve Agnew","Junior Agogo","Sergio Agüero","Kemy Agustien","Dan Agyei","Patrick Agyemang","Ola Aina","Gareth Ainsworth","Sam Aiston","Nathan Aké","Bülent Akın","Ade Akinbiyi",
    "Hope Akpan","Chuba Akpom","Philippe Albert","Martin Albrechtsen","Marc Albrighton","Antolín Alcaraz" ,"Toby Alderweireld","Rati Aleksidze" };
    
    String[] coachNames = {"Schellas", "Bruce", "Dave", "Steve", "Greg", "Peter", "Jason",
    "Sam", "David", "John", "Rose", "Jane"};
    
    String[] genders = {"Female", "Male", "Other"};
    
    /**
     * Create a team object with random number of players and a coach
     */
    public Team(String teamName)
    {
        // initialise instance variables
        this.teamName = teamName;
        this.coach = coach;
        players = new HashSet<>();
        Random rand = new Random(); 
        int numberOfPlayers = rand.nextInt(13) + 16;
        for (int i = 1; i <= numberOfPlayers; i++){
            int playerNumber = rand.nextInt(99);
            String playerName = playerNames[rand.nextInt(playerNames.length)];
            Player newplayer = new Player(playerName, playerNumber);
            players.add(newplayer);
        } 
        String coachName = coachNames[rand.nextInt(coachNames.length)];
        String coachGender = genders[rand.nextInt(genders.length)];
        coach = new Coach(coachName, coachGender);
        win = 0;
        draw = 0;
        loss = 0;
        netGoal = 0;
    }

    /**
     * return a string of the team name
     */
    public String getTeamName()
    {
        return teamName;
    }
    
    /**
     * get the coach of the team, return a Coach object
     */
    public Coach getCoach()
    {
        return coach;
    }
    
    /**
     * return the number of the players in the team
     */
    public int getNumberOfPlayers()
    {
        return players.size();
    }
    
    /**
     * print the detailed information of the team
     */
    public void printDetails()
    {
        System.out.println("Team name: " + teamName
        + ", there are " + getNumberOfPlayers() + " players, they are: ");
        for (Player player : players){
            player.display();
        }
        System.out.println("The coach is: ");
        coach.display();
        System.out.println("Point: " + getPoint() 
        + ", # of wins: " + getWin()
        + ", # of draws: " + getDraw()
        + ", # of losses: " + getLoss()
        + ", goal differences: " + getNetGoal());
        System.out.println("\n");
        
    }
    
    /**
     * get the number of wins 
     */
    public int getWin()
    {
        return win;
    }
    
    /**
     * get the number of draws
     */
    public int getDraw()
    {
        return draw;
    }
    
    /**
     * get number of losses
     */
    public int getLoss()
    {
        return loss;
    }
    
    /**
     * get the point of the team
     */
    public int getPoint()
    {
        return 3 * win + 1 * draw + 0 * loss;
    }
    
    /**
     * get the goal differences
     */
    public int getNetGoal()
    {
        return netGoal;
    }
    
    /**
     * set up a match by assigning the number of goals for 
     * and the nunber of goals against
     */
    public void play(int goalsFor, int goalsAgainst)
    {
        if (goalsFor > goalsAgainst){
            win += 1;
        }
        else if (goalsFor == goalsAgainst){
            draw += 1;
        }
        else{
            loss += 1;
        }
        netGoal = netGoal + goalsFor - goalsAgainst;
    }
    
    /**
     * An orverride method to set up the criteria of ranking
     */
    public int compareTo(Team team)
    {
        int compare = 0;
        if (this.getPoint() < team.getPoint()){
            compare = 1;
        }
        else if (this.getPoint() > team.getPoint()){
            compare = -1;
        }
        else if (this.getNetGoal() < team.getNetGoal()){
            compare = 1;
        }
        else if (this.getNetGoal() < team.getNetGoal()){
            compare = -1;
        }
        return compare;
    }
}
