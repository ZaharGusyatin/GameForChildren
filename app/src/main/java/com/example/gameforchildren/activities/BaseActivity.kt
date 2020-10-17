package com.example.gameforchildren.activities

import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gameforchildren.utilits.showToast

open class BaseActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.finish()
            return
        }
        this.doubleBackToExitPressedOnce = true
        showToast("кликЕщеРаз")

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 1500)
    }
}
