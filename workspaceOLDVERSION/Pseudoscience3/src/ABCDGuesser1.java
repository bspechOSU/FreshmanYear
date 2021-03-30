import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * This program will return the exponents needed for four constants multiplied
 * together to equal another constant.
 *
 * @author robert spech.111
 *
 */
public final class ABCDGuesser1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser1() {
    }

    /**
     *
     * This method will return a positive double that could be equal to 1.
     *
     * @param in
     *            input stream
     * @param out
     *            output stream
     * @return double holder
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        boolean isPositiveDouble = false;
        double holder = 0;
        while (!isPositiveDouble) {
            // the loop continues until the condition is true at which poin
            // the loop will exit and the double will be returned
            out.print("Enter a positive double: ");
            String input = in.nextLine();
            if (FormatChecker.canParseDouble(input)) {
                // ensures there will not be an error when parsing the double
                holder = Double.parseDouble(input);
                if (holder > 0) {
                    // if the inputted double is greater than 0, the condition is met
                    isPositiveDouble = true;
                } else {
                    out.println("It must be positive");
                }
            } else {
                out.println("You must input a double");
            }
        }
        return holder;
    }

    /**
     *
     * This method will return a positive double not equal to 1.
     *
     * @param in
     *            input stream
     * @param out
     *            output stream
     * @return double holder, positive double not equal to 1
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        boolean isPositiveDouble = false;
        double holder = 0;
        while (!isPositiveDouble) {
            // this loop will continue until the condition is met
            // at which point the method will return the inputted valid double
            out.print("Enter a positive double not one: ");
            String input = in.nextLine();
            if (FormatChecker.canParseDouble(input)) {
                // ensures there will not be an error when parsing the double
                holder = Double.parseDouble(input);
                if (holder > 1) {
                    isPositiveDouble = true;
                    // if the inputted double is greater than one, the condition is met
                } else {
                    out.println("You must be positive and greater than 1");
                }
            } else {
                out.println("You must input a double");
            }
        }
        return holder;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        final double hundreths = 0.01;
        final double baseError = 100;
        double error = 0;
        double errorHolder = baseError;
        double mew = getPositiveDouble(in, out);
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);
        // these are the inputted values acquired by the functions

        final double[] numberSet = { -5, -4, -3, -2, -1, -1 / 2, -1 / 3, -1 / 4,
                0, 1 / 4, 1 / 3, 1 / 2, 1, 2, 3, 4, 5 };
        // this the array of exponent possibilities
        int counta = 0;
        int countb = 0;
        int countc = 0;
        int countd = 0;
        // these keep track of the individual counts for each while loop
        double a = numberSet[0];
        double b = numberSet[0];
        double c = numberSet[0];
        double d = numberSet[0];
        // these are the initial starting points of the variable
        double afinal = 0;
        double bfinal = 0;
        double cfinal = 0;
        double dfinal = 0;
        // these will hold the best values of each exponent
        while (counta < numberSet.length - 1) {
            // this loop will continue until a has been every possible exponent
            a = numberSet[counta];
            // sets a to an exponent
            while (countb < numberSet.length - 1) {
                // this loop will continue until b has been every possible exponent
                b = numberSet[countb];
                while (countc < numberSet.length - 1) {
                    // this loop will continue until c has been every possible exponent
                    c = numberSet[countc];
                    while (countd < numberSet.length - 1) {
                        //this loop will continue until d has been every  exponent
                        d = numberSet[countd];
                        error = ((Math.abs(((Math.pow(w, a) * Math.pow(x, b)
                                * Math.pow(y, c) * Math.pow(z, d)) - mew)))
                                / mew);
                        // finds the error
                        if (error < errorHolder) {
                            // if the error calculated is less than the initial error
                            // the holder gets replaced and so do the initial exponents
                            errorHolder = error;
                            afinal = a;
                            bfinal = b;
                            cfinal = c;
                            dfinal = d;
                        }
                        countd++;
                    }
                    countd = 0;
                    // sets d count to 0
                    countc++;
                }
                countc = 0;
                // sets c count to 0
                countb++;
            }
            counta++;
            countb = 0;
            countc = 0;
            countd = 0;
            // sets all counts back to 0
        }

        out.println("The exponents are " + afinal + " " + bfinal + " " + cfinal
                + " " + dfinal);
        out.println("The error was " + errorHolder);
        if (error > hundreths) {
            // if the error is greater than 0.01, then the theory is disproven
            out.println(
                    "Since the error was above 0.01, the theory was disproven");
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
