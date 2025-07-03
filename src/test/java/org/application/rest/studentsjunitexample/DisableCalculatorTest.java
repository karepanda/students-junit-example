package org.application.rest.studentsjunitexample;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisableCalculatorTest {

    @Test
    void addTest(){
        Calculator calculator = new Calculator();
        int addition = calculator.add(10, 20);
        assertEquals(30, addition);
    }

    @Test
    void subtractTest(){
        Calculator calculator = new Calculator();
        int subtraction = calculator.subtract(20, 10);
        assertEquals(10, subtraction);
    }

    @Test
    void multiplyTest(){
        Calculator calculator = new Calculator();
        int multiplication = calculator.multiply(3, 2);
        assertEquals(6, multiplication);
    }

    @Test
    void divideTest(){
        Calculator calculator = new Calculator();
        int division = calculator.divide(20, 4);
        assertEquals(5, division);
    }

    @Test
    @Disabled
    void whenDivideByZeroThenThrowException() {
        Calculator calculator = new Calculator();

        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));

    }

}
