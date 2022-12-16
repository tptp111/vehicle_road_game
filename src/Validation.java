/**
 * Utility class which validates the user input.
 *
 */
public class Validation {

    /**
     * Default constructor which creates object of the class Validation.
     *
     */
    public Validation(){

    }

    /**
     * Validation method which checks if the user input String is empty.
     *
     * @param string                 User input as a String to validate.
     * @return                       boolean if string is valid.
     */
    public boolean isBlank(String string) {
        return (string.trim().length() == 0);
    }

    /**
     * Validation method which checks if the user input integer is empty.
     *
     * @param num                    User input as an integer to validate.
     * @return                       boolean if integer is valid.
     */
    public boolean isBlank(int num) {
        return (String.valueOf(num).trim().length() == 0);
    }

    /**
     * Validation method which checks if the user input String is within a certain length.
     *
     * @param string                 User input as a String to validate.
     * @param num1                   Minimum length of string allowed.
     * @param num2                   Maximum length of string allowed.
     * @return                       boolean if string is valid.
     */
    public boolean lengthWithinRange(String string, int num1, int num2)
    {
        return ((string.length() >= num1) && (string.length() <= num2));
    }
}



