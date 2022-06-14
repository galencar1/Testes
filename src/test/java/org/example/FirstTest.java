package org.example;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FirstTest {

    @Test
    public void mustAddTwoNumbers(){
        Calculator calculator = new Calculator();

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
        Calculator calculator = new Calculator();
        int num1 = -10, num2 = 5;
        //executor
        calculator.addUp(num1, num2);
        //verification

    }

    @Test
    public void mustSubtractTwoNumbers(){
        //scenario
        Calculator calculator = new Calculator();
        int num1 = 10, num2 = 5;
        //executor
        calculator.subtract(num1, num2);
        //verification

    }

    @Test
    public void mustDivideTwoNumbers(){
        //scenario
        Calculator calculator = new Calculator();
        int num1 = 10 , num2 = 5;
        //executor
        calculator.divide(num1, num2);

        //verification
    }

    @Test
    public void mustMultiplyTwoNumbers(){
        //scenario
        Calculator calculator = new Calculator();
        int num1 = 10, num2 = 5;
        //executor
        calculator.multiply(num1, num2);
        //verification

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
