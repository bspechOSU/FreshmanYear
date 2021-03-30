import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.set.Set1L;

public class GlossaryProjectTest {

    // tests the basic version or common problem
    @Test
    public void createMap1() {
        Map<String, String> map = new Map1L<>();
        GlossaryProject.getDefMap("projTen.txt", map);
        assertEquals(map.size(), 7);
    }

    // tests a file with only 1 term or difficult problem
    @Test
    public void createMap2() {
        Map<String, String> map = new Map1L<>();
        GlossaryProject.getDefMap("tougher.txt", map);
        assertEquals(map.size(), 1);
    }

    // tests the ability of the sorting method or common problem
    @Test
    public void alphabet1() {
        Map<String, String> map = new Map1L<>();
        map.add("yes", "no");
        map.add("no", "yes");
        map.add("boy", "girl");
        String[] x = GlossaryProject.alphabeticalOrder(map);
        assertEquals(x[0], "boy");
    }

    //tests ability of the sorting method with a tougher case
    @Test
    public void alphabet2() {
        Map<String, String> map = new Map1L<>();
        map.add("yes", "no");
        map.add("no", "yes");
        map.add("boy", "girl");
        map.add("banana", "fruit");
        String[] x = GlossaryProject.alphabeticalOrder(map);
        assertEquals(x[0], "banana");
    }

    // tests the next word or separator method viability
    @Test
    public void nextWordSep1() {
        final String separatorStr = "\t, ?!;.";
        // separators
        Set<Character> separatorSet = new Set1L<>();
        GlossaryProject.generateElements(separatorStr, separatorSet);
        String test = "GoBuckeyes!! Beat Michigan";
        String x = GlossaryProject.nextWordOrSeparator(test, 0, separatorSet);
        String y = GlossaryProject.nextWordOrSeparator(test, 10, separatorSet);
        assertEquals(x, "GoBuckeyes");
        assertEquals(y, "!! ");
    }

    // difficult case for next word or separator
    @Test
    public void nextWordSep2() {
        final String separatorStr = "\t, ?!;.";
        // separators
        Set<Character> separatorSet = new Set1L<>();
        GlossaryProject.generateElements(separatorStr, separatorSet);
        String test = ".............................";
        String x = GlossaryProject.nextWordOrSeparator(test, 0, separatorSet);
        assertEquals(x, ".............................");

    }

    // another difficult test case
    @Test
    public void nextWordSep3() {
        final String separatorStr = "\t, ?!;.";
        // separators
        Set<Character> separatorSet = new Set1L<>();
        GlossaryProject.generateElements(separatorStr, separatorSet);
        String test = "Something!!!Difficult";
        String x = GlossaryProject.nextWordOrSeparator(test, 0, separatorSet);
        String y = GlossaryProject.nextWordOrSeparator(test, 9, separatorSet);
        assertEquals(x, "Something");
        assertEquals(y, "!!!");

    }

    // common test for generate elements
    @Test
    public void generateEl1() {
        String a = "rainbows";
        Set<Character> rainbow = new Set1L<>();
        GlossaryProject.generateElements(a, rainbow);
        assertEquals(rainbow.size(), 8);
    }

    // difficult test for generate elements
    @Test
    public void generateEl2() {
        String a = "aaeeiioouuhello";
        Set<Character> random = new Set1L<>();
        random.add('x');
        GlossaryProject.generateElements(a, random);
        assertEquals(random.size(), 7);
    }

}
