import org.example.calculator.DoubleCalculator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DoubleCalculatorTest {
    private val doubleCalculator = DoubleCalculator()

    @Test
    fun testCalculate() {
        val actual = doubleCalculator.calculate(10)
        val expected = 20.0

        assertEquals(expected, actual)
    }
}