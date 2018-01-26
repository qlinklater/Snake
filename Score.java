import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int playerScore;
    private boolean scoreChanged;
    
    /**
     * Score adding and keeping track of points
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    public Score()
    {
        playerScore = 0;
        displayScore();
    }
    
    /**
     * displayScore changing how score is going to look like and function
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    private void displayScore()
    {
        GreenfootImage display;
        
        display = new GreenfootImage(Integer.toString( playerScore ), 30, Color.BLACK, Color.WHITE );
        
        setImage( display );
        scoreChanged = false;
    }
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if( scoreChanged == true )
        {
            displayScore();
        }
    }
    
    /**
     * countScore adds a point to the score whenever the snake eats
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    public void countScore()
    {
        playerScore++;
        scoreChanged = true;
    }
    
    /**
     * getScore tracks the number of points
     * 
     * @param there are no parameters
     * @return returning playerScore to it's original number
     */
    public int getScore()
    {
        return playerScore;
    }
}
