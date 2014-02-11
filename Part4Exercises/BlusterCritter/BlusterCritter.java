import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

import java.awt.Color;

public class BlusterCritter extends Critter {

    private int c = 3;

    public void processActors(ArrayList<Actor> actors)
    {
        int counter = 0;

        for (Actor a : actors) {
            if (a instanceof Critter) {
                counter++;
            }
            if (counter < c) {
                lighten();
            }else {
                darken();
            }
        }

    }

    public ArrayList<Actor> getActors(){
        ArrayList<Actor> actors = new ArrayList<Actor>();

        for (int row = getLocation().getRow() - 2; row <= getLocation().getRow() + 2; row++) {
            for (int col = getLocation().getCol() - 2; col <= getLocation().getCol() + 2; col++) {

                Location loc = new Location(row, col);

                if (getGrid().isValid(loc)) {
                    Actor actor = getGrid().get(loc);

                    if (actor != null) {
                        actors.add(actor);
                    }
                }
            }
        }
        actors.remove(getLocation());
        return actors;
    }
    public void lighten(){
        Color color = getColor();

        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        if (red <= 200-DARKENING_FACTOR) {
            red = (int) (color.getRed() + DARKENING_FACTOR);
        }

        if (green <= 200-DARKENING_FACTOR) {
            green = (int) (color.getGreen() + DARKENING_FACTOR);
        }

        if (blue <= 200-DARKENING_FACTOR) {
            blue = (int) (color.getBlue() + DARKENING_FACTOR);
        }

        setColor(new Color(red, green, blue));
    }

    private static final double DARKENING_FACTOR = 50;

    public void darken(){
        Color color = getColor();

        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        if (red >= 200-DARKENING_FACTOR) {
            red = (int) (color.getRed() - DARKENING_FACTOR);
        }
        if (green >= 200-DARKENING_FACTOR) {
            green = (int) (color.getGreen() - DARKENING_FACTOR);
        }
        if (blue >= 200-DARKENING_FACTOR) {
            blue = (int) (color.getBlue() - DARKENING_FACTOR);
        }

        setColor(new Color(red, green, blue));

    }

    
}

