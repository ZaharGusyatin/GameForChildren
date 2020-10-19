package com.example.gameforchildren.ui.fragments

import com.example.gameforchildren.levels.edibleGame.EdibleGameFragment
import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_edible_game_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


class DescriptionFragment : Fragment(R.layout.fragment_edible_game_main){
    override fun onResume() {
        super.onResume()

        normalButtonStart.setOnClickListener {
            replaceFragment(EdibleGameFragment(true), false)
       }
    timeGameStart.setOnClickListener { replaceFragment(EdibleGameFragment(false) )}
    }
}