import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;

import java.util.ArrayList;
import java.awt.Color;


public class BlusterCritter extends Critter
{
	private int c;
    private int counter;

	public BlusterCritter() {
		int c = 12;
	}


    public void processActors(ArrayList<Actor> actors) {
     for (Actor a : actors)
     {
         if ((a instanceof Critter)) {
             counter ++;
         }
      } 
    }
    

    public void getCritters() {
        Location loc = getLocation();
        for (int r=loc.getRow() -2; r<= loc.getRow() +2; r++) {
            for (int c=loc.getCol()-2; c <= loc.getCol() +2 ; c++) {
                Location temporary = new Location(r,c);
                if (getGrid().isValid(temporary)) {
                    Actor a = getGrid().get(temporary);
                    if (a!= null && a !=this) {
                        actors.add(a);
                    }
                }
                return actors;
            }
        }

    }


}
  

