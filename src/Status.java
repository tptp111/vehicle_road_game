/**
 * Class which contains the information on the status of the user within the game.
 *
 */
public class Status
{
    private double fuel;
    private int health;
    private int roadLocation;
    private int distanceTravelled;

    /**
     * Default constructor which creates object of the class Status.
     *
     */
    public Status() {
        fuel = 0;
        health = 0;
        roadLocation = 0;
        distanceTravelled = 0;
    }

    /**
     * Non-default constructor which creates object of the class Status.
     *
     * @param fuel      Current fuel of player's vehicle as a double.
     * @param health    Current health of player's vehicle as an integer.
     */
    public Status(double fuel, int health) {
        this.fuel = fuel;
        this.health = health;
        this.roadLocation = 0;
        this.distanceTravelled = 0;
    }

    /**
     * Non-default constructor which creates object of the class Status.
     *
     * @param fuel                   Current fuel of player's vehicle as a double.
     * @param health                 Current health of player's vehicle as an integer.
     * @param roadLocation           Location of which road the player is on as an integer.
     * @param distanceTravelled      Index of how far the player has travelled along the highway as an integer.
     */
    public Status(double fuel, int health, int roadLocation, int distanceTravelled) {
        this.fuel = fuel;
        this.health = health;
        this.roadLocation = roadLocation;
        this.distanceTravelled = distanceTravelled;
    }

    /**
     * Mutator method which applies a penalty to the user status depending on which roadblock the user crosses.
     *
     * @param roadblock     Roadblock as a String.
     */
    public void applyPenalty(String roadblock) {
        switch (roadblock) {
            case "F": {
                this.fuel = fuel + 10;
                break;
            }
            case "B": {
                this.health = health - 20;
                break;
            }
            case "S": {
                this.health = health - 45;
                break;
            }
            case "O": {
                this.health = health - 60;
                break;
            }
            default: {
                break;
            }
        }
    }

    /**
     * Display method which returns the String of the state of the fields in the Status object.
     *
     * @return      The state of the Status object as a string.
     */
    public String display() {
        return "Fuel: " + fuel + " Health: " + health + " Road Location: " + roadLocation + " Distance Travelled: " + distanceTravelled;
    }

    /**
     * Accessor method to get the current fuel of the player's vehicle.
     *
     * @return      Fuel of the player's vehicle as a double.
     */
    public double getFuel() {
        return fuel;
    }

    /**
     * Accessor method to get the current health of the player's vehicle.
     *
     * @return      Health of the player's vehicle as an integer.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Accessor method to get the location of which road the player is on.
     *
     * @return      Location of which road the player is on as an integer.
     */
    public int getRoadLocation() {
        return roadLocation;
    }

    /**
     * Accessor method to get how far the player has travelled.
     *
     * @return      How far the player has travelled as an integer.
     */
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    /**
     * Mutator method to set the current fuel of the player's vehicle.
     *
     * @param fuel      Current fuel of player's vehicle as a double.
     */
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    /**
     * Mutator method to set the current health of the player's vehicle.
     *
     * @param health        Current health of player's vehicle as an integer.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Mutator method to set the location of which road the player is on.
     *
     * @param roadLocation       Location of which road the player is on as an integer.
     */
    public void setRoadLocation(int roadLocation) {
        this.roadLocation = roadLocation;
    }

    /**
     * Mutator method to set an index of how far the player has travelled along the highway.
     *
     * @param distanceTravelled   Index of how far the player has travelled along the highway as an integer.
     */
    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }
}