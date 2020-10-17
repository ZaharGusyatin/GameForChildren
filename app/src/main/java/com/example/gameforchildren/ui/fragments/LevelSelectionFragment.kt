package com.example.gameforchildren.ui.fragments

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.adapters.MainAdapter
import com.example.gameforchildren.model.MainItemModel
import com.example.gameforchildren.ui.fragments.edibleGameFragments.EdibleGameMainFragment
import com.example.gameforchildren.ui.fragments.guessByTheSound.GuessByTheSoundFragment
import com.example.gameforchildren.utilits.*
import kotlinx.android.synthetic.main.fragment_guess_by_the_sound.*
import kotlinx.android.synthetic.main.fragment_level_selection.*

class LevelSelectionFragment : Fragment(R.layout.fragment_level_selection){
    override fun onResume() {
        super.onResume()
        buttonExit.setOnClickListener { APP_ACTIVITY.finish() }


        val myAdapter = MainAdapter(items, object : MainAdapter.Callback {
            override fun onItemClicked(item: MainItemModel) {
                when(item.id){
                    1-> replaceFragment(GuessByTheSoundFragment())
                    2-> replaceFragment(EdibleGameMainFragment())
                }
            }



        })
        myRecycler.adapter = myAdapter

    }
}


/* override fun onResume() {
        super.onResume()
        button_level_selection_edible.setOnClickListener { replaceFragment(EdibleGameMainFragment(),false) }
        button_guess_by_the_sounds.setOnClickListener { replaceFragment(GuessByTheSoundFragment(),false) }
        buttonExit.setOnClickListener { APP_ACTIVITY.finish() }

}*/

