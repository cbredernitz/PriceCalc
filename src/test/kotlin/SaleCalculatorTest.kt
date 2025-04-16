import org.example.calculator.SaleCalculator
import kotlin.test.Test
import kotlin.test.assertEquals

class SaleCalculatorTest {
    private val saleCalculator = SaleCalculator()

    @Test
    fun testCalc() {
        val actual = saleCalculator.calculate(10)
        val expected = 9.0
        assertEquals(expected, actual)
    }
}