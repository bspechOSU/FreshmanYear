
/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class ProgramSkeleton {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramSkeleton() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        // output.print("Number of points: ");
        //int n = input.nextInteger();

        // int ptsInInterval = 0, ptsInSubinterval = 0;

        // Random rnd = new Random1L();

        /**
         * double pi = 0; double count = 0; double holder = 0; int four = 4;
         * double oneSwitch = 1;
         *
         * while (count <= n) { holder = holder + (oneSwitch) / (2 * count + 1);
         * count++; if (oneSwitch == 1) { oneSwitch = -1; } else { oneSwitch =
         * 1; }
         *
         * }
         *
         * holder = four * holder; pi = holder; output.print(pi);
         */

        NaturalNumber s = new NaturalNumber2(9);
        NaturalNumber q = new NaturalNumber2(s);
        NaturalNumber m = new NaturalNumber2();
        NaturalNumber x = s.newInstance();
        m.copyFrom(s);
        x.increment();

        s.increment();
        output.println(s);
        output.println(q);
        output.println(m);
        output.println(x);

        input.close();
        output.close();

    }

}
