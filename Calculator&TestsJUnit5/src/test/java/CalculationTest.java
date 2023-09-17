import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class CalculationTest {

    @ParameterizedTest
    @CsvSource({
            "9   , -1,      -, -10",
            "8   , 18,      -, 10",
                })

    public void testSubtraction(double expected, double num1, String o, double num2) {
        assertEquals(expected, Calculator.getResult(num1, o, num2));
    }

    @ParameterizedTest
    @CsvSource({
            "100 , 40,      +, 60",
            "-80 , -100,    +, 20",
            "1.5 ,  1,      +, 0.5"
    })

    public void testAddition(double expected, double num1, String o, double num2) {
        assertEquals(expected, Calculator.getResult(num1, o, num2),"Addition doesn't work");
    }

    @Test
    public void testDivision(){
        assertAll(
                ()->assertEquals(3, Calculator.getResult(150, "/", 50)),
                ()->assertEquals(500, Calculator.getResult(150, "/", 0.3))
        );
    }
    @Test
    public void testMultiplication (){
        assertEquals(14,Calculator.getResult(2,"*",7));
        assertEquals(14,Calculator.getResult(20,"*",0.7));
    }

    @Test
    public void testDivisionByZero(){
        RuntimeException ex = assertThrows(RuntimeException.class, ()->Calculator.getResult(100,"/",0));
        assertEquals("Can't divide by 0!",ex.getMessage(),"Doesn't receive right message in cause of dividing by 0");
           }


}
