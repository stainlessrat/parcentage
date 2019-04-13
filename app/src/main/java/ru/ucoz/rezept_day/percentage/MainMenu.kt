package ru.ucoz.rezept_day.percentage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toast.makeText
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu: AppCompatActivity(){

    //lateinit var mInterstitialAd: InterstitialAd//Реклама
    companion object {
        val MENU_ITEM = "menu_item"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        btn_percent_of_number.setOnClickListener {
            val a = Intent(this, CountActivity::class.java)
            //Toast.makeText(this, (btn_percent_of_number.getTag()).toString(), Toast.LENGTH_SHORT).show()
            a.putExtra(MENU_ITEM, btn_percent_of_number.getTag().toString())
            startActivity(a)
        }
        btn_number_of_number_in_percent.setOnClickListener {
            val b = Intent(this, CountActivity::class.java)
            b.putExtra(MENU_ITEM, btn_number_of_number_in_percent.getTag().toString())
            startActivity(b)
        }
        btn_increase.setOnClickListener {
            val c = Intent(this, CountActivity::class.java)
            c.putExtra(MENU_ITEM, btn_increase.getTag().toString())
            startActivity(c)
        }
        btn_decrease.setOnClickListener {
            val d = Intent(this, CountActivity::class.java)
            d.putExtra(MENU_ITEM, btn_decrease.getTag().toString())
            startActivity(d)
        }

//        //Реклама межстраничная
//        //ca-app-pub-6832799780005399~3346139569
//        MobileAds.initialize(this, "ca-app-pub-6832799780005399~3346139569")
//
//        mInterstitialAd = InterstitialAd(this)
//        mInterstitialAd.adUnitId = "ca-app-pub-6832799780005399/2066090758"
//        mInterstitialAd.loadAd(AdRequest.Builder().build())
//        //mInterstitialAd.loadAd(AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build())
//
//
//        mInterstitialAd.adListener = object : AdListener() {
//            override fun onAdClosed() {
//                closeExit()
//            }
//        }

    }

    override fun onBackPressed() {
//        if (mInterstitialAd.isLoaded) {
//            mInterstitialAd.show()
//        }else {
            closeExit()
//        }
    }//нажата кнопка назад

    fun closeExit(){//обработка закрытия приложения, без перехода на предыдущую активность
        super.onBackPressed();
        moveTaskToBack(true);
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
}


