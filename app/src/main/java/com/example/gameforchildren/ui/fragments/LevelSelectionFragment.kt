package com.example.gameforchildren.ui.fragments

import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.adapters.MainAdapter
import com.example.gameforchildren.levels.edibleGame.EdiableDescriptionFragment
import com.example.gameforchildren.levels.guesByTheSound.GuesDescriptionFragment
import com.example.gameforchildren.model.MainItemModel
import com.example.gameforchildren.levels.guesByTheSound.GuessByTheSoundFragment
import com.example.gameforchildren.ui.Transformers.ZoomOutPageTransformer
import com.example.gameforchildren.utilits.*
import kotlinx.android.synthetic.main.fragment_level_selection.*

class LevelSelectionFragment : Fragment(R.layout.fragment_level_selection){
    override fun onResume() {
        super.onResume()
        buttonExit.setOnClickListener { APP_ACTIVITY.finish() }
        val myAdapter = MainAdapter(items, object : MainAdapter.Callback {
            override fun onItemClicked(item: MainItemModel) {
                when(item.id){
                    1-> replaceFragment(GuesDescriptionFragment())
                    2-> replaceFragment(EdiableDescriptionFragment())
                }
            }

        })
levelSelectionViewPager.setPageTransformer(ZoomOutPageTransformer()) //почекай вторую анимацию я в них вообще не секу, тут надо думать
   levelSelectionViewPager.adapter = myAdapter
worm_dots_indicator.setViewPager2(levelSelectionViewPager)
    }


}



