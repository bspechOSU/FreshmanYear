import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Swapping {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Swapping() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void swapNN(NaturalNumber n1, NaturalNumber n2) {
        NaturalNumber temp = new NaturalNumber2();
        temp.transferFrom(n1);
        n1.transferFrom(n2);
        n2.transferFrom(temp);
        /*
         * Put your code for myMethod here
         */
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
        NaturalNumber n1 = new NaturalNumber2(36);
        NaturalNumber n2 = new NaturalNumber2(77);
        out.println(n1);
        out.println(n2);
        swapNN(n1, n2);
        /*
         * Close input and output streams
         */
        out.println(n1);
        out.println(n2);
        in.close();
        out.close();
    }

}
