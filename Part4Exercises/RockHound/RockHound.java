import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import java.util.ArrayList;
import java.awt.Color;


/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class RockHound extends Critter
{

    public void processActors(ArrayList<Actor> actors) {
     for (Actor a : actors)
     {
         if ((a instanceof Rock) && !(a instanceof Critter))
             a.removeSelfFromGrid();
         }
     }       
    


}
  

