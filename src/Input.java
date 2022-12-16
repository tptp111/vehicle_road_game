import java.util.Scanner;

/**
 * Utility class which allows the user to input to the console.
 */
public class Input {

    /**
     * Default constructor which creates object of the class Game.
     */
    public Input() {

    }

    /**
     * Input method which allows the user to input a char.
     *
     * @param displayMessage             Message to display to the user when asking for input.
     * @param position                   Index of the char in the user input String.
     * @return                           User input as a char.
     */
    public char acceptCharInput (String displayMessage, int position) {
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        String input = console.nextLine();
        return input.charAt(position);
    }

    /**
     * Input method which allows the user to input a double.
     *
     * @param displayMessage             Message to display to the user when asking for input.
     * @return                           User input as a double.
     */
    public double acceptDoubleInput(String displayMessage) {
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        double input = console.nextDouble();
        console.nextLine();
        return input;
    }

    /**
     * Input method which allows the user to input an integer.
     *
     * @param displayMessage             Message to display to the user when asking for input.
     * @return                           User input as an integer.
     */
    public int acceptIntegerInput(String displayMessage) {
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        int input = console.nextInt();
        console.nextLine();
        return input;
    }

    /**
     * Input method which allows the user to input a String.
     * Removes leading and ending whitespace in user input String.
     *
     * @param displayMessage             Message to display to the user when asking for input.
     * @return                           User input as a String.
     */
    public String acceptStringInput(String displayMessage)
    {
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        String input = console.nextLine().trim();
        return input;
    }
}







