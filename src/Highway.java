import java.util.Arrays;
import java.util.Random;

/**
 * Class which contains the highway information. The highway is made of three roads which are each represented as a String[].
 *
 */
public class Highway {
    private String[] road1;
    private String[] road2;
    private String[] road3;

    /**
     * Default constructor which creates object of the class Highway.
     *
     */
    public Highway() {
        this.road1 = new Road().generateRoad(0);
        this.road2 = new Road().generateRoad(0);
        this.road3 = new Road().generateRoad(0);
    }

    /**
     * Non-default constructor which creates object of the class Highway.
     *
     * @param road1                  Sets the first road as a String[].
     * @param road2                  Sets the second road as a String[].
     * @param road3                  Sets the third road as a String[].
     */
    public Highway(String[] road1, String[] road2, String[] road3) {
        this.road1 = road1;
        this.road2 = road2;
        this.road3 = road3;
    }

    /**
     * Assign method which allocates roadblocks to a random road and a random index along the road after the third index.
     *
     * @param highwayLength          The maximum length of the road as an integer.
     * @param noRoadblocks           The maximum number of roadblocks in the game.
     */
    public void assignRandomRoadblock(int highwayLength, int noRoadblocks)
    {
        Random random = new Random();
        int countRoadblocks = 0;
        while (countRoadblocks < noRoadblocks)
        {
            String roadblock = new Road().generateRoadblock();
            int randomRoad = 1 + random.nextInt(3);
            int randomIndex = 3 + random.nextInt(highwayLength - 3);
            switch (randomRoad)
            {
                case 1:
                {
                    this.road1[randomIndex] = roadblock;
                    break;
                }
                case 2:
                {
                    this.road2[randomIndex] = roadblock;
                    break;
                }
                case 3:
                {
                    this.road3[randomIndex] = roadblock;
                    break;
                }
                default:
                {
                    System.out.println("Error in random number generator");
                }
            }
            countRoadblocks++;
        }
    }

    /**
     * Display method which returns the String of the state of the fields in the Highway object.
     *
     * @return      The state of the Highway object as a string.
     */
    public String display() {
        return "road1: " + Arrays.toString(road1) + "\nroad2: " + Arrays.toString(road2) + "\nroad3: " + Arrays.toString(road3);
    }

    /**
     * Accessor method to get road1 which contains information on the first road in the highway.
     *
     * @return       The first road as a String[].
     */
    public String[] getRoad1() {
        return road1;
    }

    /**
     * Accessor method to get road2 which contains information on the second road in the highway.
     *
     * @return       The second road as a String[].
     */
    public String[] getRoad2() {
        return road2;
    }

    /**
     * Accessor method to get road3 which contains information on the third road in the highway.
     *
     * @return      The third road as a String[].
     */
    public String[] getRoad3() {
        return road3;
    }

    /**
     * Display method to print the entire highway consisting of three roads.
     *
     */
    public void printHighway() {
        printRoad(road1);
        printRoad(road2);
        printRoad(road3);
    }

    /**
     * Display method to print a section of the highway consisting of three roads.
     *
     * @param visibilityStart                Index to begin printing the highway as an integer.
     * @param visibilityDistance             How far beyond the visibility start to print the highway as an integer e.g. 10.
     */
    public void printHighway(int visibilityStart, int visibilityDistance) {
        printRoad(road1, visibilityStart, visibilityDistance);
        printRoad(road2, visibilityStart, visibilityDistance);
        printRoad(road3, visibilityStart, visibilityDistance);
    }

    /**
     * Display method to print a road.
     *
     * @param road   String[] which represents the road.
     */
    public void printRoad(String[] road) {
        for (int i = 0; i < road.length; i++) {
            System.out.print(road[i] + " ");
        }
        System.out.print("\n");
    }

    /**
     * Display method to print a road depending on the visibility start and the visibility distance.
     *
     * @param road                           String[] which represents the road.
     * @param visibilityStart                Index to begin printing the road as an integer.
     * @param visibilityDistance             How far beyond the visibility start to print the road as an integer e.g. 10.
     */
    public void printRoad(String[] road, int visibilityStart, int visibilityDistance) {

        if (visibilityStart + visibilityDistance < road.length) {
            for (int i = visibilityStart; i < visibilityStart + visibilityDistance; i++) {
                System.out.print(road[i] + " ");
            }
        }
        else {
            for (int i = road.length - visibilityDistance; i < road.length; i++) {
                System.out.print(road[i] + " ");
            }
        }
        System.out.print("\n");
    }

    /**
     * Mutator method to set the road1 of the Highway class.
     *
     * @param road1     A String[] containing information on the road1.
     */
    public void setRoad1(String[] road1) {
        this.road1 = road1;
    }

    /**
     * Mutator method to set the road1 of the Highway class.
     *
     * @param road2     A String[] containing information on the road2.
     */
    public void setRoad2(String[] road2) {
        this.road2 = road2;
    }

    /**
     * Mutator method to set the road3 of the Highway class.
     *
     * @param road3     A String[] containing information on the road3.
     */
    public void setRoad3(String[] road3) {
        this.road3 = road3;
    }
}
