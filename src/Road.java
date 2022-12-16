import java.util.Random;

/**
 * Class which constructs the roads for the Highway class.
 *
 */
public class Road
{
    /**
     * Default constructor which creates object of the class Road.
     *
     */
    public Road() {

    }

    /**
     * Generation method which generates a road as a String[].
     *
     * @param highwayLength     An integer of the length of the road.
     * @return      A road represented by a String[] of ~.
     */
    public static String[] generateRoad(int highwayLength) {
        String[] road = new String[highwayLength];
        for (int i = 0; i < highwayLength; i++) {
            road[i] = "~";
        }
        return road;
    }

    /**
     * Generation method which generates a roadblock.
     *
     * @return      A roadblock represented by a String.
     */
    public String generateRoadblock() {
        Random random = new Random();
        int randomNum = random.nextInt(10) + 1;
        if (randomNum <= 3) {
            return "F";
        }
        else if (randomNum <= 7) {
            return "B";
        }
        else if (randomNum <= 9) {
            return "S";
        }
        else
            return "O";
    }
}
