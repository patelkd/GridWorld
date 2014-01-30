import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;

import java.util.ArrayList;
import java.awt.Color;


public class BlusterCritter extends Critter
{
	private int c;

	public BlusterCritter(int c) {
		int c = 12;
	}

	public ArrayList<Actor> getActors()
	{
	    return getGrid().getNeighbors(getLocation());
	}

    public void processActors(ArrayList<Actor> actors) {
     for (Actor a : actors)
     {
         if ((a instanceof Rock) && !(a instanceof Critter))
             a.removeSelfFromGrid();
         }
     }       
    

    public void getCritters() {
    	
    }


}
  

