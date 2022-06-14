package org.example;

import org.assertj.core.api.Assertions;
// import org.junit.Assert;
// import org.assertj.core.api.Assertions.*;
// import org.junit.Assert;
import org.junit.Test;

public class PrimeiroTeste {


    @Test
    public void mustAddTwoNumbers(){
        //scenario
        int number1 = 10, number2 = 5;
        //executor
        int result = number1 + number2;
        //verification
//      Assert.assertEquals(15,result);
        Assertions.assertThat(result).isEqualTo(15);
    }
}
