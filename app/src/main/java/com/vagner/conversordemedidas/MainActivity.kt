package com.vagner.conversordemedidas

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.vagner.conversordemedidas.databinding.ActivityMainBinding
import com.vagner.conversordemedidas.model.CalculationStrategyHolder
import com.vagner.conversordemedidas.model.Calculator
import com.vagner.conversordemedidas.model.strategies.KilometerToCentimeters
import com.vagner.conversordemedidas.model.strategies.KilometerToMeterStrategy
import com.vagner.conversordemedidas.model.strategies.MeterToCentimetersStrategy
import com.vagner.conversordemedidas.model.strategies.MeterToKilometerStrategy

class MainActivity : AppCompatActivity() {

    private lateinit var spConversions: Spinner
    private lateinit var binding: ActivityMainBinding

    private val supportedCalculationStrategy = arrayOf(
        CalculationStrategyHolder("Quilômetros para centímetros", KilometerToCentimeters()),
        CalculationStrategyHolder("Quilômetros para metros", KilometerToMeterStrategy()),
        CalculationStrategyHolder("Metros para centímetros", MeterToCentimetersStrategy()),
        CalculationStrategyHolder("Metros para quilômetros", MeterToKilometerStrategy())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUi()
        setActions()
    }

    private fun setActions() {
        binding.btConvert.setOnClickListener {
            try {
                val value = binding.edtValue.text.toString().toDouble()
                val calculationStrategy = supportedCalculationStrategy[
                        spConversions.selectedItemPosition
                ].calculationStrategy

                if (it == binding.btConvert) {
                    Calculator.setCalculationStrategy(
                        calculationStrategy
                    )
                    val result = Calculator.calculate(value)

                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("RESULT", result)
                    intent.putExtra("LABEL", calculationStrategy.getResultLabel(result > 1))
                    startActivity(intent)
                }
            } catch (e: NumberFormatException) {
                binding.edtValue.error = "Valor Inválido"
                binding.edtValue.requestFocus()
            }
        }

        binding.btClean.setOnClickListener {

            binding.edtValue.setText("")
            binding.edtValue.error = null
            binding.spConversions.setSelection(0)
        }
    }

    private fun setUi() {
        spConversions = binding.spConversions
        val spAdapter = ArrayAdapter(this, R.layout.res_spinner_item, getSpinnerData())
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spConversions.adapter = spAdapter
    }
    private fun getSpinnerData(): MutableList<String> {
        val spinnerData = mutableListOf<String>()
        supportedCalculationStrategy.forEach {
            spinnerData.add(it.name)
        }
        return spinnerData
    }
}

