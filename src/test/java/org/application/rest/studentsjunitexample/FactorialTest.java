package org.application.rest.studentsjunitexample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    public void factorialTest(){
        //Given
        Factorial factorial = new Factorial();

        //When
        int actualResult = factorial.factorial(5);

        //Then
        assertEquals(120, actualResult);

    }

}