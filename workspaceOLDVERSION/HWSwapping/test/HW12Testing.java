import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

public final class HW12Testing {

    /**
     * Input 0.
     *
     * Used because this is the most basic natural number input
     *
     * Expected result could be a string with value of 0
     */
    @Test
    public void toStringWithCommas1() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber fin = new NaturalNumber2();
        fin.copyFrom(n);
        String nn = "0";
        String check = toStringWithCommas(n);

        assertEquals(nn, check);
        assertEquals(n, fin);

    }

    /**
     * Input is 11. This is a test with a natural number greater than 10
     * Expected result is "11"
     */
    @Test
    public void toStringWithCommas2() {
        NaturalNumber n = new NaturalNumber2(11);
        NaturalNumber fin = new NaturalNumber2();
        fin.copyFrom(n);
        String nn = "11";
        String check = toStringWithCommas(n);

        assertEquals(nn, check);
        assertEquals(n, fin);
    }

    /**
     * Input is 1234. This is a test with a common input that should have a
     * comma
     *
     * Expected return is "1,234"
     *
     */
    @Test
    public void toStringWithCommas3() {
        NaturalNumber n = new NaturalNumber2(1234);
        NaturalNumber fin = new NaturalNumber2();
        fin.copyFrom(n);
        String nn = "1,234";
        String check = toStringWithCommas(n);

        assertEquals(nn, check);
        assertEquals(n, fin);
    }

    /**
     * Input is 6543210. This is a test with a natural number that should have
     * multiple commas Expected result is "6,543,210"
     */
    @Test
    public void toStringWithCommas4() {
        NaturalNumber n = new NaturalNumber2(6543210);
        NaturalNumber fin = new NaturalNumber2();
        fin.copyFrom(n);
        String nn = "6,543,210";
        String check = toStringWithCommas(n);

        assertEquals(nn, check);
        assertEquals(n, fin);
    }

    /**
     * Input is 999. This is a test with a natural number that is just below
     * having a comma Expected result is "999"
     */

    @Test
    public void toStringWithCommas5() {
        NaturalNumber n = new NaturalNumber2(999);
        NaturalNumber fin = new NaturalNumber2();
        fin.copyFrom(n);
        String nn = "999";
        String check = toStringWithCommas(n);

        assertEquals(nn, check);
        assertEquals(n, fin);
    }

    /**
     * Input is Massive and full of 0 (1000000000). This is a test with a
     * natural number that could be tricky. Expected result is: "1,000,000,000"
     */

    @Test
    public void toStringWithCommas6() {
        NaturalNumber n = new NaturalNumber2(1000000000);
        NaturalNumber fin = new NaturalNumber2();
        fin.copyFrom(n);
        String nn = "1,000,000,000";
        String check = toStringWithCommas(n);

        assertEquals(nn, check);
        assertEquals(n, fin);
    }

    /**
     * Input is Massive and full of non 0 (1334576981). This is a test with a
     * natural number that could be tricky. Expected result is: "1,334,576,981"
     */

    @Test
    public void toStringWithCommas7() {
        NaturalNumber n = new NaturalNumber2(1334576981);
        NaturalNumber fin = new NaturalNumber2();
        fin.copyFrom(n);
        String nn = "1,334,576,981";
        String check = toStringWithCommas(n);

        assertEquals(nn, check);
        assertEquals(n, fin);
    }

    /**
     *
     */

    @Test
    public void toStringWithCommas8() {
        fail("Not yet implemented");
    }

    /**
     *
     */

    @Test
    public void toStringWithCommas9() {
        fail("Not yet implemented");
    }

    /**
     *
     */

    @Test
    public void toStringWithCommas10() {
        fail("Not yet implemented");
    }

}
