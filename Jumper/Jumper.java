// package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;

import java.awt.Color;


public class Jumper extends Actor
{
    /**
     * Constructs a red bug.
     */
    public Jumper()
    {
        setColor(Color.RED);
    }

    /**
     * Constructs a bug of a given color.
     * @param bugColor the color for this bug
     */
    public Jumper(Color bugColor)
    {
        setColor(bugColor);
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canJump())
            jump();
        else
            turn();
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
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

    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * @return true if this bug can move.
     */
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
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
}
