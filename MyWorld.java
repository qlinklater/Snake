import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class MyWorld here.
 * 
 * @author Quentin linklater
 * @version 1/26/2018
 */
public class MyWorld extends World
{
    private final int MAX_PARTS =(900*600)/(40*40);
    
    private int[] x = new int[MAX_PARTS];
    private int[] y = new int[MAX_PARTS];
    private int parts = 4;
    private Snake body;
    private boolean startGame = false;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        createBackground();
        setPaintOrder( Score.class, Snake.class, Food.class);
        
        for( int i = 0;i < parts; i++)
        {
            x[i] = 200 - i*40;
            y[i] = 40;
        }
        populate();
    }
    
    /**
     * populate spawns food into your world whenever snakes eats and add score
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    private void populate()
    {
        for( int i = 0; i < parts; i++)
        {
            body = new Snake(i);
            addObject( body, x[i], y[i] );
        }
        addObject(new Score(), getWidth()/2, 50 );
        randomFood(5);
    }
    
    /**
     * createBackground adds the text to start the game
     * 
     * @param there are no parameters
     * @return nothing is returned
     */
    public void createBackground()
    {
        showText("Press space to begin the game", getWidth()/2, getHeight()/2 );
    }
    
    /**
     * act does the actions to the world
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        if( startGame == false )
        {
            checkKeyPress();
        }
        else
        {
            for( int i = parts; i > 0; i--)
            {
                x[i] = x[i-1];
                y[i] = y[i-1];
            }
        }
    }
    
    /**
     * checkKeyPress starts the game when space is pressed
     * 
     * @param there are no parameters
     * @returned nothing is returned
     */
     private void checkKeyPress()
    {
        if( Greenfoot.isKeyDown("space") )
        {
            startGame = true;
            showText("", getWidth()/2, getHeight()/2 );
        }
    }
    
    /**
     * randomFood spawns the food in different locations
     * 
     * @param numbernig howMany
     * @return Nothing is returned
     */
    public void randomFood( int howMany)
    {
        Food newFood;
        int x;
        int y;
        for( int i = 0; i < howMany; i++ )
        {
            newFood = new Food();
            x = Greenfoot.getRandomNumber( getWidth() );
            y = Greenfoot.getRandomNumber( getHeight() );
            
            addObject( newFood, x, y );
        }
    }
    
    /**
     * startGame checking if the game is starting or not
     * 
     * @param there are no parameters
     * @return returning startGame to reset
     */
    public boolean startGame()
    {
        return startGame;
    }
    
    /**
     * setSX checking how many bodyparts on the x-axis
     * 
     * @param s is for snake
     * @param sx is for snake in the X-axis
     * @return nothing is returned
     */
    public void setSX( int s, int sx )
    {
        x[s] = sx;
    }
    
    /**
     * setSY checknig how many bodyparts on the y-axis
     * 
     * @param s is for snake
     * @param sy is for snake in the y-axis
     * @return nothing to returned
     */
    public void setSY( int s, int sy )
    {
        y[s] = sy;
    }
    
    /**
     * getMyX checking where the snake is on the x-axis
     * 
     * @param s is for snake
     * @return returning the x-axis
     */
    public int getMyX( int s )
    {
        return x[s];
    }
    
    /**
     * getMyY checking where tje snake is on the y-axis
     * 
     * @param s is for snake
     * @return returning the y-axis
     */
    public int getMyY( int s )
    {
        return y[s];
    }
    
    /**
     * addSnake adds the bodyParts to the snake
     * 
     * @param there is no parameters
     * @return Nothing is returned
     */
    public void addSnake()
    {
        int parentX = x[parts-1];
        int parentY = y[parts-1];
        
        body = new Snake(parts);
        addObject( body, parentX, parentY );
        parts++;
    }
}