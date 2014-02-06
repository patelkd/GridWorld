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
    private static final double DARKENING_FACTOR = 0.05;


	public BlusterCritter() {
		int c = 12;
	}

    public ArrayList getCritters() {

        ArrayList<Actor> actors = new ArrayList<Actor>(); 

        Location loc = getLocation();
        for (int r=loc.getRow()-2; r<=loc.getRow() +2; r++) {
            for (int c=loc.getCol()-2; c <= loc.getCol() +2 ; c++) {
                Location temporary = new Location(r,c);
                if (getGrid().isValid(temporary)) {
                    Actor a = getGrid().get(temporary);
                    if (a!= null && a !=this) {
                        actors.add(a);
                    }
                }
                
            }
        }
        return actors;
    }


    public void processActors(ArrayList<Actor> actors) {
     for (Actor a : actors)
     {
         if ((a instanceof Critter)) {
             counter ++;
         }
         if (counter < c) {
            lighten();
         } else {
            darken();
         }

      } 

    }

    public void darken() {

        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
    }

    public void lighten() {
        Color c = getColor();
        int red = (int) (c.getRed() * (DARKENING_FACTOR-1));
        int green = (int) (c.getGreen() * (DARKENING_FACTOR-1));
        int blue = (int) (c.getBlue() * (DARKENING_FACTOR-1));

        setColor(new Color(red, green, blue));
    }
    

}
  

