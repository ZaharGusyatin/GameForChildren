package com.example.gameforchildren.levels.edibleGame

import android.view.View
import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.levels.guesByTheSound.GuessByTheSoundFragment
import com.example.gameforchildren.model.FoodModel
import com.example.gameforchildren.ui.fragments.EndLevelFragment
import com.example.gameforchildren.ui.fragments.LevelSelectionFragment
import com.example.gameforchildren.utilits.*
import kotlinx.android.synthetic.main.fragment_edible_game_question.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO


class EdibleGameFragment(val normal: Boolean) : Fragment(R.layout.fragment_edible_game_question) {




    override fun onResume() {
        super.onResume()
        initBaseActions()
        if (!normal) addTimer()
        initClickers()
        drawNewQuest()
    }

    private fun addTimer() {
        CoroutineScope(IO).launch {
            ROUNDS = 0
            delay(GAME_TIME)
            replaceFragment(
                EndLevelFragment(
                    TRUE_COUNT,
                    ROUNDS,
                    GuessByTheSoundFragment(normal)
                )
            )
            cancel()
        }
       progress_bar2.visibility = View.GONE
            edibleTimer.showTimer()
    }


    private fun initClickers() {
        edibleImageFirstItem.setOnClickListener {
            RESULT = edibleItems[0].edible
            edibleImageFirstItem.showResult(RESULT)
            resultFunc()
        }
        ediableImageSecondItem.setOnClickListener {
            RESULT = edibleItems[1].edible
            ediableImageSecondItem.showResult(RESULT)
            resultFunc()
        }
    }

    private fun initBaseActions() {
        TRUE_COUNT = 0
        COUNT = 0
        ROUNDS = 10
        progress_bar2.visibility = View.VISIBLE
        button_back_to_menu_from_edible.setOnClickListener {
            replaceFragment(LevelSelectionFragment(), false)
        }
        APP_ACTIVITY.title = getString(R.string.EdibleGameTitle)

    }

    private fun resultFunc() {
        COUNT++
        if (RESULT) TRUE_COUNT++
        if (normal) {
            RESULT.progressChange(COUNT - 1)
            clickDelay(ediableImageSecondItem, edibleImageFirstItem) {
                if (COUNT != ROUNDS) {
                    drawNewQuest()
                } else {
                    replaceFragment(EndLevelFragment(TRUE_COUNT, ROUNDS, EdibleGameFragment(normal)))
                }
            }
        } else {
            ROUNDS++
            clickDelay(ediableImageSecondItem, edibleImageFirstItem) { drawNewQuest() }
        }
    }

    private fun drawNewQuest() {
       catch{RESULT = false
           edibleItems = getRandomFood()
           ediableImageSecondItem.drawQuestItem(edibleItems[1].image)
           edibleImageFirstItem.drawQuestItem(edibleItems[0].image)
           edibleFirstItemName.text = edibleItems[0].name
           edibleSecondItemName.text = edibleItems[1].name}


    }


}















