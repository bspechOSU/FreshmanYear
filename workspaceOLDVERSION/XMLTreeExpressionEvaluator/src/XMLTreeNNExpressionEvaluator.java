import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
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
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
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
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        NaturalNumber solved = new NaturalNumber2();
        NaturalNumber right = new NaturalNumber2();
        NaturalNumber left = new NaturalNumber2();
        String operator = "";
        //Creates the variables necessary to store values from the Tree

        if (exp.numberOfChildren() > 0 && exp.child(0).hasAttribute("value")) {
            // we need to solve the left route
            String leftString = exp.child(0).attributeValue("value");
            left.setFromString(leftString);
        } else if (exp.numberOfChildren() > 0 && exp.child(0).isTag()) {
            // continues recursion down the line
            left = evaluate(exp.child(0));
        }
        if (exp.numberOfChildren() > 0 && exp.child(1).hasAttribute("value")) {
            // then we need to solve right route
            String rightString = exp.child(1).attributeValue("value");
            right.setFromString(rightString);
        } else if (exp.numberOfChildren() > 0 && exp.child(1).isTag()) {
            // continues recursion down the right side
            right = evaluate(exp.child(1));
        }

        operator = exp.label();
        // gets the label needed

        if (operator.equals("plus")) {
            // if the operator is plus, nothing needs to be checked
            left.add(right);
            String solvedString = left.toString();
            solved.setFromString(solvedString);
        } else if (operator.equals("minus")) {
            // if the operator is minus, the right side can't be more than the right
            if (right.compareTo(left) > 0) {
                String error = "Can't Subtract larger from Smaller";
                Reporter.fatalErrorToConsole(error);
            }
            left.subtract(right);
            String solvedString = left.toString();
            solved.setFromString(solvedString);
        } else if (operator.equals("times")) {
            // nothing needs to be tested for multiplication
            left.multiply(right);
            String solvedString = left.toString();
            solved.setFromString(solvedString);
        } else if (operator.equals("divide")) {
            // if dividing, the right side can't be 0
            NaturalNumber zero = new NaturalNumber2(0);

            if (right.compareTo(zero) == 0) {
                String error = "Can't divide by 0";
                Reporter.fatalErrorToConsole(error);
            }

            NaturalNumber x = left.divide(right);
            // there needs to be a variable to hold the remainder from the division
            String solvedString = left.toString();
            solved.setFromString(solvedString);
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
