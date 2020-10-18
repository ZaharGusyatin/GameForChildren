package com.example.gameforchildren.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gameforchildren.R
import com.example.gameforchildren.utilits.APP_ACTIVITY
import com.example.gameforchildren.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_end_level.*

class EndLevelFragment(val result: Int, val rounds: Int, val currentGameFragment: Fragment) :
    Fragment(R.layout.fragment_end_level) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Уровень пройлден"
        resultText.text = "Вы ответили правильно на $result из $rounds вопросов"
        resultFragmentBtnStartAgain.setOnClickListener { replaceFragment(currentGameFragment) }
        resultFragmentGameBtnChooseLevel.setOnClickListener { replaceFragment(LevelSelectionFragment()) }
    }
}



