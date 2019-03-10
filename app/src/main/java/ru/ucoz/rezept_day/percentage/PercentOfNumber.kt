package ru.ucoz.rezept_day.percentage

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_persent_of_number.*
import kotlinx.android.synthetic.main.activity_persent_of_number.view.*

class PercentOfNumber:Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persent_of_number)

        percent.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (percent.text.length != 0){
                    MyCalculete.in_pers = (percent.text.toString()).toDouble()
                    if (number.text.length != 0) {
                        MyCalculete.in_number = (number.text.toString()).toDouble()
                        out_result.text = MyCalculete.persentOfNumber()
                    }
                   } else out_result.text = ""
            }


        })
        number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (number.text.length != 0) {
                    MyCalculete.in_number = (number.text.toString()).toDouble()
                    if (percent.text.length != 0) {
                        MyCalculete.in_pers = (percent.text.toString()).toDouble()
                        out_result.text = MyCalculete.persentOfNumber()
                    }
                } else out_result.text = ""

            }
        })

        btn_reset.setOnClickListener {
            percent.text = null
            number.text = null
            out_result.text = ""
        }

    }
}

