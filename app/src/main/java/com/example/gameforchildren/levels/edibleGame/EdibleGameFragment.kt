package com.example.gameforchildren.levels.edibleGame

import android.view.View
import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.model.FoodModel
import com.example.gameforchildren.ui.fragments.EndLevelFragment
import com.example.gameforchildren.ui.fragments.LevelSelectionFragment
import com.example.gameforchildren.utilits.*
import kotlinx.android.synthetic.main.fragment_edible_game_question.*
import kotlinx.android.synthetic.main.timer.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main


class EdibleGameFragment(val normal: Boolean) : Fragment(R.layout.fragment_edible_game_question) {

    private var trueCount = 0
    private var rounds = 10
    private var count = 0
    private var result: Boolean = false
    private lateinit var items: List<FoodModel>
    private lateinit var job:Job
    override fun onResume() {
        super.onResume()

        initBaseActions()
        if (!normal) addTimer()
        initClickers()
        initFood()
        drawNewQuest()

    }

    private fun addTimer() {
       progress_bar2.visibility = View.GONE
      job.start()
       edibleTimer.showTimer()


    }


    private fun initClickers() {

        edibleImageFirstItem.setOnClickListener {
            result = items[0].edible
            edibleImageFirstItem.showResult(result)
            resultFunc()
        }
        ediableImageSecondItem.setOnClickListener {
            result = items[1].edible
            ediableImageSecondItem.showResult(result)
            resultFunc()
        }
    }

    private fun initBaseActions() {
        progress_bar2.visibility = View.VISIBLE
        button_back_to_menu_from_edible.setOnClickListener {
            replaceFragment(LevelSelectionFragment(), false)
        }
        APP_ACTIVITY.title = getString(R.string.EdibleGameTitle)
        job = CoroutineScope(IO).launch {
            rounds = 0

            delay(GAME_TIME)
            replaceFragment(EndLevelFragment(trueCount, rounds, EdibleGameFragment(normal))) //тут баг. пока хз как фиксить
        cancel()
        }

    }

    private fun resultFunc() {
        count++
        if (result) trueCount++

        if (normal) {
            result.progressChange(count - 1)
            clickDelay(ediableImageSecondItem, edibleImageFirstItem) {
                if (count != rounds) {
                    drawNewQuest()
                } else {
                    replaceFragment(EndLevelFragment(trueCount, rounds, EdibleGameFragment(normal)))
                }
            }
        } else {
            rounds++
            clickDelay(ediableImageSecondItem, edibleImageFirstItem) { drawNewQuest() }
        }
    }

    private fun drawNewQuest() {
        result = false
        items = getRandomFood()
        ediableImageSecondItem.drawQuestItem(items[1].image)
        edibleImageFirstItem.drawQuestItem(items[0].image)
        edibleFirstItemName.text = items[0].name
        edibleSecondItemName.text = items[1].name

    }


}















