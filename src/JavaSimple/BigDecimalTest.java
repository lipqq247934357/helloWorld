package JavaSimple;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTest {

    @Test
    public void test1(){
        BigDecimal num1 = new BigDecimal("111110");
        BigDecimal num2 = new BigDecimal("1000");
        BigDecimal num3 = num1.divide(num2);
        System.out.println(num3);
    }
    
}
