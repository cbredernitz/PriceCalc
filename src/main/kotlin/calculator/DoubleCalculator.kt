package org.example.calculator

class DoubleCalculator: ICalculator {
    override fun calculate(price: Int): Double {
        // double price because why not
        return (price * 2).toDouble()
    }
}