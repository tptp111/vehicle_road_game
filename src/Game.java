import java.io.FileWriter;
import java.util.Random;

/**
 * Class which contains the game mechanics and ties in all server classes.
 * The Game class is served by the Player class, Difficulty class, Vehicles class, Status class, and Highway class which stores the content of the Game.
 * Any method that utilises at least two of server classes mentioned above is included in the Game class.
 *
 */
public class Game
{
    private Player player;
    private Difficulty difficulty;
    private Vehicles vehicles;
    private Status status;
    private Highway highway;

    /**
     * Default constructor which creates object of the class Game.
     *
     */
    public Game() {
        player = new Player();
        difficulty = new Difficulty();
        vehicles = new Vehicles();
        status = new Status();
        highway = new Highway();
    }

    /**
     * Non-default constructor which creates object of the class Game.
     *
     * @param player         Stores the player information as a Player object.
     * @param difficulty     Stores the difficulty information as a Difficulty object.
     * @param vehicles       Stores the vehicles information as a Vehicles object.
     * @param status         Stores the status information as a Status object.
     * @param highway        Stores the highway information as a Highway object.
     */
    public Game(Player player, Difficulty difficulty, Vehicles vehicles, Status status, Highway highway) {
        this.player = player;
        this.difficulty = difficulty;
        this.vehicles = vehicles;
        this.status = status;
        this.highway = highway;
    }

    /**
     * Assign method which places the player ( @ ) on a random road of the highway object.
     * It then updates the status of the player's road location which road @ is on.
     *
     */
    public void assignRandomRoad() {
        Random random = new Random();
        int randomInt = 1 + random.nextInt(3);
        switch (randomInt) {
            case 1: {
                String[] road1 = highway.getRoad1();
                road1[0] = "@";
                this.highway.setRoad1(road1);
                this.status.setRoadLocation(1);
                break;
            }
            case 2: {
                String[] road2 = highway.getRoad2();
                road2[0] = "@";
                this.highway.setRoad2(road2);
                this.status.setRoadLocation(2);
                break;
            }
            case 3: {
                String[] road3 = highway.getRoad3();
                road3[0] = "@";
                this.highway.setRoad3(road3);
                this.status.setRoadLocation(3);
                break;
            }
            default: {
                System.out.println("Error in random number generator");
            }
        }
    }

    /**
     * Display method which returns the String of the state of the fields in the Game object.
     *
     * @return      The state of the Game object as a string.
     */
    public String display() {
        return player.display() + "\n" + difficulty.display() + "\n" + vehicles.display() + "\n" + status.display() + "\n" + highway.display();
    }

    /**
     * Accessor method to get the difficulty object which contains information on the game difficulty.
     *
     * @return      The difficulty object stored as a Difficulty.
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Accessor method to get the highway object which contains information on the game highway.
     *
     * @return      The highway object stored as a Highway.
     */
    public Highway getHighway() {
        return highway;
    }

    /**
     * Accessor method to get the player object which contains information on the game player.
     *
     * @return      The player object stored as a Player.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Accessor method to get the vehicles object which contains information on the game vehicles.
     *
     * @return      The vehicles object stored as a Vehicles.
     */
    public Vehicles getVehicles() {
        return vehicles;
    }

    /**
     * Accessor method to get the status object which contains information on the game status.
     *
     * @return      The status object stored as a Status.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Menu method to display the choices of the player's movement.
     *
     */
    public void moveGetMenu() {
        System.out.println("Make a move");
        System.out.println("Select 1: Move forward");
        System.out.println("Select 2: Swerve up");
        System.out.println("Select 3: Swerve down");
        System.out.println("Select 4: boost");
    }

    /**
     * Movement method to move the player forward on the road by the boostSpeed times 1 array index.
     * Applies a roadblock penalty if the player crosses a roadblock during the boost.
     * Consumes 3 times the normal fuel of moveForward() for each 1 array index forward.
     *
     * @param boostSpeed        Boost speed of player's vehicle as an integer.
     */
    public void moveBoost(int boostSpeed) {
        for (int i = 0; i < boostSpeed; i++) {
            double fuel = status.getFuel();
            status.setFuel(fuel - 2);
            moveForward();
        }
    }

