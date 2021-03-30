import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author robert spech.111
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        int solved = 0;
        int right = 0;
        int left = 0;
        String operator = "";
        // creates all the variables needed to solve this problem

        if (exp.numberOfChildren() > 0 && exp.child(0).hasAttribute("value")) {
            // if its down to the number, this branch is entered to get the left value
            String leftString = exp.child(0).attributeValue("value");
            left = Integer.parseInt(leftString);
        } else if (exp.numberOfChildren() > 0 && exp.child(0).isTag()) {
            // if not, this is entered to find the left value
            left = evaluate(exp.child(0));
        }
        if (exp.numberOfChildren() > 0 && exp.child(1).hasAttribute("value")) {
            // if the right value can be found this branch is entered
            String rightString = exp.child(1).attributeValue("value");
            right = Integer.parseInt(rightString);
        } else if (exp.numberOfChildren() > 0 && exp.child(1).isTag()) {
            // if the right value cannot be found, this branch is entered
            right = evaluate(exp.child(1));
        }

        operator = exp.label();
        // this gets the operator

        //these determine what to do with the two sides of the expression
        if (operator.equals("plus")) {
            solved = right + left;
        } else if (operator.equals("minus")) {
            solved = left - right;
        } else if (operator.equals("times")) {
            solved = left * right;
        } else if (operator.equals("divide")) {
            if (right == 0) {
                // the program will crash if it tries to divide by 0
                String error = "Can't divide by 0";
                Reporter.fatalErrorToConsole(error);
            }
            solved = left / right;
        }

        return solved;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
