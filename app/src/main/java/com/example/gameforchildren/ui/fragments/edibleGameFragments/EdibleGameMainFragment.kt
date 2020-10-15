package com.example.gameforchildren.ui.fragments.edibleGameFragments

import EdibleGameQuestionFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gameforchildren.R
import com.example.gameforchildren.utilits.APP_ACTIVITY
import com.example.gameforchildren.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_edible_game_main.*


class EdibleGameMainFragment : Fragment(R.layout.fragment_edible_game_main){
    override fun onResume() {
        super.onResume()
        edibleButtonStart.setOnClickListener {
            replaceFragment(EdibleGameQuestionFragment())
       }
    }
}