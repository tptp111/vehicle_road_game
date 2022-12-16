/**
 * Class which contains the main class to start the game.
 *
 */
public class GameController
{
    /**
     * Main method to start the game.
     *
     * @param args      Command line arguments as represented by an array of String objects.
     */
    public static void main(String[] args) {
        Game game = new Game();

        System.out.println("Welcome to the vehicle obstacle course!\n");
        game.getPlayer().inputPlayerName();
        System.out.println("Welcome " + game.getPlayer().getName() +"\n");

        System.out.println("Please select difficulty:");
        game.getDifficulty().selectDifficulty();
        System.out.println("You have selected: " + game.getDifficulty().getName() + "\n");

        System.out.println("Please select an escape vehicle:");
        game.getVehicles().selectVehicle("vehicles.txt");
        System.out.println("You have selected: " + game.getVehicles().getType() + "\n");

        int highwayLength = game.getDifficulty().getHighwayLength();
        double maxFuel = game.getDifficulty().getMaxFuel() * game.getVehicles().getMaxFuel();
        int health = game.getVehicles().getMaxDamage();
        int noRoadblocks = game.getDifficulty().getNoRoadblocks();
        String[] road1 = Road.generateRoad(highwayLength);
        String[] road2 = Road.generateRoad(highwayLength);
        String[] road3 = Road.generateRoad(highwayLength);
        game.setStatus(new Status(maxFuel, health));
        game.setHighway(new Highway(road1, road2, road3));
        game.getHighway().assignRandomRoadblock(highwayLength, noRoadblocks);
        game.assignRandomRoad();

        String gameResults = game.playGame();
        game.writeGameResults("output.txt", gameResults);
    }
}