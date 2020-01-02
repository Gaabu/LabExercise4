package com.example.labexercise4

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dobSelected.setOnClickListener { calInvestment() }
    }

    @SuppressLint("SetTextI18n")
    private fun calInvestment(){
        var saving:Double = 0.0
        var investment:Double

        val date = Calendar.getInstance()
        val nYear = date.get(Calendar.YEAR)
        val nMonth = date.get(Calendar.MONTH)
        val nDay = date.get(Calendar.DAY_OF_MONTH)

        val datePd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month, day ->
            val cMonth = month +1
            dobSelected.text = "$day-$cMonth-$year"
            val CalAge = nYear- year
            saving = when(CalAge){
                in 0..15 -> 0.0
                in 16..20 -> 5000.0
                in 21..25 -> 14000.0
                in 26..30 -> 29000.0
                in 31..35 -> 50000.0
                in 36..40 -> 78000.0
                in 41..45 -> 116000.0
                in 46..50 -> 165000.0
                in 51..55 -> 228000.0
                else -> 228000.0

            }

            investment = saving * 0.30
            age_txt.text = CalAge.toString()
            savingAmount.text = saving.toString()
            totalInvestment.text = investment.toString()


        }, nYear,nMonth,nDay)
                datePd.show()
    }
}