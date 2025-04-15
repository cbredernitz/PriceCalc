package org.example.calculator

class DefaultCalculator:ICalculator {
    override fun calculate(price: Int): Double {
        return price.toDouble()
    }
}