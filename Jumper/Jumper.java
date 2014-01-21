// package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;

import java.awt.Color;


public class Jumper extends Actor
{
   
     //red bug.

    public Jumper()
    {
        this(Color.RED);
    }

  
    //Constructs a bug of a given color.
     
    public Jumper(Color bugColor)
    {
        setColor(bugColor);
    }

    
    //Jumps if it can, turns otherwise.
   
    public void act()
    {
        if (canJump())
            jump();
        else
            turn();
    }

    //Turns the bug 45 degrees clockwise without changing its location.
    
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

  
    //Bug jumps two forward; leaves no flower
    
    public void jump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location nextTwo = next.getAdjacentLocation(getDirection());
        if (gr.isValid(nextTwo))
            moveTo(nextTwo);
        else
            removeSelfFromGrid();
    }

    
     //Tests whether this bug can jumps into a location that is empty
     // @return true if this bug can move.
     
    public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location nextTwo = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(nextTwo))
            return false;
        Actor neighbor = gr.get(nextTwo);
        return (neighbor == null);
        // ok to move into empty location
        // not ok to move onto any other actor 
    }
}
