package ru.ucoz.rezept_day.percentage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    //Таймер
    private lateinit var timer: CountDownTimer
    private lateinit var anim_button: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        anim_button = AnimationUtils.loadAnimation(this, R.anim.scale_screen_button)
    }

    private fun startTimer(){

        timer = object : CountDownTimer(2000, 1000){
            override fun onFinish(){
                val i = Intent(this@MainActivity, MainMenu::class.java)
                startActivity(i)
            }

            override fun onTick(millisUntilFinished: Long) {

            }
        }.start()
    }

    override fun onStart() {//колбэк - экран виден, можем проигнорировать, нет особой разницы между onStart и onResume
        // Важен только при разделении экрана, когда один экран активен, а другой нет
        super.onStart()
        screen_text.startAnimation(anim_button)
        startTimer()

    }
}
