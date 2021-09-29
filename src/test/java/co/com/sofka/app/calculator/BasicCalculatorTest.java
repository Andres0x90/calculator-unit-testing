package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    private final BasicCalculator bc = new BasicCalculator();

    @DisplayName("Testing sum...")
    @ParameterizedTest()
    @CsvSource({
            "2,5,7",
            "35,10,45",
            "8,0,8",
            "-2,9,7"
    })
    void sum(Long num1, Long num2, Long expectedResult)
    {
        Long result = bc.sum(num1, num2);
        assertEquals(result, expectedResult);
    }

    @DisplayName("Testing rest...")
    @ParameterizedTest
    @CsvSource({
            "2,5,-3",
            "35,10,25",
            "8,0,8",
            "-2,9,-11"
    })
    void rest(Long num1, Long num2, Long expectedResult) {
        Long result = bc.rest(num1, num2);
        assertEquals(result, expectedResult);
    }

    @DisplayName("Testing multiply...")
    @ParameterizedTest
    @CsvSource({
            "2,5,10",
            "35,10,350",
            "8,0,0",
            "-2,9,-18"
    })    void multiply(Long num1, Long num2, Long expectedResult) {
        Long result = bc.multiply(num1, num2);
    }

    @DisplayName("Testing divide...")
    @ParameterizedTest
    @CsvSource({
            "8,2,4",
            "-30,-10,3"
    })
    void divide(Long num1, Long num2, Long expectedResult) {
        Long result = bc.divide(num1, num2);
        assertEquals(result, expectedResult);
    }
    @Test
    @DisplayName("Testing divide by zero")
    void divideByZero()
    {
        assertThrows(IllegalArgumentException.class, ()->bc.divide(6L, 0L));
    }
}