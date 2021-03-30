import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program will return the square root of a number to within a certain
 * range.
 *
 * @author robert spech.111
 *
 */
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     *
     * @param x
     *            x will be the given number by the user
     * @return the sqrt will be returned
     */
    private static double sqrt(double x) {
        double original = x;
        double guess = x;
        //guess will be the variable that changes;
        final double range = 0.0001;
        final double half = 0.50;
        // range represents the epsilon value or error value
        // half is the constant used to calculate the guess
        boolean finished = false;
        while (!finished && x != 0) {
            //ensures division by 0 doesn't happen if 0 is the input
            guess = (half) * (original / guess + guess);
            double error = Math.abs((guess * guess - original)) / original;
            //this is able to calculate the error

            if (error < range) {
                finished = true;
                //when the project is finished it will no longer loop
            }
        }

        return guess;
    }

    /**
     * Main method.
     *
     * The main method will house the basic components of the program it will
     * ask for user input and then send to the method to calculate the sqrt
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        //Creates the reader and writer
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.print("Would you like to calculate a square root? ");
        String check = in.nextLine();
        // sets the check variable to the users input, y or anything else
        while (check.equals("y")) {
            out.print("Enter a value to find the square root of: ");
            double square = in.nextDouble();
            // once a square root is requested, the program will ask for a value
            double root = sqrt(square);
            out.println("Your square root is " + root);
            out.print("Would you like to calculate another square root? ");
            check = in.nextLine();
            // rechecks whether or not the user wants to do another one.
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
