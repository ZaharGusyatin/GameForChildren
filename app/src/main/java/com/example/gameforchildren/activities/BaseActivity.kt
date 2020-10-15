package com.example.gameforchildren.activities

import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gameforchildren.utilits.showToast

open class BaseActivity :AppCompatActivity(){
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
