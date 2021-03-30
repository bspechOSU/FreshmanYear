import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author bobby spech
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("0", n.toString());
        assertEquals("0", m.toString());
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber m = new NaturalNumber2(21);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("3", n.toString());
        assertEquals("0", m.toString());
    }

    // outcome should be 10
    @Test
    public void testReduceToGCD_100_10() {
        NaturalNumber n = new NaturalNumber2(100);
        NaturalNumber m = new NaturalNumber2(10);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("10", n.toString());
        assertEquals("0", m.toString());
    }

    // outcome should be 7
    @Test
    public void testReduceToGCD_70_49() {
        NaturalNumber n = new NaturalNumber2(70);
        NaturalNumber m = new NaturalNumber2(49);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("7", n.toString());
        assertEquals("0", m.toString());
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("0", n.toString());
        assertTrue(result);
    }

    //multiple basic tests of Even function
    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("1", n.toString());
        assertTrue(!result);
    }

    @Test
    public void testIsEven_2() {
        NaturalNumber n = new NaturalNumber2(12342);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("12342", n.toString());
        assertTrue(result);
    }

    @Test
    public void testIsEven_3() {
        NaturalNumber n = new NaturalNumber2(12321);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("12321", n.toString());
        assertTrue(!result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("0", p.toString());
        assertEquals("2", m.toString());
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("18", p.toString());
        assertEquals("19", m.toString());
    }

    // my own power mod test should return 1
    @Test
    public void testPowerMod_5_5_4() {
        NaturalNumber n = new NaturalNumber2(5);
        NaturalNumber p = new NaturalNumber2(5);
        NaturalNumber m = new NaturalNumber2(4);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("5", p.toString());
        assertEquals("4", m.toString());
    }

    // composite tests
    @Test
    public void testComposite_1() {
        NaturalNumber w = new NaturalNumber2(880);
        NaturalNumber n = new NaturalNumber2(900);
        boolean testC1 = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals("880", w.toString());
        assertEquals("900", n.toString());
        assertTrue(testC1);
    }

    @Test
    public void testComposite_2() {
        NaturalNumber w = new NaturalNumber2(5);
        NaturalNumber n = new NaturalNumber2(9);
        boolean testC1 = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals("5", w.toString());
        assertEquals("9", n.toString());
        assertTrue(testC1);
    }

    @Test
    public void testComposite_3() {
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber n = new NaturalNumber2(4);
        boolean testC1 = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals("2", w.toString());
        assertEquals("4", n.toString());
        assertTrue(testC1);
    }

    // prime 2 tests
    @Test
    public void testPrime2_1() {
        NaturalNumber n = new NaturalNumber2(97);
        boolean prime = CryptoUtilities.isPrime2(n);

        assertEquals("97", n.toString());
        assertTrue(prime);
    }

    @Test
    public void testPrime2_2() {
        NaturalNumber n = new NaturalNumber2(887);
        boolean prime = CryptoUtilities.isPrime2(n);

        assertEquals("887", n.toString());
        assertTrue(prime);
    }

    @Test
    public void testPrime2_3() {
        NaturalNumber n = new NaturalNumber2(71);
        boolean prime = CryptoUtilities.isPrime2(n);

        assertEquals("71", n.toString());
        assertTrue(prime);
    }

    @Test
    public void testPrime2_4() {
        NaturalNumber n = new NaturalNumber2(124);
        boolean prime = CryptoUtilities.isPrime2(n);

        assertEquals("124", n.toString());
        assertTrue(!prime);
    }

    @Test
    public void testPrime2_5() {
        NaturalNumber n = new NaturalNumber2(3);
        boolean prime = CryptoUtilities.isPrime2(n);

        assertEquals("3", n.toString());
        assertTrue(prime);
    }

    @Test
    public void testPrime2_6() {
        NaturalNumber n = new NaturalNumber2(9);
        boolean prime = CryptoUtilities.isPrime2(n);

        assertEquals("9", n.toString());
        assertTrue(!prime);
    }

    @Test
    public void testPrime2_7() {
        NaturalNumber n = new NaturalNumber2(27);
        boolean prime = CryptoUtilities.isPrime2(n);

        assertEquals("27", n.toString());
        assertTrue(!prime);
    }

    @Test
    public void testPrime2_8() {
        NaturalNumber n = new NaturalNumber2(2);
        boolean prime = CryptoUtilities.isPrime2(n);

        assertEquals("2", n.toString());
        assertTrue(prime);
    }

    @Test
    public void testPrime2_9() {
        NaturalNumber n = new NaturalNumber2(4);
        boolean prime = CryptoUtilities.isPrime2(n);

        assertEquals("4", n.toString());
        assertTrue(!prime);
    }

}