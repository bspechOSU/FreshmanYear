
import components.queue.Queue;
import components.queue.Queue1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class HelloWorld {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private HelloWorld() {
        // no code needed here
    }

    private static int min(Queue<Integer> q) {
        Integer minimum = q.front();
        for (int i = 0; i < q.length(); i++) {
            Integer checkMin = q.front();
            if (minimum > checkMin) {
                minimum = checkMin;
            }
            q.rotate(1);
        }
        return minimum;
    }

    /**
     * private static int[] minAndMax(Queue<Integer> q) { int[] returnArray =
     * new int[2]; returnArray[0] = q.front(); returnArray[1] = q.front(); for
     * (int i = 0; i < q.length(); i++) { Integer checkMin = q.front(); Integer
     * checkMax = q.front(); if (returnArray[0] > checkMin) { returnArray[0] =
     * checkMin; } if (returnArray[1] < checkMax) { returnArray[1] = checkMax; }
     *
     * q.rotate(1); } return returnArray;
     *
     * }
     */

    private static int[] minAndMax(Queue<Integer> q) {
        int[] returnArray = new int[2];
        returnArray[0] = q.front();
        returnArray[1] = q.front();
        for (int i = 0; i < q.length(); i++) {
            Integer checkOne = q.front();
            q.rotate(1);
            Integer checkTwo = q.front();
            Integer holder = 0;
            if (checkOne < checkTwo) {
                if (returnArray[1] < checkTwo) {
                    returnArray[1] = checkTwo;
                }
                if (returnArray[0] > checkOne) {
                    returnArray[0] = checkOne;
                }
            } else {
                if (returnArray[1] < checkOne) {
                    returnArray[1] = checkOne;
                }
                if (returnArray[0] > checkTwo) {
                    returnArray[0] = checkTwo;
                }
            }

        }
        return returnArray;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        out.println("Hello World!");
        Queue<Integer> qi = new Queue1L<>();
        qi.enqueue(1);
        qi.enqueue(6);
        qi.enqueue(0);
        qi.enqueue(-5);
        int j = min(qi);
        int[] a = minAndMax(qi);
        out.println(a[0] + " " + a[1]);
        //  out.println(j);
        out.close();
    }

}
