package com.example.gameforchildren.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gameforchildren.R
import com.example.gameforchildren.ui.fragments.edibleGameFragments.EdibleGameMainFragment
import com.example.gameforchildren.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_level_selection.*

class LevelSelectionFragment : Fragment(R.layout.fragment_level_selection){
    override fun onResume() {
        super.onResume()
   levelSelectionEdible.setOnClickListener { replaceFragment(EdibleGameMainFragment()) }
    }
}