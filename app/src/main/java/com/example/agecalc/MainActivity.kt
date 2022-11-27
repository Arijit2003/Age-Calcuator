package com.example.agecalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val selectedDate:TextView=findViewById(R.id.selectedDate)
        val calculatedAge:TextView=findViewById(R.id.calculatedAge)

        val selectDateButton: Button =findViewById(R.id.selectDateButton)
        selectDateButton.setOnClickListener(){
            val calendar:Calendar=Calendar.getInstance()
            val year=calendar.get(Calendar.YEAR)
            val month=calendar.get(Calendar.MONTH)
            val day=calendar.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this,"Date Selected",Toast.LENGTH_SHORT).show()
                val SelectedDate:String="${selectedDayOfMonth}/${selectedMonth+1}/${selectedYear}"
                selectedDate.text=SelectedDate
                val sdf:SimpleDateFormat= SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
                val selectedDateObj=sdf.parse(SelectedDate)
                val selectedDateInMinutes=(selectedDateObj!!.time)/60000
                val currentDate:String="${day}/${month+1}/${year}"
                val currentDateObj=sdf.parse(currentDate)
                val currentDateInMinutes=(currentDateObj!!.time)/60000
                val difference=currentDateInMinutes-selectedDateInMinutes
                calculatedAge.text=difference.toString()



            },year,month,day).show()
        }
    }

}