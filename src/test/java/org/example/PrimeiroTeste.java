package org.example;

import org.assertj.core.api.Assertions;
// import org.junit.Assert;
// import org.assertj.core.api.Assertions.*;
// import org.junit.Assert;
import org.junit.Test;

public class PrimeiroTeste {


    @Test
    public void estruturaDeUmTeste(){
        //scenario
        int number1 = 10, number2 = 5;
        //executor
        int result = number1 + number2;
        //verification
//      Assert.assertEquals(15,result);
        Assertions.assertThat(result).isBetween(14,16);
    }
}
