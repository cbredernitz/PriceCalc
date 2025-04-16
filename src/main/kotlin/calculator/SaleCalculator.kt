package org.example.calculator

import kotlin.time.times

class SaleCalculator: ICalculator {
    override fun calculate(price: Int): Double {
        // give a 10% sale to the item
        return price - price.times(0.1)
    }
}