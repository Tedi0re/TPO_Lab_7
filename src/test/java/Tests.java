import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {
    @Test
    public void test_sum() throws Exception {
        float value = Calculator.Sum(1,2);
        Assertions.assertEquals(3.f, value);
    }

    @Test
    public void test_sum_ex() throws Exception {
       Exception ex =  Assertions.assertThrows(Exception.class, () -> {
            Calculator.Sum(Float.MAX_VALUE, Float.MAX_VALUE);
        });
       Assertions.assertEquals("Float.VALUE", ex.getMessage());
    }

    @Test
    public void test_sub_ex() throws Exception {
        Exception ex =  Assertions.assertThrows(Exception.class, () -> {
            Calculator.Sub(Float.MAX_VALUE, -Float.MAX_VALUE);
        });
        Assertions.assertEquals("Float.VALUE", ex.getMessage());
    }
    @Test
    public void test_mul_ex() throws Exception {
        Exception ex =  Assertions.assertThrows(Exception.class, () -> {
            Calculator.Mul(Float.MAX_VALUE, Float.MAX_VALUE);
        });
        Assertions.assertEquals("Float.VALUE", ex.getMessage());
    }
    @Test
    public void test_div_ex() throws Exception {
        Exception ex =  Assertions.assertThrows(Exception.class, () -> {
            Calculator.Div(Float.MAX_VALUE, 0.000001f);
        });
        Assertions.assertEquals("Float.VALUE", ex.getMessage());
    }

    @Test
    public void test_sub() throws Exception {
        float value = Calculator.Sub(1,2);
        Assertions.assertEquals(-1.f, value);
    }

    @Test
    public void test_mul() throws Exception {
        float value = Calculator.Mul(1,2);
        Assertions.assertEquals(2.f, value);
    }

    @Test
    public void test_div() throws Exception {
        float value = Calculator.Div(2,2);
        Assertions.assertEquals(1.f, value);
    }




}
