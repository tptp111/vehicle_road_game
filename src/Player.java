/**
 * Class which contains the player information.
 *
 */
public class Player {

    private String name;

    /**
     * Default constructor which creates object of the class Player.
     *
     */
    public Player() {
        name = "unknown";
    }

    /**
     * Non-default constructor which creates object of the class Player.
     *
     * @param name  String which contains player name.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Display method which returns the String of the state of the fields in the Player object.
     *
     * @return      The state of the Player object as a string.
     */
    public String display () {
        return "Name: " + name;
    }

    /**
     * Accessor method to get the player's name.
     *
     * @return  Name of the player as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator method to set the name of the Player class.
     *
     * @param name  Name of the player as a String.
     */
    public void setName(String name) {
        this.name = name;
    }

   /**
    * Input method to ask the user to input the player's name.
    *
    */
    public void inputPlayerName() {
        Input input = new Input();
        Validation valid = new Validation();

        String name = " ";
        do {
            name = input.acceptStringInput("Please enter player name" );
            if (valid.isBlank(name)) {
                System.out.println("Name cannot be blank!");
            }
            else if (!valid.lengthWithinRange(name, 3, 12)){
                System.out.println("Name must be between 3 and 12 character in length.");
            }
            else {
                this.name = name;
            }
        } while ((valid.isBlank(name)) || (!valid.lengthWithinRange(name, 3, 12)));

    }
}

