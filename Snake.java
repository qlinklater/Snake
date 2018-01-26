import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    private int x;
    private int y;
    private int s;
    private String upKey;
    private String downKey;
    private String leftKey;
    private String rightKey;
    private static final int SIZE = 40;
    
    /**
     * Snake is the player Model and controls for the snake
     * 
     * @param numbering part
     * @return Nothing is returned
     */
    public Snake( int part )
    {
        GreenfootImage snakeImage = new GreenfootImage( SIZE, SIZE );
        s = part;
        
        if( s == 0 )
        {
            snakeImage.setColor( Color.WHITE );
            snakeImage.fillRect( 0, 0, SIZE, SIZE );
        }
        else
        {
            snakeImage.setColor( Color.GREEN );
            snakeImage.fillRect( 0, 0, SIZE, SIZE );
        }
        setImage( snakeImage );
        upKey = "up";
        downKey = "down";
        leftKey = "left";
        rightKey = "right";
    }
    
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * @param there are no parameters
     * @return nothing is returned
     */
    public void act() 
    {
        MyWorld myWorld =(MyWorld)getWorld();
        
        if( myWorld.startGame() == true )
        {
            if( s == 0)
            {
                lead();
                lookForFood();
                lookForEdge();
                lookForTail();
            }
            else
            {
                follow();
            }
        }
    }
    
    /**
     * Moves the snake and the tail
     * 
     * @param there are no parameters
     * @return nothing is returned
     */
    private void lead()
    {
        double angle;
        MyWorld myWorld =(MyWorld)getWorld();
        x = getX();
        y = getY();
        
        if( Greenfoot.isKeyDown(leftKey) )
        {
            setRotation(180);
        }
        else if( Greenfoot.isKeyDown(rightKey) )
        {
            setRotation(0);
        }
        else if( Greenfoot.isKeyDown(upKey) )
        {
            setRotation(270);
        }
        else if( Greenfoot.isKeyDown(downKey) )
        {
            setRotation(90);
        }
        
        angle = Math.toRadians( getRotation() );
        x = (int) Math.round( getX() + Math.cos(angle) * SIZE);
        y = (int) Math.round( getY() + Math.sin(angle) * SIZE);
        
        setLocation(x, y);
        myWorld.setSX(s, x);
        myWorld.setSY(s, y);
    }
    
    /**
     * lookForFood adds a point to the score and makes the snake grow
     * 
     * @param there are no parameters
     * @return nothing is returned
     */
    private void lookForFood()
    {
        MyWorld myWorld = (MyWorld)getWorld();
        Score playerScore = (Score)getWorld().getObjects( Score.class ).get(0);
        if( isTouching( Food.class ) )
        {
            removeTouching(Food.class);
            myWorld.randomFood(1);
            playerScore.countScore();
            growTail();
        }
    }
    
    /**
     * lookForEdge hitting the wall of the game will make you lose
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    private void lookForEdge()
    {
        if( isAtEdge() )
        {
            getWorld().showText("You hit your head and Died", getWorld().getWidth()/2, getWorld().getHeight()/2 );
            Greenfoot.stop();
        }
    }
    
    /**
     * lookForTail hitting the body of the snake will make you lose
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    private void lookForTail()
    {
        if( isTouching(Snake.class) )
        {
            getWorld().showText("You Lost", getWorld().getWidth()/2, getWorld().getHeight()/2 );
            Greenfoot.stop();
        }
    }
    
    /**
     * follow makes the tail attached to the head
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    private void follow()
    {
        MyWorld myWorld = (MyWorld)getWorld();
        x = myWorld.getMyX(s);
        y = myWorld.getMyY(s);
        setLocation(x, y);
    }

    /**
     * growTail adds an additional tail to the snake player model
     * 
     * @param there are no parameters
     * @return nothing is returned
     */
    private void growTail()
    {
        MyWorld myWorld = (MyWorld)getWorld();
        myWorld.addSnake();
    }
}
