import components.set.Set;
import components.set.Set1L;
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
public final class ProgramWithIOAndStaticMethod {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramWithIOAndStaticMethod() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        String ret = "";
        boolean switcher = true;
        boolean sep = false;
        if (separators.contains(text.charAt(position))) {
            sep = true;
        }
        ret = ret + text.charAt(position);
        position++;
        while (switcher && position < text.length()) {
            char check = text.charAt(position);
            if (sep && separators.contains(check)) {
                ret = ret + check;
            } else if (!sep && !separators.contains(check)) {
                ret = ret + check;
            } else {
                switcher = false;
            }
            position++;
        }

        return ret;
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
        String check = "Helloboys, my name is sponge";
        Set<Character> chars = new Set1L<>();
        chars.add(',');
        chars.add(' ');
        chars.add('\n');
        String x = nextWordOrSeparator(check, 8, chars);
        out.println(x);
        /*
         * Close input and output streams
         */
        String[] y = new String[5];
        y[0] = "hello";
        y[1] = "boy";
        y[2] = "girl";
        y[3] = "yeet";
        y[4] = "homie";
        for (int i = 0; i < y.length; i++) {
            for (int j = i + 1; j < y.length; j++) {
                int q = y[i].compareTo(y[j]);
                if (q > 0) {
                    String hold = y[i];
                    String holdTwo = y[j];
                    y[i] = holdTwo;
                    y[j] = hold;
                }
            }
        }
        out.println(y[0]);
        out.println(y[1]);
        out.println(y[2]);
        out.println(y[3]);
        out.println(y[4]);

        String yy = "appple";
        String zz = "zapple";
        int tt = zz.compareTo(yy);
        out.println(tt);

        out.print("adsf");
        out.println("asdf");
        out.print("hi");
        out.print("Enter something: ");
        if (in.nextLine().length() > 0) {
            out.println("hi");
        }
        String nn = in.nextLine();
        out.println(nn);

        in.close();
        out.close();
    }

}
