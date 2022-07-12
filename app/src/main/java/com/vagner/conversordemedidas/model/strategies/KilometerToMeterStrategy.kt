package com.vagner.conversordemedidas.model.strategies

class KilometerToMeterStrategy : CalculationStrategy {
    override fun calculate(value: Double): Double = value * 1_000

    override fun getResultLabel(isPlural: Boolean): String {
        return if (isPlural) {
            "Metros"
        } else {
            "Metro"
        }
    }
}