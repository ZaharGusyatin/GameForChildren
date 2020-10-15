package com.example.gameforchildren.ui.fragments.guessByTheSound

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gameforchildren.MainActivity
import com.example.gameforchildren.R
import com.example.gameforchildren.ui.fragments.LevelSelectionFragment
import com.example.gameforchildren.utilits.APP_ACTIVITY
import com.example.gameforchildren.utilits.Array
import com.example.gameforchildren.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_guess_by_the_sound.*
import java.util.*


class GuessByTheSoundFragment : Fragment(R.layout.fragment_guess_by_the_sound) {
    private val random = Random()
    var imageTop = 0
    var count = 0
    var imageDown = 0
    private var topOrBot = 0
    private val array = Array()
    private lateinit var mediaPlayer: MediaPlayer
    private val progress = intArrayOf(
        R.id.point1,
        R.id.point2,
        R.id.point3,
        R.id.point4,
        R.id.point5,
        R.id.point6,
        R.id.point7,
        R.id.point8,
        R.id.point9,
        R.id.point10,
        R.id.point11,
        R.id.point12,
        R.id.point13,
        R.id.point14,
        R.id.point15,
        R.id.point16,
        R.id.point17,
        R.id.point18,
        R.id.point19,
        R.id.point20
    )

    override fun onResume() {
        super.onResume()
        backToMenu.setOnClickListener {
           replaceFragment(LevelSelectionFragment(), false)
            mediaPlayer.stop()
        }
        APP_ACTIVITY.title = getString(R.string.music)
        go.setOnClickListener {
            visibility()
            randomStart()


        }

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun randomStart() {
        topOrBot = random.nextInt(2)
        Log.i("HEEEEREEEEE", topOrBot.toString())
        if (topOrBot == 0) {
            imageTop = random.nextInt(2)
            imageViewTop.setImageResource(array.picture[imageTop])//0
            mediaPlayer = MediaPlayer.create(APP_ACTIVITY, array.sounds[imageTop])//0
            mediaPlayer.start()
            imageDown = random.nextInt(2)//1
            while (imageDown == imageTop) {
                imageDown = random.nextInt(2) //от 0 до 9 рандом
            }
            imageViewDown.setImageResource(array.picture[imageDown])
            funPoints()
        } else {
            imageDown = random.nextInt(2)//1
            imageViewDown.setImageResource(array.picture[imageDown])//1
            mediaPlayer = MediaPlayer.create(APP_ACTIVITY, array.sounds[imageDown])//1
            mediaPlayer.start()
            imageTop = random.nextInt(2)//0
            while (imageTop == imageDown) {
                imageTop = random.nextInt(2) //от 0 до 9 рандом
            }
            imageViewTop.setImageResource(array.picture[imageTop])//0
            funPoints()
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun funPoints() {
        imageViewTop.setOnTouchListener { v, event ->
            mediaPlayer.stop()
            if (event.action == MotionEvent.ACTION_DOWN) { //коснулся начало
                imageViewDown.isEnabled = false
                if (topOrBot == 0) {

                    imageViewTop.setImageResource(R.drawable.true_photo)
                } else {
                    imageViewTop.setImageResource(R.drawable.false_photo)
                }
            } else if (event.action == MotionEvent.ACTION_UP) { //отпустил
                if (topOrBot == 0) {
                    if (count < 20) {
                        count += 1
                    }

                    for (b in 0..19) {
                        var qwe = (context as MainActivity?)!!.findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.btn_games1_2)
                    }
                    for (b in 0 until count) {
                        var qwe = (context as MainActivity?)!!.findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.points_for_games)
                    }
                } else {
                    if (count > 0) {
                        count = if (count == 1) {
                            0
                        } else {
                            count - 2
                        }
                    }
                    for (b in 0..18) {
                        var qwe = (context as MainActivity?)!!.findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.btn_games1_2)
                    }
                    for (b in 0 until count) {
                        var qwe = (context as MainActivity?)!!.findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.points_for_games)
                    }
                }
                if (count == 20) {
                    //exit here
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
                if (topOrBot == 1) {
                    imageViewDown.setImageResource(R.drawable.true_photo)
                } else {
                    imageViewDown.setImageResource(R.drawable.false_photo)
                }
            } else if (event.action == MotionEvent.ACTION_UP) { //отпустил
                if (topOrBot == 1) {
                    if (count < 20) {
                        count += 1
                    }

                    for (b in 0..19) {
                        var qwe = (context as MainActivity?)!!.findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.btn_games1_2)
                    }
                    for (b in 0 until count) {
                        var qwe = (context as MainActivity?)!!.findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.points_for_games)
                    }
                } else {
                    if (count > 0) {
                        count = if (count == 1) {
                            0
                        } else {
                            count - 2
                        }
                    }
                    for (b in 0..18) {
                        var qwe = (context as MainActivity?)!!.findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.btn_games1_2)
                    }
                    for (b in 0 until count) {
                        var qwe = (context as MainActivity?)!!.findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.points_for_games)
                    }
                }
                if (count == 20) {
                    //Выход из данной игры
                } else {


                    imageViewTop.isEnabled = true
                    randomStart()
                }
            }

            true

        }
    }


    private fun visibility() {
        imageViewTop.isEnabled = true
        imageViewDown.isEnabled = true
        imageViewTop.visibility = View.VISIBLE
        imageViewDown.visibility = View.VISIBLE
        go.visibility = View.INVISIBLE
    }


}