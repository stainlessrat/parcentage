package ru.ucoz.rezept_day.percentage

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_count.*
import ru.ucoz.rezept_day.percentage.present.MyPresent

class CountActivity : Activity() {

    private lateinit var anim: Animation
    private lateinit var myLayout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)

        val intent = getIntent()
        val menu_item: Int = intent.getStringExtra(MainMenu.MENU_ITEM).toInt()

        //come_in.setText(menu_item.toString())
        initUI(menu_item);


        percent.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                MyPresent.changeText(percent,number,out_result, menu_item)
            }


        })
        number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                MyPresent.changeText(number, percent,out_result, menu_item)
            }
        })

        btn_reset.setOnClickListener {
            MyPresent.clearText(number, percent, out_result)
        }

    }

    private fun initUI(page: Int) {
        when(page){
            0 -> {
                come_in.setText(R.string.come_in_persent_of_number)
                in_number_one.setText(R.string.in_number)
                in_number_two.setText(R.string.in_persent)
            }
            1 -> {
                come_in.setText(R.string.come_in_number_of_number)
                in_number_one.setText(R.string.in_number)
                in_number_two.setText(R.string.in_two_number)
            }
            2 -> {
                come_in.setText(R.string.come_in_increase)
                in_number_one.setText(R.string.in_number)
                in_number_two.setText(R.string.in_persent)
            }
            3 -> {
                come_in.setText(R.string.come_in_decreate)
                in_number_one.setText(R.string.in_number)
                in_number_two.setText(R.string.in_persent)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        myLayout = findViewById<RelativeLayout>(R.id.myLayout)
        anim = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        myLayout.startAnimation(anim)
    }

    override fun onBackPressed() {
        myLayout = findViewById<RelativeLayout>(R.id.myLayout)
        anim = AnimationUtils.loadAnimation(this, R.anim.scale_down)
        myLayout.startAnimation(anim)
        super.onBackPressed()
    }
}
