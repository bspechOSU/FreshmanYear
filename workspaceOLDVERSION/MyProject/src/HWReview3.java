import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class HWReview3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HWReview3() {
    }

    private static NaturalNumber productOfDigits1(NaturalNumber n) {
        NaturalNumber ret = new NaturalNumber2(1);
        NaturalNumber zero = new NaturalNumber2(0);
        if (n.compareTo(zero) == 0) {
            ret.setFromInt(1);
        } else {
            int hold = n.divideBy10();
            ret.setFromInt(hold);
            ret.multiply(productOfDigits1(n));

        }
        return ret;
    }

    private static int toInt(NaturalNumber n) {
        String hold = n.toString();
        int x = Integer.parseInt(hold);
        return x;
    }

    private static boolean findTag(XMLTree xml, String tag) {
        boolean present = false;
        if (xml.isTag()) {
            for (int i = 0; i < xml.numberOfChildren(); i++) {
                if (!present) {
                    present = findTag(xml.child(i), tag);
                }
            }
        }
        return present;
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
        /*
         * Put your main program code here
         */
        /*
         * out.print("Enter a number: "); String inp = in.nextLine();
         * NaturalNumber input = new NaturalNumber2(inp); NaturalNumber product
         * = productOfDigits1(input); String x = product.toString();
         * out.println(x);
         */

        NaturalNumber[] array = new NaturalNumber[5];
        NaturalNumber count = new NaturalNumber2(1);
        for (int i = 0; i < array.length; i++) {
            array[i] = count;
            count.increment();
        }

        out.print(array[0].toString());
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
