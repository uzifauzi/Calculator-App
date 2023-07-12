package com.nurfauzi.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvInput: TextView
    private var isLastNumeric: Boolean = false
    private var isLastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tv_input)

    }

    fun onDigit(view: View) {
        tvInput.append((view as Button).text)
        isLastNumeric = true
        isLastDot = false
    }

    fun onClear(view: View) {
        tvInput.text = ""
    }

    fun onDecimalPoint(view: View) {
        if (isLastNumeric && !isLastDot) {
            tvInput.append(".")
            isLastNumeric = false
            isLastDot = true
        }
    }
}

private fun isOperatorAdded(value: String): Boolean {
    return if (value.startsWith("-")) {
        false
    } else {
        value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")

    }
}