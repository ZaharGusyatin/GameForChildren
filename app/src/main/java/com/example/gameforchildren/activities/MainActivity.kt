package com.example.gameforchildren.activities


import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameforchildren.R
import com.example.gameforchildren.adapters.MainAdapter
import com.example.gameforchildren.databinding.ActivityMainBinding
import com.example.gameforchildren.model.MainItemModel
import com.example.gameforchildren.ui.StartScreenFragment
import com.example.gameforchildren.ui.fragments.guessByTheSound.GuessByTheSoundFragment
import com.example.gameforchildren.utilits.APP_ACTIVITY
import com.example.gameforchildren.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_level_selection.*


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






