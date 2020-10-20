package com.example.gameforchildren.activities


import android.os.Bundle
import com.example.gameforchildren.databinding.ActivityMainBinding
import com.example.gameforchildren.ui.fragments.StartScreenFragment
import com.example.gameforchildren.utilits.APP_ACTIVITY
import com.example.gameforchildren.utilits.replaceFragment


class MainActivity : BaseActivity() {

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        replaceFragment(StartScreenFragment(), false)


    }

}






