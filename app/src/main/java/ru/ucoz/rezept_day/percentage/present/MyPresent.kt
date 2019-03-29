package ru.ucoz.rezept_day.percentage.present

import android.widget.EditText
import android.widget.TextView
import ru.ucoz.rezept_day.percentage.model.MyCalculete

class MyPresent {
    companion object {
        fun changeText(viewPersent: EditText, viewNumber: EditText,viewOutResult: TextView){
            if (viewPersent.text.length != 0){
                MyCalculete.in_pers = (viewPersent.text.toString()).toDouble()
                if (viewNumber.text.length != 0) {
                    MyCalculete.in_number = (viewNumber.text.toString()).toDouble()
                    viewOutResult.text = MyCalculete.getPersentOfNumber()
                }
            } else viewOutResult.text = ""
        }
    }
}