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
public class ChameleonKid extends ChameleonCritter
{

    public ArrayList<Actor> getActors() {
        ArayList<Actor> actors = new ArrayList<Actor>();

        Location[] locs = new Location[2];
        locs[0] = getLocation().getAdjacentLocation(getDirection());
        locs[1] = getLocation().getAdjacentLocation(getDirection() + 180);

        for (Location loc: locs) {
            if (getGrid().isValid(loc)) {
                Actor a = getGrid().get(loc);
                if (a != null) {
                    actors.add(a);
                }
            }
             
         } 
         return actors;
    }

}
  

