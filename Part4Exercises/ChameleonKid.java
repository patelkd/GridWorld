import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;

import java.util.ArrayList;
import java.awt.Color;


/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ChameleonKid extends ModifiedChameleonCritter
{
    private static final Color DEFAULT_COLOR = Color.PINK;
    private static final double DARKENING_FACTOR = 0.05;
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0) {
            darkenChameleon();
            return;
        }
        int r = (int) (Math.random() * n);
        Actor other = actors.get(r);
        setColor(other.getColor());
    }

    /**
     * Turns towards the new location as it moves.
     */
    // public void makeMove(Location loc)
    // {
    //     setDirection(getLocation().getDirectionToward(loc));
    //     super.makeMove(loc);
    // }

    // public void darkenChameleon () {
    //     Color c = getColor();
    //     int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
    //     int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
    //     int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

    //     setColor(new Color(red, green, blue));
    // }

    public ArrayList<Actor> getActors() { 
        ArrayList<Actor> actors = new ArrayList<Actor>(); 
        int[] directions = 
        { Location.AHEAD, Location.HALF_CIRCLE }; 
        for (Location loc : getLocationsInDirections(directions)) 
        { 
         Actor a = getGrid().get(loc); 
        if (a != null) 
        actors.add(a); 
        } 
        return actors;
     }

     public ArrayList<Location> getLocationsInDirections(int[] directions) { 
        ArrayList<Location> locs = new ArrayList<Location>(); 
        Grid gr = getGrid(); 
         Location loc = getLocation(); 
         for (int d : directions) { 
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d); 
            if (gr.isValid(neighborLoc)) 
             locs.add(neighborLoc); 
        } 
        return locs;
    }

}

