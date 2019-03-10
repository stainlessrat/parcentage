package ru.ucoz.rezept_day.percentage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu: AppCompatActivity(){

    lateinit var mInterstitialAd: InterstitialAd//Реклама

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        btn_percent_of_number.setOnClickListener {
            val a = Intent(this, PercentOfNumber::class.java)
            startActivity(a)
        }
        btn_number_of_number_in_percent.setOnClickListener {
            val b = Intent(this, NumberOfNumberInPercent::class.java)
            startActivity(b)
        }
        btn_increase.setOnClickListener {
            val c = Intent(this, Increase::class.java)
            startActivity(c)
        }
        btn_decrease.setOnClickListener {
            val d = Intent(this, Decrease::class.java)
            startActivity(d)
        }

        //Реклама
        //ca-app-pub-6832799780005399~3346139569
        MobileAds.initialize(this, "ca-app-pub-6832799780005399~3346139569")

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-6832799780005399/2066090758"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        //mInterstitialAd.loadAd(AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build())


        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdClosed() {
                closeExit()
            }
        }

    }

    override fun onBackPressed() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        }else {
            closeExit()
        }
    }//нажата кнопка назад

    fun closeExit(){//обработка закрытия приложения, без перехода на предыдущую активность
        moveTaskToBack(true);
        super.onBackPressed();
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.star_play_market -> {
                //оценка приложения?
                val intentStar = Intent(Intent.ACTION_VIEW)
                intentStar.data = Uri.parse("market://details?id=ru.ucoz.rezept_day.percentage")
                startActivity(intentStar)
                //Toast.makeText(this, "Menu 1 is selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.share_menu//Поделиться
            -> {
                val i = Intent(Intent.ACTION_SEND)

                i.setType("text/plain")
//                sendIntent.setAction(Intent.ACTION_SEND)
//                //sendIntent.putExtra(Intent.EXTRA_SUBJECT, "https://play.google.com/store/apps/details?id=ru.ucoz.day.rezept.game15");
                i.putExtra(Intent.EXTRA_TEXT, "Приложение Расчет Процентов - https://play.google.com/store/apps/details?id=ru.ucoz.rezept_day.percentage")

                if (i.resolveActivity(packageManager) != null) {
                    startActivity(i)
                }
                //Toast.makeText(this, "Menu 2 is selected", Toast.LENGTH_SHORT).show()
                return true
            } else -> return super.onOptionsItemSelected(item)

        }
    }

    override fun onStart() {//колбэк - экран виден, можем проигнорировать, нет особой разницы между onStart и onResume
        // Важен только при разделении экрана, когда один экран активен, а другой нет
        super.onStart()
    }

    override fun onResume() {//колбэк - экран работает, можно запускать анимацию, все процессы
        super.onResume()
    }

    override fun onPause() {//Прекратит работу, нажет HOME или Back или зазвонит телефон
        super.onPause() //Здесь нужно остановить все, что мы запуститли в onResume. И нужно быть готовым к тому что
        //в нашем приложении ничего большен не будет вызвано в нашем Активити
    }

    override fun onStop() {//Колбэк симитричный onStart, редко используют, т.к. все самое важное останавливают в onPause
        super.onStop()
    }

    override fun onDestroy() {//Колбэк удаляет из системы все данные программы, например можно удалить закэщированные данные
        super.onDestroy();
    }
}


