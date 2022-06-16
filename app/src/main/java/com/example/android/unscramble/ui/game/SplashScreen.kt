package com.example.android.unscramble.ui.game

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.android.unscramble.MainActivity
import com.example.android.unscramble.R
import com.example.android.unscramble.ui.game.datas.LevelsViewModel
import com.example.android.unscramble.ui.game.datas.entries
import com.example.android.unscramble.ui.game.login.LoginActivity

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val lastversion = this?.getSharedPreferences("version", Context.MODE_PRIVATE) ?: return
        val lastversionvalue = lastversion.getInt("appversion", 0) ?: 0
        Handler().postDelayed(
            {
                if (lastversionvalue == 0) {

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)


                } else {
                    val intent = Intent(this, Welcomeuser::class.java)
                    startActivity(intent)

                }
            }, 1500
        )
        lastversion.edit().putInt("appversion", 1).commit();
    }
}