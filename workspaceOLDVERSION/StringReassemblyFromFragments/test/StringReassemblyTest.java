import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * @author bobby spech. This is the test document for StringReassembly.
 */

public class StringReassemblyTest {

    @Test
    public void combination1() {
        String a = "enque";
        String b = "queue";
        String c = StringReassembly.combination(a, b, 3);
        assertEquals(c, "enqueue");
        // test the combination method
    }

    @Test
    public void combination2() {
        String a = "seven years ago~";
        String b = "four";
        String c = "four score and seven";
        String d = "ago~ our";
        String e = "our founding fath";
        String f = "fathers brought";
        int ov1 = StringReassembly.overlap(e, f);
        e = StringReassembly.combination(e, f, ov1);
        int ov2 = StringReassembly.overlap(a, d);
        a = StringReassembly.combination(a, d, ov2);
        assertEquals(e, "our founding fathers brought");
        assertEquals(a, "seven years ago~ our");
        // tests a few combinations

    }

    @Test
    public void addAvoid1() {
        Set<String> x = new Set1L<>();
        x.add("seven");
        x.add("hello");
        String y = "even";
        StringReassembly.addToSetAvoidingSubstrings(x, y);

        assertEquals(x.size(), 2);
        // has a sub string
    }

    @Test
    public void addAvoid2() {
        Set<String> x = new Set1L<>();
        x.add("seven");
        x.add("hello");
        x.add("green");
        String y = "blue";
        StringReassembly.addToSetAvoidingSubstrings(x, y);

        assertEquals(x.size(), 4);
        // does not have a sub string
    }

    @Test
    public void addAvoid3() {
        Set<String> x = new Set1L<>();
        x.add("even");
        x.add("hello");
        x.add("green");
        String y = "seven";
        StringReassembly.addToSetAvoidingSubstrings(x, y);

        assertEquals(x.size(), 3);
        // has a substring
    }

    @Test
    public void addAvoid4() {
        Set<String> x = new Set1L<>();
        x.add("b");
        x.add("nnot hallow this grou");
        x.add("t consecrate, we cannot hallow thi");
        String y = "ot consecrate, we cannot hallow this grou";

        StringReassembly.addToSetAvoidingSubstrings(x, y);

        assertEquals(x.size(), 2);
        // practice with longer parts
    }

    @Test
    public void inputTest1() {
        // tests whether or not input is being received
        Set<String> q = new Set1L<>();
        SimpleReader in = new SimpleReader1L("gettysburg-30-4.txt");
        SimpleWriter out = new SimpleWriter1L();
        q = StringReassembly.linesFromInput(in);
        int j = q.size();
        for (int i = j; i > 0; i--) {
            String t = q.removeAny();
            //out.println(t);
            // may print the values to see if there are any overlaps
        }
        in.close();
        out.close();
    }

}
