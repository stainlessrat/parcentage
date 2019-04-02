package ru.ucoz.rezept_day.percentage

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.Layout
import android.text.TextWatcher
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_persent_of_number.*
import ru.ucoz.rezept_day.percentage.present.MyPresent

class PercentOfNumber:Activity() {

    private lateinit var anim: Animation
    private lateinit var myLayout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persent_of_number)

        percent.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                MyPresent.changeText(percent,number,out_result, MyPresent.PERSENT_OF_NUMBER)
            }


        })
        number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                MyPresent.changeText(number, percent,out_result, MyPresent.PERSENT_OF_NUMBER)
            }
        })

        btn_reset.setOnClickListener {
            MyPresent.clearText(number, percent, out_result)
        }

    }

    override fun onResume() {
        super.onResume()
        myLayout = findViewById<RelativeLayout>(R.id.myLayout)
        anim = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        myLayout.startAnimation(anim)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        myLayout = findViewById<RelativeLayout>(R.id.myLayout)
        anim = AnimationUtils.loadAnimation(this, R.anim.scale_down)
        myLayout.startAnimation(anim)
    }
}

