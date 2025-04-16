package org.example

import org.example.calculator.DefaultCalculator
import org.example.calculator.DoubleCalculator
import org.example.calculator.SaleCalculator
import org.example.calculator.TariffCalculator
import org.yaml.snakeyaml.Yaml
import java.io.InputStream

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val yaml = Yaml()
    val inputStream: InputStream = object {}.javaClass.getResourceAsStream("/application.yml")
        ?: throw IllegalArgumentException("application.yml not found")

    val data: Map<String, Map<String, Boolean>> = yaml.load(inputStream)

    val config = data["config"] ?: emptyMap()

    // this grabs the true value. Will update to only allow one to be turned on later
    val enabledConfig = config
        .filterValues { it }
        .mapNotNull { (key, _) ->
            when(key) {
                "tariff" -> TariffCalculator()
                "sale" -> SaleCalculator()
                "double" -> DoubleCalculator()
                else -> DefaultCalculator()
            }
        }.first()

    println(enabledConfig.calculate(1304))
}