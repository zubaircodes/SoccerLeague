/**
 * The Player class stores the name and the number of a player
 *
 * @author Wei Liu, Zubair
 * @version 2018.11.15
 */
public class Player extends Human
{
    // instance variables - replace the example below with your own
    private int number;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name, int number)
    {
        super(name);
        this.number = number;
    }

    /**
     * An override method display the information of the player
     */
    public void display()
    {
        System.out.println("Player number: " + number 
        + ", player name: "
        + super.getName());
    }
}
