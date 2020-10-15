package com.example.gameforchildren.ui.fragments

import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.ui.fragments.edibleGameFragments.EdibleGameMainFragment
import com.example.gameforchildren.ui.fragments.guessByTheSound.GuessByTheSoundFragment
import com.example.gameforchildren.utilits.APP_ACTIVITY
import com.example.gameforchildren.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_level_selection.*

class LevelSelectionFragment : Fragment(R.layout.fragment_level_selection) {
    override fun onResume() {
        super.onResume()
        button_level_selection_edible.setOnClickListener { replaceFragment(EdibleGameMainFragment(),false) }
        button_guess_by_the_sounds.setOnClickListener { replaceFragment(GuessByTheSoundFragment(),false) }
        buttonExit.setOnClickListener { APP_ACTIVITY.finish() }

    }

}