package com.example.gameforchildren

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gameforchildren.databinding.ActivityMainBinding
import com.example.gameforchildren.utilits.APP_ACTIVITY

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        startScreen()

    }

    private fun startScreen() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.dataContainer, StartScreenFragment())
                .commit()
    }
}