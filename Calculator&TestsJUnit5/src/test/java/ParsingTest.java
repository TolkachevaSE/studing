import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParsingTest {

    @ParameterizedTest(name = "{index} - operator input testing. Input <{1}> and expected {0}")
    @CsvSource({
            "+,+",
            "-, -",
            "/, /",
            "*, *",
            "wrong, 46",
            "wrong, sffs ",
            "wrong, @"})
    public void testCheckOperator(String expected_s, String symbol) {
        assertEquals(expected_s, Calculator.checkOperator(symbol), "checkOperator doesn't work for <" + symbol + ">");
    }

    private static Object[] number() {
        return new Object[][]{
                {"-25.3", -25.3},
                {"1.7976931348623157E308", 1.7976931348623157E308},
                {"0", 0},
                {"8.8397116228599368E18", 8.8397116228599368E18}
        };
    }
    @ParameterizedTest(name = "{index} - valid number input testing. Enter <{0}> and expect to get {1}")
    @MethodSource("number")
    public void testValidNumber(String in, double expected) {
        assertEquals(expected, Calculator.getNumber(in));
    }

    @ParameterizedTest(name = "{index} - invalid number input testing. Enter <{0}> and expect to get NaN")
    @CsvSource({
            "22 33",
            "word",
            "@",
            "6word"})
    public void testInvalidNumber(String symbol) {
        assertEquals(NaN, Calculator.getNumber(symbol), symbol + " doesn't work as invalid, but it should be wrong");
    }

    @Test
    public void testOverflow(){
        assertEquals(Double.POSITIVE_INFINITY,Calculator.getResult(Double.MAX_VALUE,"*",Double.MAX_VALUE),"qweqwe");
        assertEquals(Double.NEGATIVE_INFINITY,Calculator.getResult(-Double.MAX_VALUE,"*",Double.POSITIVE_INFINITY));

    }

}
