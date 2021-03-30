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
public final class CountingNat {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CountingNat() {
    }

    /*
     * private static int getChildElement(XMLTree xml, String tag) { assert xml
     * != null : "Violation of: xml is not null"; assert tag != null :
     * "Violation of: tag is not null"; assert xml.isTag() :
     * "Violation of: the label root of xml is a tag";
     *
     * int location = -1; int count = 0; while (count < xml.numberOfChildren())
     * { // runs through each child if (xml.child(count).label().equals(tag)) {
     * location = count; } count++; } return location; // returns the location
     * of the child element if it is present
     *
     * }
     *
     */
    /*
     * private static int numberOfDigits(NaturalNumber n) { int count = 0; int
     * add = 0; int holder = n.divideBy10(); if (n.isZero()) { count++; } else {
     * count = 1 + numberOfDigits(n); } return count; }
     *
     * private static int sumOfDigits(NaturalNumber n) {
     *
     * int add = 0; int holder = n.divideBy10(); if (!n.isZero()) { add = holder
     * + sumOfDigits(n); } else { add += holder; } return add; }
     *
     * private static NaturalNumber sumOfDigits(NaturalNumber n) { NaturalNumber
     * adding = new NaturalNumber2(); int holder = n.divideBy10(); NaturalNumber
     * holdingNum = new NaturalNumber2(holder); if (!n.isZero()) {
     *
     * holdingNum.add(sumOfDigits(n)); adding.add(holdingNum); } else {
     * adding.add(holdingNum); }
     *
     * return adding; }
     */

    private static boolean isPalindrome(String s) {
        boolean pal = true;
        if (s.length() == 1) {
            pal = true;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                pal = true;
            } else {
                pal = false;
            }
        } else {
            String subS = s.substring(1, s.length() - 1);
            if (isPalindrome(subS) && s.charAt(0) == s.charAt(s.length() - 1)) {
                pal = true;
            } else {
                pal = false;
            }

        }
        return pal;
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
         * out.print("enter a weird rss: "); String input = in.nextLine();
         * XMLTree base = new XMLTree1(input); XMLTree channel = base.child(0);
         * XMLTree item = channel.child(9);
         *
         * String actDesc = ""; out.print(getChildElement(item, "description"));
         * actDesc = item.child(4).child(0).label(); out.print(actDesc);
         */
        //out.print("String ");
        // String inp = in.nextLine();
        //NaturalNumber x = new NaturalNumber2(inp);
        //int num = numberOfDigits(x);
        //out.println("You had " + num + " digits");

        //NaturalNumber sum = sumOfDigits(x);
        //String sumS = sum.toString();
        ///out.println("Sum: " + sumS);
        /*
         * boolean pal = isPalindrome(inp);
         *
         * if (pal) { out.println("YES PALINDROME");
         *
         * } else { out.println("NO PAL :("); } String x = "hello"; char c =
         * 'w'; x = x + c; out.println(x);
         */
        /*
         * Close input and output streams
         */
        String x = ("+" + ")-(" + "+") + "\"";
        out.println(x);

        double j = 1 / 2;
        out.println(j);

        in.close();
        out.close();
    }

}
