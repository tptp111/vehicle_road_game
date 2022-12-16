import java.util.Random;

/**
 * Class which generates and contains information on game difficulty.
 *
 */
public class Difficulty
{
    private String name;
    private int highwayLength;
    private double maxFuel;
    private int noRoadblocks;

    /**
     * Default constructor which creates object of the class Difficulty.
     *
     */
    public Difficulty() {

    }

    /**
     * Non-default constructor which creates object of the class Difficulty.
     *
     * @param name               Sets the name of the difficulty as a String.
     * @param highwayLength      Sets the highwayLength as an integer.
     * @param maxFuel            Sets the maxFuel as a double.
     * @param noRoadblocks       Sets the noRoadblocks as an integer.
     */
    public Difficulty(String name, int highwayLength, double maxFuel, int noRoadblocks) {
        this.name = name;
        this.highwayLength = highwayLength;
        this.maxFuel = maxFuel;
        this.noRoadblocks = noRoadblocks;
    }

    /**
     * Display method which returns the String of the state of the fields in the Difficulty object.
     *
     * @return      The state of the Difficulty object as a string.
     */
    public String display() {
        return "HighwayLength: " + this.highwayLength + "\nMaxFuel: " + this.maxFuel + "\nNoRoadblocks: " + this.noRoadblocks;
    }

    /**
     * Display method which displays the difficulty menu.
     *
     */
    public void displayMenu() {
        System.out.println("Select 1: Easy");
        System.out.println("Select 2: Moderate");
        System.out.println("Select 3: Hard");
    }

    /**
     * Accessor method to get the highwayLength field which contains information on the difficulty highway length.
     *
     * @return      The highwayLength field stored as an integer.
     */
    public int getHighwayLength() {
        return highwayLength;
    }

    /**
     * Accessor method to get the maxFuel field which contains information on the difficulty maximum fuel multiplier.
     *
     * @return      The maxFuel field stored as a double.
     */
    public double getMaxFuel() {
        return maxFuel;
    }

    /**
     * Accessor method to get the name field which contains information on the difficulty name. For example: Easy, Moderate, Hard.
     *
     * @return      The name field stored as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor method to get the noRoadBlocks field which contains information on the number roadblocks associated with the difficulty.
     *
     * @return      The noRoadblocks field stored as an integer.
     */
    public int getNoRoadblocks() {
        return noRoadblocks;
    }

    /**
     * Selection method to allow the user to select the difficulty of the game.
     *
     */
    public void selectDifficulty() {
        Input input = new Input();
        Validation valid = new Validation();
        Random random = new Random();
        boolean flag = true;
        do {
            displayMenu();
            String selection = input.acceptStringInput("Select from the above:");
            switch (selection) {
                case "1": {
                    this.name = "Easy";
                    this.highwayLength = 10 + random.nextInt(6);
                    this.maxFuel = 1.0;
                    this.noRoadblocks = 12;
                    flag = false;
                    break;
                }
                case "2": {
                    this.name = "Moderate";
                    this.highwayLength = 15 + random.nextInt(16);
                    this.maxFuel = 0.8;
                    this.noRoadblocks = 24;
                    flag = false;
                    break;
                }
                case "3": {
                    this.name = "Hard";
                    this.highwayLength = 30 + random.nextInt(16);
                    this.maxFuel = 0.5;
                    this.noRoadblocks = 45;
                    flag = false;
                    break;
                }
                case "":
                    System.out.println("Selection cannot be blank");
                default: {
                    System.out.println("Please select 1, 2, or 3.\n");
                    break;
                }
            }
        } while (flag);
    }

    /**
     * Mutator method to set the highway length of the Difficulty class.
     *
     * @param highwayLength     An integer containing information on the length of the highway for the difficulty.
     */
    public void setHighwayLength(int highwayLength) {
        this.highwayLength = highwayLength;
    }

    /**
     * Mutator method to set the maximum fuel of the Difficulty class.
     *
     * @param maxFuel       An integer containing information on the maximum fuel for the difficulty.
     */
    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }

    /**
     * Mutator method to set the name of the Difficulty class.
     *
     * @param name      An integer containing information on the name of the difficulty.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mutator method to set the number of roadblocks of the Difficulty class.
     *
     * @param noRoadblocks      An integer containing information on the number of roadblocks for the difficulty.
     */
    public void setNoRoadblocks(int noRoadblocks) {
        this.noRoadblocks = noRoadblocks;
    }
}
