package com.example.gameforchildren.levels.guesByTheSound

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gameforchildren.R
import com.example.gameforchildren.levels.edibleGame.EdibleGameFragment
import com.example.gameforchildren.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_edible_game_main.*


class GuesDescriptionFragment : Fragment(R.layout.fragment_gues_description) {
    override fun onResume() {

        super.onResume()
        normalButtonStart.setOnClickListener {
            replaceFragment(GuessByTheSoundFragment(true), false)
        }
        timeGameStart.setOnClickListener { replaceFragment(GuessByTheSoundFragment(false) ) }
    }
    }
