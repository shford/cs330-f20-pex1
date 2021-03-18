package src;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Vector333ClassTest {

    @org.junit.jupiter.api.Test
    void direction() {
        Vector333Class testVector = new Vector333Class(5893.839, -3892.3891);
        double answerAngle = 2.154459;
        assertEquals(testVector.direction(), answerAngle);
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Vector333Class answerVector = new Vector333Class(5893.839, -3892.3891);
        Vector333Class testVector = new Vector333Class(5893.839, -3892.3891);
        assertTrue(testVector.equals(answerVector));
    }

    @org.junit.jupiter.api.Test
    void add() {
        Vector333Class testVector1 = new Vector333Class(5893.839, -3892.3891);
        Vector333Class testVector2 = new Vector333Class(3882.383, 12893.219);
        double subX = 9776.222000;
        double subY = 9000.829900;
        assertEquals(testVector1.add(testVector2).getX(), subX);
        assertEquals(testVector1.add(testVector2).getY(), subY);
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        Vector333Class testVector1 = new Vector333Class(5893.839, -3892.3891);
        Vector333Class testVector2 = new Vector333Class(3882.383, 12893.219);
        double subX = 2011.456000;
        double subY = -16785.608100;
        assertEquals(testVector1.subtract(testVector2).getX(), subX);
        assertEquals(testVector1.subtract(testVector2).getY(), subY);
    }

    @org.junit.jupiter.api.Test
    void dotProduct() {
        Vector333Class testVector1 = new Vector333Class(5893.839, -3892.3891);
        Vector333Class testVector2 = new Vector333Class(3882.383, 12893.219);
        double dotProductAnswer = -27303284.761176;
        assertEquals(testVector1.dotProduct(testVector2), dotProductAnswer);
    }

    @org.junit.jupiter.api.Test
    void scale() {
        Vector333Class answerVector = new Vector333Class(-3.619122, 3.788017);
        Vector333Class testVector = new Vector333Class(0.690804, -0.723042);
        double testScalar = -5.239;
        assertEquals(testVector.scale(testScalar).getX(), answerVector.getX());
        assertEquals(testVector.scale(testScalar).getY(), answerVector.getY());
    }

    @org.junit.jupiter.api.Test
    void magnitude() {
        Vector333Class testVector = new Vector333Class(3892.42, -3.43932);
        assertEquals(testVector.magnitude(), 3892.421519);
    }

    @org.junit.jupiter.api.Test
    void normalize() {
        Vector333Class answerVector = new Vector333Class(0.690804, -0.723042);
        Vector333Class testVector = new Vector333Class(3, -0.723042);
        assertEquals(testVector.normalize().getX(), answerVector.getX());
        assertEquals(testVector.normalize().getY(), answerVector.getY());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Vector333Class testVector = new Vector333Class(9320, -0.38032);
        String strAnswer = "< 9320, -0.38032 >";
        assertTrue(testVector.toString().equals(strAnswer));
    }

    @org.junit.jupiter.api.Test
    void parseVector() {
        String vectorStr = "< 5932.390, -.4832 >";
        Scanner testScanner = new Scanner(vectorStr);
        Vector333Class.parseVector(testScanner);
    }

    @org.junit.jupiter.api.Test
    void getX() {
        Vector333Class testVector = new Vector333Class(0.48934, -502.38803);
        assertEquals(testVector.getX(), 0.48934);
    }

    @org.junit.jupiter.api.Test
    void getY() {
        Vector333Class testVector = new Vector333Class(0.48934, -502.38803);
        assertEquals(testVector.getY(), -502.38803);
    }

    @org.junit.jupiter.api.Test
    void getXint() {
        Vector333Class testVector = new Vector333Class(0, 600);
        assertEquals(testVector.getYint(), 0);
    }

    @org.junit.jupiter.api.Test
    void getYint() {
        Vector333Class testVector = new Vector333Class(0, 600);
        assertEquals(testVector.getYint(), 600);
    }

    @org.junit.jupiter.api.Test
    void getXlong() {
        Vector333Class testVector = new Vector333Class(400.59, 400.59);
        assertEquals(testVector.getXlong(), 400.59);
    }

    @org.junit.jupiter.api.Test
    void getYlong() {
        Vector333Class testVector = new Vector333Class(400.59, 400.59);
        assertEquals(testVector.getYlong(), 400.59);
    }

    @org.junit.jupiter.api.Test
    void setX() {
        Vector333Class testVector = new Vector333Class();
        testVector.setY(-400.6930382);
    }

    @org.junit.jupiter.api.Test
    void setY() {
        Vector333Class testVector = new Vector333Class();
        testVector.setY(-5022.19021);
    }

    @org.junit.jupiter.api.Test
    void testSetX() {
        Vector333Class testVector = new Vector333Class();
        testVector.setX(-400);
    }

    @org.junit.jupiter.api.Test
    void testSetY() {
        Vector333Class testVector = new Vector333Class();
        testVector.setY(0);
    }

    @org.junit.jupiter.api.Test
    void testSetX1() {
        Vector333Class testVector = new Vector333Class();
        testVector.setX(-392.482);
    }

    @org.junit.jupiter.api.Test
    void testSetY1() {
        Vector333Class testVector = new Vector333Class();
        testVector.setY(-9692.389);
    }
}