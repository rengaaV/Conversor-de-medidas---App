package com.vagner.conversordemedidas.model

import com.vagner.conversordemedidas.model.strategies.CalculationStrategy

data class CalculationStrategyHolder(
    val name: String,
    val calculationStrategy: CalculationStrategy
)