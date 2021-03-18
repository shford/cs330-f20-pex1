/**
 * <h1>Vector Calculator</h1>
 * This program implements an application that simply adds two given integer numbers and Prints the output on the screen.
 * <p>
 * <b>This program implements an application that simply adds two given integer numbers and Prints the output on the screen.</b>
 *
 * @author  C2C Hampton Ford
 * @version 1.0
 */
package src;

import java.util.Scanner;
import java.util.regex.Pattern;

public class VectorCalculator {
    /**
     * main() - reads and processes input vector expressions until 'exit' is input
     * @param args String[]
     * @throws Exception Throw error on bad input
     */
    public static void main(java.lang.String[] args) throws Exception {
        System.out.println("Welcome to the Vector Calculator!");
        //NOTE: hasNext(Pattern String) and hasNext(Pattern pattern) don't
        //work with advanced regex expressions
        //I alternatively validated input with Pattern.matches()
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter vector expression: ");
            parseExpression(s);
        }
    }

    /**
     * parseExpression() - parses vector expression provided by the Scanner s.
     *
     * @param s - Scanner from which input expressions are taken
     * @throws java.lang.Exception - - passes all exceptions to the calling routine
     */
    private static void parseExpression(java.util.Scanner s) throws Exception {
        try {
            String STR = s.nextLine();
            //cascading if statement based on regex expressions
            if (Pattern.matches("dir < -?[0-9]*.?[0-9]*, -?[0-9]*.?[0-9]* >", STR)) { //validate input
                Scanner nextScanner = new Scanner(STR);
                parseDirectionExpression(nextScanner);
            } else if (Pattern.matches("unit < -?[0-9]*.?[0-9]*, -?[0-9]*.?[0-9]* >", STR)) { //validate input
                Scanner nextScanner = new Scanner(STR);
                parseNormalizeExpression(nextScanner);
            } else if (Pattern.matches("\\| < -?[0-9]*.?[0-9]*, -?[0-9]*.?[0-9]* > \\|", STR)) { //validate input
                Scanner nextScanner = new Scanner(STR);
                parseNormExpression(nextScanner);
            } else if (Pattern.matches("-?[0-9]*.?[0-9]* \\* < -?[0-9]*.?[0-9]*, -?[0-9]*.?[0-9]* >", STR)) { //validate input
                Scanner nextScanner = new Scanner(STR);
                parseScaleExpression(nextScanner);
            }
            //test for vector [+-*/.] vector
            else if (Pattern.matches("< -?[0-9]*.?[0-9]*, -?[0-9]*.?[0-9]* > \\+ < -?[0-9]*.?[0-9]*, -?[0-9]*.?[0-9]* >", STR)
                    || Pattern.matches("< -?[0-9]*.?[0-9]*, -?[0-9]*.?[0-9]* > - < -?[0-9]*.?[0-9]*, -?[0-9]*.?[0-9]* >", STR)
                    || Pattern.matches("< -?[0-9]*.?[0-9]*, -?[0-9]*.?[0-9]* > . < -?[0-9]*.?[0-9]*, -?[0-9]*.?[0-9]* >", STR)) { //validate input
                Scanner nextScanner = new Scanner(STR);
                parseVectorExpression(nextScanner);
            } else if (Pattern.matches("exit", STR)) { //validate input
                System.out.println("\nThank you for using the Vector Calculator.");
                System.exit(0); //exit successfully
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * parseVectorExpression() - parses expression with a vector as next token. The operations are addition, subtraction, or dot product.
     *
     * @param s - Scanner from which input expressions are taken
     * @throws java.lang.Exception - - passes all exceptions to the calling routine
     */
    private static void parseVectorExpression(java.util.Scanner s) throws Exception {
        try {
            /*parse string*/
            //read string
            String validatedInput = s.nextLine();
            //split and reconcatenate into vectors 1 and 2 into strings
            String[] fields = validatedInput.split(" ");
            String operator = fields[4];
            String vector1Str = fields[0].concat(" ").concat(fields[1]).concat(" ").concat(fields[2]).concat(" ").concat(fields[3]);
            String vector2Str = fields[5].concat(" ").concat(fields[6]).concat(" ").concat(fields[7]).concat(" ").concat(fields[8]);
            //store strings in scanners
            Scanner parseVector1 = new Scanner(vector1Str);
            Scanner parseVector2 = new Scanner(vector2Str);
            //instantiate vectors into Vector333Class
            Vector333Class vector1 = Vector333Class.parseVector(parseVector1);
            Vector333Class vector2 = Vector333Class.parseVector(parseVector2);
            //run appropriate Vector333Class method
            Vector333Class resultVector = null;
            if (operator.equals("+")) {
                //instantiate 2nd Vector333Class from scanner
                resultVector = vector1.add(vector2);
                System.out.println("Result is " + resultVector.toString());
            } else if (operator.equals("-")) {
                //instantiate 2nd Vector333Class from scanner
                resultVector = vector1.subtract(vector2);
                System.out.println("Result is " + resultVector.toString());
            } else if (operator.equals(".")) {
                //instantiate 2nd Vector333Class from scanner
                double dotProduct = vector1.dotProduct(vector2);
                System.out.printf("Result is %f\n", dotProduct);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * parseDirectionExpression - parses expression to calculate vector's direction
     *
     * @param s - Scanner from which input expressions are taken
     * @throws java.lang.Exception - - passes all exceptions to the calling routine
     */
    private static void parseDirectionExpression(java.util.Scanner s) throws Exception {
        try {
            //parse string
            String validatedInput = s.nextLine();
            String selectVectorString = validatedInput.substring(4); //4 to end
            Scanner parseVector = new Scanner(selectVectorString);

            //instantiate Vector333Class from scanner
            Vector333Class vector = Vector333Class.parseVector(parseVector);

            //call Vector333Class direction() on vector object
            double radAngle = vector.direction();
            double degrees = Math.toDegrees(radAngle);

            //print result
            System.out.printf("Result is %f radians (%f degrees)\n", radAngle, degrees);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * parseNormalizeExpression - parses expression to compute a normalized vector; that is, a vector with same direction as input but with magnitude of 1.
     *
     * @param s - Scanner from which input expressions are taken
     * @throws java.lang.Exception - - passes all exceptions to the calling routine
     */
    private static void parseNormalizeExpression(java.util.Scanner s) throws Exception {
        try {
            //parse string
            String validatedInput = s.nextLine();
            String selectVectorString = validatedInput.substring(5); //5 to end
            Scanner parseVector = new Scanner(selectVectorString);

            //instantiate Vector333Class from scanner
            Vector333Class vector = Vector333Class.parseVector(parseVector);

            //call Vector333Class normalize() on vector object
            Vector333Class normalizedVector = vector.normalize();

            //print result
            System.out.println("Result is " + normalizedVector.toString());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * parseNormExpression() - parses expression with a '|' indicating a vector norm
     *
     * @param s - Scanner from which input expressions are taken
     * @throws java.lang.Exception - - passes all exceptions to the calling routine
     */
    private static void parseNormExpression(java.util.Scanner s) throws Exception {
        try {
            //parse string
            String validatedInput = s.nextLine();
            String selectVectorString = validatedInput.substring(2, validatedInput.length() - 2); //ignore bars and spaces
            Scanner parseVector = new Scanner(selectVectorString);

            //instantiate Vector333Class from scanner
            Vector333Class vector = Vector333Class.parseVector(parseVector);

            //call Vector333Class magnitude() on vector object
            double magnitude = vector.magnitude();

            //print result
            System.out.printf("Result is %f\n", magnitude);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * parseScaleExpression - parses expression with a scalar-vector multiplication
     *
     * @param s - Scanner from which input expressions are taken
     * @throws java.lang.Exception - - passes all exceptions to the calling routine
     */
    private static void parseScaleExpression(java.util.Scanner s) throws Exception {
        try {
            /*parse string*/
            //read string from scanner
            String validatedInput = s.nextLine(); //looks like "scalar * < x, y >"
            //split string
            String[] fields = validatedInput.split(" "); //something like ["scalar", "*", "<", "x,", "y", ">"]
            //select scalar string field
            String scalarStr = fields[0];
            double scalar = Double.parseDouble(scalarStr);
            //concatenate vector fields back together and store in scanner
            String concatVectorStr = fields[2].concat(" ").concat(fields[3]).concat(" ").concat(fields[4]).concat(" ").concat(fields[5]);
            //store string in scanner
            Scanner parseVector = new Scanner(concatVectorStr);

            //instantiate Vector333Class from scanner
            Vector333Class vector = Vector333Class.parseVector(parseVector);

            //call Vector333Class scale() on vector object
            Vector333Class scaledVector = vector.scale(scalar);

            //print result
            System.out.println("Result is " + scaledVector.toString());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}

// Test code for showing hasNext(Pattern.compile(FOO)) doesn't work
/*  String REGEX = "dir < -?[0-9]*.?[0-9]*, -?[0-9]*.?[0-9]* >";
    Scanner test = new Scanner(System.in);
    boolean hN = test.hasNext(Pattern.compile(REGEX));
    String STR = test.nextLine();
    boolean mat = Pattern.matches(REGEX, STR);
*/