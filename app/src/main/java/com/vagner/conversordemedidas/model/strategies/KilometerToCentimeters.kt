package com.vagner.conversordemedidas.model.strategies

class KilometerToCentimeters : CalculationStrategy {
    override fun calculate(value: Double): Double = value * 100_000

    override fun getResultLabel(isPlural: Boolean): String {
        return if (isPlural) {
            "Centimetros"
        } else {
            "Centimetro"
        }
    }
}