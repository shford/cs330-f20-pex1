/**
* <p>VectorCalculator class provides a command line vector calculator</p>
* @version 1.0
* @author C2C Hampton Ford
* Documentation:
* Looked up what vectors are at https://byjus.com/maths/types-of-vectors/
* Testing and building regex exprs from https://www.freeformatter.com/java-regex-tester.html#ad-output
*
*/

//Schedule EI for javadocs PEX0 request && hasNext() check
import java.util.Scanner;
import java.lang.Math;
import java.util.*;

public class VectorCalculator {
    double x;
    double y;

    /**
    * @param void
    * @return void
    */
    public VectorCalculator () {
        this.x = 0;
        this.y = 0;
    }

    //other methods
    /**
    * main() - reads and processes input vector expressions until 'exit' is input
    * @param String[] args
    * @return void
    */
    public static void main(String[] args) {
        String vector = new String(); //initialize of course
        String finish = "exit";
        do {
        Scanner s = new Scanner();
        //get input


        } while(!vector.equalsIgnoreCase(finish));
    }

    /**
    * parseDirectionExpression - parses expression to calculate vector's direction
    * @param Scanner s
    * @return void
    */
    private static void parseDirectionExpression(Scanner s) {}

    /**
    * parseExpression() - parses vector expression provided by the Scanner s.
    * @param Scanner s
    * @return void
    */
    private static void parseExpression(Scanner s) {

    }

    /**
    * parseNormalizeExpression - parses expression to compute a normalized vector; that is, a vector with same direction as input but with magnitude of 1
    * @param Scanner s
    * @return void
    */
    private static void parseNormalizeExpression(Scanner s) {
        int magnitude = sqrt(x*x+y*y+z*z);
        x /= magnitude;
        y /= magnitude;
        z /= magnitude;
        return;
    }

    /**
    * parseNormExpression() - parses expression with a '|' indicating a vector norm
    * @param Scanner s
    * @return void
    */
    private static void parseNormExpression(Scanner s) {
    }

    /**
    * parseScaleExpression - parses expression with a scalar-vector multiplication
    * @param Scanner s
    * @return void
    */
    private static void parseScaleExpression(Scanner s) {
    }

    /**
    * parseVectorExpression() - The input must be of the form, “< 5.1, 3.2 >” where there are spaces after “<” and “,” as well as before “>”
    * @param Scanner s
    * @return void
    */
    private static void parseVectorExpression(Scanner s) {
        if (s.substr(0,1).equals("< ")) {
            int currInd = 2; //begin tracking index

            if (Double.parseDouble(s.next.substr(2, )) {
                if (", ") {
                    if (Double.parseDouble()) {
                        if (" >") {

                        }
                    }
                }
            }
        }
    }

    private static void validateExpr(String expr) {
        final String regex = "< -?[0-9]*.{0,1}[0-9]*, -?[0-9]*.{0,1}[0-9]* >"; //checks that str is in format < -71.4232, 19012.90121 >
        //Pattern .matches()
    }
}