    /**
     * Movement method to move the player forward on the road by 1 array index.
     * Applies a roadblock penalty if the player moves into a roadblock.
     * Consumes 1 fuel.
     *
     */
    public void moveForward() {
        int roadLocation = status.getRoadLocation();
        int distanceTravelled = status.getDistanceTravelled();
        double fuel = status.getFuel();
        switch (roadLocation) {
            case 1: {
                String[] road1 = highway.getRoad1();
                status.setFuel(fuel - 1);
                status.applyPenalty(road1[distanceTravelled + 1]);
                road1[distanceTravelled] = "~";
                road1[distanceTravelled + 1] = "@" ;
                highway.setRoad1(road1);
                status.setDistanceTravelled(distanceTravelled + 1);
                break;
            }
            case 2: {
                String[] road2 = highway.getRoad2();
                status.setFuel(fuel - 1);
                status.applyPenalty(road2[distanceTravelled + 1]);
                road2[distanceTravelled] = "~";
                road2[distanceTravelled + 1] = "@" ;
                highway.setRoad2(road2);
                status.setDistanceTravelled(distanceTravelled + 1);
                break;
            }
            case 3: {
                String[] road3 = highway.getRoad3();
                status.setFuel(fuel - 1);
                status.applyPenalty(road3[distanceTravelled + 1]);
                road3[distanceTravelled] = "~";
                road3[distanceTravelled + 1] = "@" ;
                highway.setRoad3(road3);
                status.setDistanceTravelled(distanceTravelled + 1);
                break;
            }
        }
    }

    /**
     * Movement method to move the player down the road and forward 1 array index.
     * Applies a roadblock penalty if the player moves into a roadblock.
     * Consumes 2 fuel.
     *
     */
    public void moveSwerveDown() {
        int roadLocation = status.getRoadLocation();
        int distanceTravelled = status.getDistanceTravelled();
        double fuel = status.getFuel();
        switch (roadLocation) {
            case 1: {
                String[] road1 = highway.getRoad1();
                String[] road2 = highway.getRoad2();
                status.setFuel(fuel - 2);
                status.applyPenalty(road2[distanceTravelled + 1]);
                road1[distanceTravelled] = "~";
                road2[distanceTravelled + 1] = "@";
                highway.setRoad1(road1);
                highway.setRoad2(road2);
                status.setRoadLocation(2);
                status.setDistanceTravelled(distanceTravelled + 1);
                break;
            }
            case 2: {
                String[] road2 = highway.getRoad2();
                String[] road3 = highway.getRoad3();
                status.setFuel(fuel - 2);
                status.applyPenalty(road3[distanceTravelled + 1]);
                road2[distanceTravelled] = "~";
                road3[distanceTravelled + 1] = "@";
                highway.setRoad2(road2);
                highway.setRoad3(road3);
                status.setRoadLocation(3);
                status.setDistanceTravelled(distanceTravelled + 1);
                break;
            }
            case 3: {
                String[] road3 = highway.getRoad3();
                status.setFuel(fuel - 2);
                status.applyPenalty(road3[distanceTravelled + 1]);
                road3[distanceTravelled] = "~";
                road3[distanceTravelled + 1] = "@";
                highway.setRoad3(road3);
                status.setRoadLocation(3);
                status.setDistanceTravelled(distanceTravelled + 1);
                break;
            }
        }
    }

