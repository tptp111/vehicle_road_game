import java.util.Scanner;
import java.io.FileReader;

/**
 * Class which contains the information on the vehicle that the user has selected.
 */
public class Vehicles {

    private String type;
    private int boostSpeed;
    private int maxFuel;
    private int maxDamage;

    /**
     * Default constructor which creates object of the class Vehicles.
     *
     */
    public Vehicles() {
        type = "unknown";
        boostSpeed = 0;
        maxFuel = 0;
        maxDamage = 0;
    }

    /**
     * Non-default constructor which creates object of the class Vehicles.
     *
     * @param type                           Type of vehicle as String.
     * @param boostSpeed                     Boost speed of the vehicle as an integer.
     * @param maxFuel                        Maximum fuel of the vehicle as an integer.
     * @param maxDamage                      Maximum damage the vehicle can take as an integer.
     */
    public Vehicles(String type, int boostSpeed, int maxFuel, int maxDamage) {
        this.type = type;
        this.boostSpeed = boostSpeed;
        this.maxFuel = maxFuel;
        this.maxDamage = maxDamage;
    }

    /**
     * Display method which returns the String of the state of the fields in the Vehicles object.
     *
     * @return                   The state of the Vehicles object as a string.
     */
    public String display() {
        return "type: " + type + "\nBoostSpeed: " + boostSpeed + "\nMaxFuel: " + maxFuel + "\nMaxDamage: " + maxDamage;
    }

    /**
     * Accessor method to get the boost speed of the vehicle.
     *
     * @return                   Boost speed of the vehicle as an integer.
     */
    public int getBoostSpeed() {
        return boostSpeed;
    }

    /**
     * Accessor method to get the maximum damage that the vehicle can take.
     *
     * @return                   Maximum damage that the vehicle can take as an integer.
     */
    public int getMaxDamage() {
        return maxDamage;
    }

    /**
     * Accessor method to get the maximum fuel of the vehicle.
     *
     * @return                   Maximum fuel of the vehicle as an integer.
     */
    public int getMaxFuel() {
        return maxFuel;
    }

    /**
     * Input method which returns an integer relating the user selection of vehicles.
     *
     * @param fileLength         Length of file as an integer.
     * @return                   User selection as an integer.
     */
    public static int getMenuOption(int fileLength) {
        Input input = new Input();
        Validation valid = new Validation();
        boolean flag = true;
        int selection = 0;
        do {
            try {
                selection = input.acceptIntegerInput("Select vehicle:");
                if (valid.isBlank(selection)) {
                    System.out.println("Selection cannot be blank");
                }
                else if ((selection <= 0) || (selection > fileLength)) {
                    System.out.println("Please select an integer between 1 and " + fileLength);
                }
                else {
                    flag = false;
                }
            }
            catch (Exception e) {
                System.out.println("Please enter an integer: ");
            }
        } while (flag);
        return selection;
    }

    /**
     * Accessor method to get the length of the highway.
     *
     * @return                   Length of the highway as an integer.
     */
    public String getType() {
        return type;
    }

    /**
     * Read file method to read the contents of the vehicles.txt file for the user to select.
     *
     * @param filename           Filename to read as a String.
     */
    public static void readFile(String filename)
    {
        try (Scanner scanner = new Scanner(new FileReader(filename)))
        {
            int index = 1;
            while (scanner.hasNext())
            {
                String[] line = scanner.nextLine().split(",");
                String type = line[0];
                int boostSpeed = Integer.valueOf(line[1]);
                int maxFuel = Integer.valueOf(line[2]);
                int maxDamage = Integer.valueOf(line[3]);
                System.out.println("Select " + index + ": " + type);
                index++;
            }
        }
        catch (Exception e)
        {
            System.out.println("Error reading in file");
        }
    }

    /**
     * Read file method to find the length of the vehicles.txt file.
     *
     * @param filename           Filename to read as a String.
     * @return                   Length of file as an integer.
     */
    public int readFileLength(String filename)
    {
        int index = 0;
        try (Scanner scanner = new Scanner(new FileReader(filename)))
        {
            while (scanner.hasNext())
            {
                String[] line = scanner.nextLine().split(",");
                index++;
            }
            return index;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return index;
        }
    }

    /**
     * Selection method allows the user to select a vehicle from the vehicles.txt.
     *
     * @param filename           Filename to read as a String.
     */
    public void selectVehicle(String filename)
    {
        readFile(filename);
        int fileLength = readFileLength(filename);
        int option = getMenuOption(fileLength);
        try (Scanner scanner = new Scanner(new FileReader(filename)))
        {
            int index = 1;
            while (scanner.hasNext())
            {
                String[] line = scanner.nextLine().split(",");
                if (index == option)
                {
                    this.type = line[0];
                    this.boostSpeed = Integer.valueOf(line[1]);
                    this.maxFuel = Integer.valueOf(line[2]);
                    this.maxDamage = Integer.valueOf(line[3]);
                    break;
                }
                index++;
            }
        }
        catch (Exception e)
        {
            System.out.println("Error reading in file");
        }
    }

    /**
     * Mutator method to set the boost speed of the player's vehicle.
     *
     * @param boostSpeed               Boost speed of player's vehicle as an integer.
     */
    public void setBoostSpeed(int boostSpeed) {
        this.boostSpeed = boostSpeed;
    }

    /**
     * Mutator method to set the maximum damage the player's vehicle can take.
     *
     * @param maxDamage               Maximum damage the player's vehicle can take as an integer.
     */
    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    /**
     * Mutator method to set the maximum fuel of the player's vehicle.
     *
     * @param maxFuel                Maximum fuel player's vehicle as a double.
     */
    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }

    /**
     * Mutator method to set the type of the player's vehicle.
     *
     * @param type                   Type of player's vehicle as a String.
     */
    public void setType(String type) {
        this.type = type;
    }
}
