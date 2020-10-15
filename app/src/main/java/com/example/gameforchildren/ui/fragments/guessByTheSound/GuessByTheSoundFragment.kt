package com.example.gameforchildren.ui.fragments.guessByTheSound

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gameforchildren.activities.MainActivity
import com.example.gameforchildren.R
import com.example.gameforchildren.ui.fragments.LevelSelectionFragment
import com.example.gameforchildren.utilits.*
import com.example.gameforchildren.utilits.Array
import kotlinx.android.synthetic.main.fragment_guess_by_the_sound.*
import java.util.*


class GuessByTheSoundFragment : Fragment(R.layout.fragment_guess_by_the_sound) {
    private val random = Random()
    var imageTop = 0
    var qwe = 0;
    var count = 0
    var imageDown = 0
    var topOrBot: Boolean = false
    private val array = Array()
    private lateinit var mediaPlayer: MediaPlayer

    val alfa =
        AnimationUtils.loadAnimation(APP_ACTIVITY, R.anim.alfa)


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
        /* Log.i("HEEEEREEEEE", topOrBot.toString())*/
        if (topOrBot) {
            imageTop = random.nextInt(2)
            imageViewTop.setImageResource(array.picture[imageTop])
            imageViewTop.startAnimation(alfa)
            mediaPlayer = MediaPlayer.create(APP_ACTIVITY, array.sounds[imageTop])
            mediaPlayer.start()
            imageDown = random.nextInt(2)
            while (imageDown == imageTop) {
                imageDown = random.nextInt(2)
            }
            imageViewDown.setImageResource(array.picture[imageDown])
            imageViewDown.startAnimation(alfa)
            funPoints()
        } else {//false
            imageDown = random.nextInt(2)
            imageViewDown.setImageResource(array.picture[imageDown])
            imageViewDown.startAnimation(alfa)
            mediaPlayer = MediaPlayer.create(APP_ACTIVITY, array.sounds[imageDown])
            mediaPlayer.start()
            imageTop = random.nextInt(2)
            while (imageTop == imageDown) {
                imageTop = random.nextInt(2) //от 0 до 9 рандом
            }
            imageViewTop.setImageResource(array.picture[imageTop])//0
            imageViewTop.startAnimation(alfa)
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
            } else if (event.action == MotionEvent.ACTION_UP) { //отпустил
                if (qwe == 0) {
                    topOrBot = true
                    topOrBot.progressChange(count)
                } else {
                    topOrBot=false
                    topOrBot.progressChange(count)
                }
                //тут проблема
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
        backToMenu.visibility = View.VISIBLE
        imageViewTop.isEnabled = true
        imageViewDown.isEnabled = true
        imageViewTop.visibility = View.VISIBLE
        imageViewDown.visibility = View.VISIBLE
        go.visibility = View.INVISIBLE
    }


}