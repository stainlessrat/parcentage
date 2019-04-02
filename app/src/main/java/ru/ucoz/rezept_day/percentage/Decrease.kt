package ru.ucoz.rezept_day.percentage

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_persent_of_number.*
import ru.ucoz.rezept_day.percentage.present.MyPresent

class Decrease:Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decrease)

        percent.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                MyPresent.changeText(percent, number, out_result, MyPresent.DECREASE)
            }
        })
        number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                MyPresent.changeText(number, percent, out_result, MyPresent.DECREASE)
            }
        })

        btn_reset.setOnClickListener {
            MyPresent.clearText(number, percent, out_result)
        }
    }
}