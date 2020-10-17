package com.example.gameforchildren.ui.fragments.guessByTheSound

import android.annotation.SuppressLint
import android.util.Log
import android.view.MotionEvent
import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.ui.fragments.LevelSelectionFragment
import com.example.gameforchildren.utilits.*
import com.example.gameforchildren.utilits.Array
import kotlinx.android.synthetic.main.fragment_guess_by_the_sound.*
import java.util.*


class GuessByTheSoundFragment : Fragment(R.layout.fragment_guess_by_the_sound) {
    private val random = Random()
    var imageTop = 0
    var qwe = 0
    var count = 0
    var imageDown = 0
    var topOrBot: Boolean = false
    private val array = Array()



    override fun onResume() {
        super.onResume()
        backToMenu.setOnClickListener {
            mediaPlayer.stop()
            replaceFragment(LevelSelectionFragment(), false)
        }
        APP_ACTIVITY.title = getString(R.string.music)
        go.setOnClickListener {
            visibility()
            randomStart()

        }

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun randomStart() {
        topOrBot = random.nextBoolean()
        if (topOrBot) {
            imageTop = random.nextInt(2)
            imageViewTop.setImageResource(array.picture[imageTop])
            imageViewTop.startAnimation(animation(R.anim.alfa))
            mediaPlayerCreate(array.sounds[imageTop])
            imageDown = random.nextInt(2)
            while (imageDown == imageTop) {
                imageDown = random.nextInt(2)
            }
            imageViewDown.setImageResource(array.picture[imageDown])
            imageViewDown.startAnimation(animation(R.anim.alfa))
            funPoints()
        } else {
            imageDown = random.nextInt(2)
            imageViewDown.setImageResource(array.picture[imageDown])
            imageViewDown.startAnimation(animation(R.anim.alfa))
            mediaPlayerCreate(array.sounds[imageDown])
            imageTop = random.nextInt(2)
            while (imageTop == imageDown) {
                imageTop = random.nextInt(2)
            }
            imageViewTop.setImageResource(array.picture[imageTop])
            imageViewTop.startAnimation(animation(R.anim.beta))
            funPoints()
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun funPoints() {
        Log.i(topOrBot.toString(), "hru")
        Log.i(imageTop.toString(), "hru")
        Log.i(imageDown.toString(), "hru")
        imageViewTop.setOnTouchListener { v, event ->
            mediaPlayer.stop()
            if (event.action == MotionEvent.ACTION_DOWN) { //коснулся начало
                imageViewDown.isEnabled = false
                if (topOrBot) {

                    imageViewTop.setImageResource(R.drawable.true_photo)
                } else {
                    imageViewTop.setImageResource(R.drawable.false_photo)
                }
            } else if (event.action == MotionEvent.ACTION_UP) { //отпустил

                topOrBot.progressChange(count)
                count += 1

                if (count == 10) {
                    mediaPlayer.stop()
                    replaceFragment(LevelSelectionFragment(), false)
                } else {


                    imageViewDown.isEnabled = true
                    randomStart()
                }
            }
            true

        }
        imageViewDown.setOnTouchListener { v, event ->
            mediaPlayer.stop()
            if (event.action == MotionEvent.ACTION_DOWN) { //коснулся начало
                imageViewTop.isEnabled = false
                if (!topOrBot) {
                    imageViewDown.setImageResource(R.drawable.true_photo)
                    qwe = 0
                } else {
                    imageViewDown.setImageResource(R.drawable.false_photo)
                    qwe = 1
                }
            } else if (event.action == MotionEvent.ACTION_UP) {
                if (qwe == 0) {
                    topOrBot = true
                    topOrBot.progressChange(count)
                } else {
                    topOrBot = false
                    topOrBot.progressChange(count)
                }
                count += 1
                if (count == 10) {
                    mediaPlayer.stop()
                    replaceFragment(LevelSelectionFragment(), false)
                } else {
                    imageViewTop.isEnabled = true
                    randomStart()
                }
            }
            true

        }
    }


    private fun visibility() {
        visible(backToMenu)
        visible(imageViewTop)
        visible(imageViewDown)
        invisible(go)
        imageViewTop.isEnabled = true
        imageViewDown.isEnabled = true

    }


}