package com.example.gameforchildren

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gameforchildren.databinding.ActivityMainBinding
import com.example.gameforchildren.ui.StartScreenFragment
import com.example.gameforchildren.ui.fragments.LevelSelectionFragment
import com.example.gameforchildren.ui.fragments.edibleGameFragments.EdibleGameMainFragment
import com.example.gameforchildren.utilits.APP_ACTIVITY
import com.example.gameforchildren.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_start_screen_fragment.*

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        replaceFragment(StartScreenFragment(), false)


    }


}