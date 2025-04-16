package org.example.calculator

import org.json.JSONObject
import java.io.File
import java.math.BigDecimal
import kotlin.time.times

class TariffCalculator: ICalculator {
    override fun calculate(price: Int): Double {
        // get tarrifPrice for the time being since price is an int and not a data object with price and origin
        // I'll just hit it from china for convenience
        val tariff = getCountryTariff("CN")

        return price + (price.times(tariff.toDouble()))
    }

    private fun getCountryTariff(countryCode: String): BigDecimal {

        val inputStream = javaClass.getResourceAsStream("/tariffs.json")
        val jsonString = inputStream?.bufferedReader()?.use { it.readText() }

        val jsonObject = JSONObject(jsonString)

        // Get keys (country codes)
        return jsonObject.has(countryCode).takeIf { it }?.let { jsonObject.get(countryCode) as BigDecimal }
            ?: throw NoSuchElementException("$countryCode is not in the tarrif calc at the moment. Please come back once they are updated")
    }
}