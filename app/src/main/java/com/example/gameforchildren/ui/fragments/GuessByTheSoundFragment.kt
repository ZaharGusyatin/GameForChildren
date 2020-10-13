package com.example.gameforchildren.ui.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.gameforchildren.R
import com.example.gameforchildren.databinding.ActivityMainBinding
import com.example.gameforchildren.utilits.APP_ACTIVITY
import com.example.gameforchildren.utilits.Array
import com.example.gameforchildren.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_guess_by_the_sound.*
import kotlinx.android.synthetic.main.fragment_start_screen_fragment.*
import java.util.*

class GuessByTheSoundFragment : Fragment(R.layout.fragment_guess_by_the_sound) {
    val random = Random()
    var imageTop = 0
    var count = 0
    val progress = intArrayOf(
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
    var imageDown = 0
    val b=random.nextInt(2)
    val array = Array()
    private lateinit var mediaPlayer: MediaPlayer
    override fun onResume() {
        super.onResume()



        go.setOnClickListener {
            visibility()
            randomStart()
            mediaPlayer.start()
            //рандом вкл
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun randomStart() {
        if (b==0) {
            imageTop = random.nextInt(2)
            imageViewTop.setImageResource(array.picture[imageTop])
            mediaPlayer = MediaPlayer.create(APP_ACTIVITY, array.sounds[imageTop])
            mediaPlayer.start()
            imageDown = random.nextInt(2)
            while (imageTop == imageDown) {
                imageDown = random.nextInt(2) //от 0 до 9 рандом
            }
            imageViewDown.setImageResource(array.picture[imageDown])
            funPoints()
        }else{
            imageDown = random.nextInt(2)
            imageViewDown.setImageResource(array.picture[imageDown])
            mediaPlayer = MediaPlayer.create(APP_ACTIVITY, array.sounds[imageDown])
            mediaPlayer.start()
            imageTop = random.nextInt(2)
            while (imageTop == imageDown) {
                imageTop = random.nextInt(2) //от 0 до 9 рандом
            }
            imageViewTop.setImageResource(array.picture[imageTop])
            funPoints()
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun funPoints() {
        imageViewTop.setOnTouchListener(View.OnTouchListener { v, event ->
           mediaPlayer.stop()
            if (event.action == MotionEvent.ACTION_DOWN) { //коснулся начало
                imageViewDown.isEnabled = false
                if (b==0) {
                 /*   imageViewTop.setImageResource(R.drawable.img_true)*/
                } else {
                  /*  imageViewTop.setImageResource(R.drawable.img_wrong)*/
                }
            } else if (event.action == MotionEvent.ACTION_UP) { //отпустил
                if (b==0) {
                    if (count < 20) {
                        count += 1
                    }
                   /* for (b in 0..19) {
                        val qwe = findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.btn_games1_2)
                    }
                    for (b in 0 until count) {
                        val qwe = findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.points_for_games)
                    }*/
                } else { //если 1
                    if (count > 0) { // больше нкля
                        count = if (count == 1) {
                            0
                        } else {
                            count - 2
                        }
                    }
                  /*  for (b in 0..18) {
                        val qwe = findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.btn_games1_2)
                    }
                    for (b in 0 until count) {
                        val qwe = findViewById<TextView>(progress[b])
                        qwe.setBackgroundResource(R.drawable.points_for_games)
                    }*/
                }
                if (count == 20) {
                 /*   startActivity(Intent(this, Level2::class.java))
                    finish()*/
                } else {
                    randomStart()
                    imageViewDown.isEnabled = true
                }
            }
            true
        })
    }

    private fun visibility() {
        imageViewTop.isEnabled=true
        imageViewDown.isEnabled=true
        imageViewTop.visibility = View.VISIBLE
        imageViewDown.visibility = View.VISIBLE
        go.visibility = View.INVISIBLE
    }


}