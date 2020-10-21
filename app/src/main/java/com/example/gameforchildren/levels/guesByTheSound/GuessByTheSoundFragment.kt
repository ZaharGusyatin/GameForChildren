package com.example.gameforchildren.levels.guesByTheSound

import android.media.MediaPlayer
import android.view.View
import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.ui.fragments.EndLevelFragment
import com.example.gameforchildren.ui.fragments.LevelSelectionFragment
import com.example.gameforchildren.utilits.*
import kotlinx.android.synthetic.main.fragment_guess_by_the_sound.*
import kotlinx.coroutines.*


class GuessByTheSoundFragment(val normal: Boolean) :
    Fragment(R.layout.fragment_guess_by_the_sound) {
    private var topOrBot: Boolean = false
    private lateinit var localMediaPlayer: MediaPlayer

    override fun onResume() {
        super.onResume()
                InitActionActions()
        if (!normal) {
            startTimeGame()
        }
        randomStart()
        initClicklListeners()
    }

    private fun startTimeGame() {
        ROUNDS = 0
        progress_bar1.visibility = View.GONE

         CoroutineScope(Dispatchers.IO).launch {
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

        guesGameTimer.showTimer()
    }

    private fun initClicklListeners() {
        imageViewTop.setOnClickListener {
            if (topOrBot) RESULT = true
            imageViewTop.showResult(RESULT)
            localMediaPlayer.stop()
            resFunc()
        }
        imageViewDown.setOnClickListener {
            if (!topOrBot) RESULT = true
            localMediaPlayer.stop()
            imageViewDown.showResult(RESULT)
            resFunc()
        }
    }

    fun InitActionActions() {
        TRUE_COUNT = 0
        COUNT = 0
        ROUNDS = 10
        fullListEnimals.clear()
        APP_ACTIVITY.title = getString(R.string.music)
        backToMenu.setOnClickListener {
            replaceFragment(LevelSelectionFragment(), false)
        }
    }

    private fun randomStart() {
        catch{
        RESULT = false
        updateListOfcurrentEnimals()
        imageViewTop.drawQuestItem(currentQuestEnimals[0].image)
        imageViewDown.drawQuestItem(currentQuestEnimals[1].image)
        topOrBot = random.nextBoolean()
        localMediaPlayer = MediaPlayer.create(
            APP_ACTIVITY,
            if (topOrBot) currentQuestEnimals[0].raw else currentQuestEnimals[1].raw
        )
        localMediaPlayer.start()}
    }

    private fun resFunc() {
        localMediaPlayer.stop()
        COUNT++
        if (RESULT) TRUE_COUNT++
if (normal)
{RESULT.progressChange(COUNT-1)
                clickDelay(imageViewTop, imageViewDown) {
            if (COUNT != ROUNDS) {
                randomStart()
            } else {
                replaceFragment(
                    EndLevelFragment(
                        TRUE_COUNT,
                        ROUNDS,
                        GuessByTheSoundFragment(RESULT)
                    )
                )
            }
        }}
        else{
   ROUNDS++
    clickDelay(imageViewTop, imageViewDown) {randomStart()}
}
    }


    override fun onPause() {

        super.onPause()
        localMediaPlayer.stop()
        MEDIA_PLAYER.stop()
    }

}