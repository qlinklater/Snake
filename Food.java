import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    private static final int SIZE = 20;
    
    /**
     * Food changing how food is going to look like
     * 
     * @param there are no parameters
     * @return nothing is returned
     */
    public Food()
    {
        GreenfootImage foodImage = new GreenfootImage( SIZE, SIZE );
        
        foodImage.setColor( Color.WHITE );
        foodImage.fillOval( 0, 0, SIZE, SIZE );
        setImage( foodImage );
    }
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * @param there are no parameters
     * @return nothing is returned
     */
    public void act() 
    {
        
    }
}
