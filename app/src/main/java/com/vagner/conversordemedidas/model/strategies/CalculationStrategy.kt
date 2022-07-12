package com.vagner.conversordemedidas.model.strategies

interface CalculationStrategy {

    fun calculate(value : Double): Double

    fun getResultLabel(isPlural : Boolean) : String
}