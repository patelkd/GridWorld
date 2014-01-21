import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int length;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        this.setDirection(Location.EAST); 
        steps = 0;
        length = 1;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (length <= 3 && steps < sideLength) {
            if (canMove()) {
                move();
                steps++;
            }
        } else if (length ==1) {
            setDirection(Location.SOUTHWEST);
            steps=0;
            length++;
        } else if (length == 2) {
            setDirection(Location.EAST);
            steps = 0;
            length++;
        }
        
    }
}
