import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter {

	public ArrayList<Location> getMoveLocations() {

	    ArrayList<Location> locs = new ArrayList<Location>();

		int l = getDirection() - 90;
		int r = getDirection() + 90;

		getTwoMovesAway(locs, r);
		getTwoMovesAway(locs, r);

	    return locs;
	}

	public void  getTwoMovesAway(ArrayList<Location> locs, int direction) {

	Location neighborLoc1 = getLocation().getAdjacentLocation(direction);

	if (getGrid().isValid(neighborLoc1) && getGrid().get(neighborLoc1) == null) {
		Location neighborLoc2 = neighborLoc1.getAdjacentLocation(direction);
		if (getGrid().isValid(neighborLoc2) && getGrid().get(neighborLoc2) == null) {
			locs.add(neighborLoc2); 
		}
	}


	}

}
