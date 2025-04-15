package org.example.calculator

import org.json.JSONObject
import java.io.File
import java.math.BigDecimal

class TariffCalculator: ICalculator {
    override fun calculate(price: Int): Double {
        // get tarrifPrice for the time being since price is an int and not a data object with price and origin
        // I'll just hit it from china for convenience
        val tariff = getCountryTariff("CA")

        return (price.times(tariff.precision()).toDouble()) //TODO: this math is not right atm. Had to refactor.
    }

    private fun getCountryTariff(countryCode: String): BigDecimal {
        // Read file as string
        val jsonString = File("tariffs.json").readText() //TODO: Fix this to use project path and not the fullpath

        // Parse JSON
        val jsonObject = JSONObject(jsonString)

        // Get keys (country codes)
        return jsonObject.has(countryCode).takeIf { it }?.let { jsonObject.get(countryCode) as BigDecimal }
            ?: throw NoSuchElementException("$countryCode is not in the tarrif calc at the moment. Please come back once they are updated")
    }
}