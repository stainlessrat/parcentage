package ru.ucoz.rezept_day.percentage.present

import android.widget.EditText
import android.widget.TextView
import ru.ucoz.rezept_day.percentage.model.MyCalculete

class MyPresent {
    companion object {

        val PERSENT_OF_NUMBER = 0
        val NUMBER_OF_NUMBER_PERCENT = 1
        val INCREASE = 2
        val DECREASE = 3

        fun changeText(viewPersent: EditText, viewNumber: EditText,viewOutResult: TextView, i: Int){
            if (viewPersent.text.length != 0){
                MyCalculete.in_pers = (viewPersent.text.toString()).toDouble()
                if (viewNumber.text.length != 0) {
                    MyCalculete.in_number = (viewNumber.text.toString()).toDouble()
                    when(i){
                        PERSENT_OF_NUMBER -> viewOutResult.text = MyCalculete.getPersentOfNumber()
                        NUMBER_OF_NUMBER_PERCENT -> viewOutResult.text = MyCalculete.getNumberOfNumberPercent()
                        INCREASE -> viewOutResult.text = MyCalculete.getIncrease()
                        DECREASE -> viewOutResult.text = MyCalculete.getDecrease()
                    }
                }
            } else viewOutResult.text = ""
        }
        fun clearText(viewPersent: EditText, viewNumber: EditText,viewOutResult: TextView){
            viewPersent.text = null
            viewNumber.text = null
            viewOutResult.text = ""
        }
    }
}