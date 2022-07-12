package com.vagner.conversordemedidas.model.strategies

class MeterToCentimetersStrategy : CalculationStrategy {
    override fun calculate(value: Double): Double = value * 100

    override fun getResultLabel(isPlural: Boolean): String {
        return if (isPlural) {
            "Centimetros"
        } else {
            "Centimetros"
        }
    }
}