package com.example.gameforchildren.utilits

import android.media.MediaPlayer
import android.view.animation.AnimationUtils
import com.example.gameforchildren.activities.MainActivity
import com.example.gameforchildren.R

lateinit var APP_ACTIVITY: MainActivity
lateinit var mediaPlayer: MediaPlayer
val alfa =
    AnimationUtils.loadAnimation(APP_ACTIVITY, R.anim.alfa)

class Array {
    val picture = intArrayOf(
        R.drawable.lionn,
        R.drawable.catt
    /*    R.drawable.number0,*/
    /*    R.drawable.number1,*/
    /*    R.drawable.number2,*/
    /*    R.drawable.number3,*/
    /*    R.drawable.number4,*/
    /*    R.drawable.number5,*/
    /*    R.drawable.number6,*/
    /*    R.drawable.number7,*/
    /*    R.drawable.number8,*/
    /*    R.drawable.number9*/
    )
    val sounds= intArrayOf(
        R.raw.lion,
        R.raw.cat
    )

}
val progressBarArray = intArrayOf(
    R.id.point1,
    R.id.point2,
    R.id.point3,
    R.id.point4,
    R.id.point5,
    R.id.point6,
    R.id.point7,
    R.id.point8,
    R.id.point9,
    R.id.point10
)




