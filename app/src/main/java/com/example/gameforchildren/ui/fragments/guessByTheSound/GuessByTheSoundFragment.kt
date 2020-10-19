package com.example.gameforchildren.ui.fragments.guessByTheSound

import android.media.MediaPlayer
import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.ui.fragments.EndLevelFragment
import com.example.gameforchildren.ui.fragments.LevelSelectionFragment
import com.example.gameforchildren.utilits.*
import kotlinx.android.synthetic.main.fragment_guess_by_the_sound.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*


class GuessByTheSoundFragment : Fragment(R.layout.fragment_guess_by_the_sound) {

    private val random = Random()
    var result = false
    private var rounds = 10
    private var count = 0
    private var trueCount = 0
    private var topOrBot: Boolean = false
    private lateinit var localMediaPlayer: MediaPlayer

    override fun onResume() {
        super.onResume()
        InitActionActions()
        initListOfEnimals()
        randomStart()
        initClicklListeners()
    }

    private fun initClicklListeners() {
        imageViewTop.setOnClickListener {
            if (topOrBot) result = true
            imageViewTop.showResult(result)
            localMediaPlayer.stop()
            resFunc()
        }
        imageViewDown.setOnClickListener {
            if (!topOrBot) result = true
            localMediaPlayer.stop()
            imageViewDown.showResult(result)
            resFunc()
        }
    }

    fun InitActionActions() {
        fullListEnimals.clear()
        APP_ACTIVITY.title = getString(R.string.music)
        backToMenu.setOnClickListener {
            replaceFragment(LevelSelectionFragment(), false)
        }
    }

    private fun randomStart() {
        result = false
        updateListOfcurrentEnimals()
        imageViewTop.drawQuestItem(currentQuestEnimals[0].image)
        imageViewDown.drawQuestItem(currentQuestEnimals[1].image)
        topOrBot = random.nextBoolean()
        localMediaPlayer = MediaPlayer.create(
            APP_ACTIVITY,
            if (topOrBot) currentQuestEnimals[0].raw else currentQuestEnimals[1].raw
        )
        localMediaPlayer.start()
    }

    private fun resFunc() {
        localMediaPlayer.stop()
        result.progressChange(count)
        if (result) trueCount++
        count++
        clickDelay(imageViewTop, imageViewDown) {
            if (count != rounds) {
                randomStart()
            } else {
                replaceFragment(EndLevelFragment(trueCount, rounds, GuessByTheSoundFragment()))
            }
        }
    }


    override fun onPause() {
        super.onPause()
        localMediaPlayer.stop()
        MEDIA_PLAYER.stop()
    }

}