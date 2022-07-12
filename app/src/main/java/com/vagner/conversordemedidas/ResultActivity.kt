package com.vagner.conversordemedidas

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.vagner.conversordemedidas.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val result = intent.getDoubleExtra("RESULT", 0.0)
        val label = intent.getStringExtra("LABEL")

        binding.tvValue.text = result.toString()
        binding.tvValueLabel.text = label

        binding.btnClose.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        finish()
    }
}