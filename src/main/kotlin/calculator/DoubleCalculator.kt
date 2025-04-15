package org.example.calculator

class DoubleCalculator: ICalculator {
    override fun calculate(price: Int): Double {
        return (price * 2).toDouble()
    }
}