    /**
     * Movement method to move the player down the road and down 1 array index.
     * Applies a roadblock penalty if the player moves into a roadblock.
     * Consumes 2 fuel.
     *
     */
    public void moveSwerveUp() {
        int roadLocation = status.getRoadLocation();
        int distanceTravelled = status.getDistanceTravelled();
        double fuel = status.getFuel();
        switch (roadLocation) {
            case 1: {
                String[] road1 = highway.getRoad1();
                status.setFuel(fuel - 2);
                status.applyPenalty(road1[distanceTravelled + 1]);
                road1[distanceTravelled + 1] = "@";
                road1[distanceTravelled] = "~";
                highway.setRoad1(road1);
                status.setRoadLocation(1);
                status.setDistanceTravelled(distanceTravelled + 1);
                break;
            }
            case 2: {
                String[] road1 = highway.getRoad1();
                String[] road2 = highway.getRoad2();
                status.setFuel(fuel - 2);
                status.applyPenalty(road1[distanceTravelled + 1]);
                road1[distanceTravelled + 1] = "@";
                road2[distanceTravelled] = "~";
                highway.setRoad1(road1);
                highway.setRoad2(road2);
                status.setRoadLocation(1);
                status.setDistanceTravelled(distanceTravelled + 1);
                break;
            }
            case 3: {
                String[] road2 = highway.getRoad2();
                String[] road3 = highway.getRoad3();
                status.setFuel(fuel - 2);
                status.applyPenalty(road2[distanceTravelled + 1]);
                road2[distanceTravelled + 1] = "@";
                road3[distanceTravelled] = "~";
                highway.setRoad2(road2);
                highway.setRoad3(road3);
                status.setRoadLocation(2);
                status.setDistanceTravelled(distanceTravelled + 1);
                break;
            }
        }
    }

    /**
     * Play method which allows the user to play the game.
     *
     * @return      Results of the game as a a string.
     */
    public String playGame() {
        Input input = new Input();
        boolean continueGame = true;
        boolean healthAboveZero = true;
        boolean fuelAboveZero = true;
        boolean notFinishedHighway = true;
        int highwayLength = difficulty.getHighwayLength();
        int boostSpeed = vehicles.getBoostSpeed();
        double maxFuel = status.getFuel();
        String gameResults = "";
        try {
            do {
                System.out.print("Length of Highway: " + highwayLength + " ");
                System.out.println(status.display());
                highway.printHighway(status.getDistanceTravelled(), 10);
                moveGetMenu();
                String moveSelection = input.acceptStringInput("");
                switch (moveSelection) {
                    case "1":
                        moveForward();
                        break;
                    case "2":
                        moveSwerveUp();
                        break;
                    case "3":
                        moveSwerveDown();
                        break;
                    case "4":
                        moveBoost(boostSpeed);
                        break;
                    default:
                        System.out.println("Please select 1, 2, 3 or 4.\n");
                        break;
                }
                if (status.getFuel() > maxFuel) {
                    status.setFuel(maxFuel);
                }
                if (status.getHealth() <= 0) {
                    healthAboveZero = false;
                }
                if (status.getFuel() <= 0) {
                    fuelAboveZero = false;
                }
                if (highwayLength < status.getDistanceTravelled()) {
                    notFinishedHighway = false;
                }
                continueGame = healthAboveZero & fuelAboveZero & notFinishedHighway;
            } while (continueGame);
            if (healthAboveZero == false) {
                gameResults = "Oh no, it looks like your vehicle has broken down.";
            }
            else if (fuelAboveZero == false) {
                gameResults = "Your vehicle is out of fuel better luck next time.";
            }
            else if (notFinishedHighway == false) {
                status.setDistanceTravelled(highwayLength);
                gameResults = "Congratulations you have escaped!";
            }
            System.out.println(gameResults);
        }
        catch (Exception e) {
            status.setDistanceTravelled(highwayLength);
            gameResults = "Congratulations you have escaped!";
            System.out.println(gameResults);
        }
        System.out.println(status.display());
        return gameResults;
    }

    /**
     * Mutator method to set the difficulty.
     *
     * @param difficulty         A Difficulty object containing information on the game difficulty.
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Mutator method to set the highway.
     *
     * @param highway       A Highway object containing information on the game highway.
     */
    public void setHighway(Highway highway) {
        this.highway = highway;
    }

    /**
     * Mutator method to set the player.
     *
     * @param player        A Player object containing information on the game player.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Mutator method to set the Vehicles.
     *
     * @param vehicles      A Vehicles object containing information on the game vehicles.
     */
    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Mutator method to set the status.
     *
     * @param status        A Status object containing information on the game status.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Writes the results of the game to a file.
     *
     * @param filename           Name of file as a String.
     * @param gameResults        Results of the game as a String.
     */
    public void writeGameResults(String filename, String gameResults) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(status.display() + "\n");
            writer.write(gameResults);
        }
        catch (Exception e) {
            System.out.println("There was a problem writing to the file");
        }
    }
}
