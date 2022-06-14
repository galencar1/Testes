package org.example;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class FirstTest {
    Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
    }
    @Test
    public void mustAddTwoNumbers(){
        //scenario
        int number1 = 10, number2 = 5;
        //executor
        int result = calculator.addUp(number1, number2);
        //verification
//      Assert.assertEquals(15,result);
        Assertions.assertThat(result).isEqualTo(15);
    }

    @Test(expected = RuntimeException.class)//Prepara a classe teste para receber uma exceção.
    public void mustNotAddNegativeNumbers(){
        //scenario
        int num1 = -10, num2 = 5;
        //executor
        calculator.addUp(num1, num2);
        //verification

    }

    @Test
    public void mustSubtractTwoNumbers(){
        //scenario
        int num1 = 10, num2 = 5;
        //executor
        int result = calculator.subtract(num1, num2);
        //verification
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    public void mustDivideTwoNumbers(){
        //scenario
        int num1 = 10 , num2 = 5;
        //executor
        int result = calculator.divide(num1, num2);

        //verification
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void mustMultiplyTwoNumbers(){
        //scenario
        int num1 = 10, num2 = 5;
        //executor
        int result = calculator.multiply(num1, num2);
        //verification
        Assertions.assertThat(result).isEqualTo(50);
    }
}

class Calculator{
    int addUp(int num , int num2){
        if(num < 0 || num2 < 0){
            throw new RuntimeException("Adding negative numbers is not allowed");
        }
        return num + num2;
    }

    int subtract(int num, int num2) {
        if(num < 0 || num2 < 0){
            throw new RuntimeException("It is not allowed to subtract negative numbers");
        }
        return  num - num2;
    }

    int divide(int num, int num2){
        if (num < 0 || num2 <= 0){
            throw new RuntimeException("Division by negative or zero numbers is not allowed.");
        }
        return num / num2;
    }

    int multiply(int num, int num2){
        if (num < 0 || num2 < 0){
            throw new RuntimeException("Multiplying numbers by zero is not allowed");
        }
        return num * num2;
    }
}
