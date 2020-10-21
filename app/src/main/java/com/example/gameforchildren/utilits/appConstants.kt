package com.example.gameforchildren.utilits

import android.media.MediaPlayer
import com.example.gameforchildren.activities.MainActivity
import com.example.gameforchildren.R
import com.example.gameforchildren.model.FoodModel
import com.example.gameforchildren.model.MainItemModel
import java.util.*
var RESULT: Boolean = false
var ROUNDS = 10
var COUNT = 0
var TRUE_COUNT = 0

lateinit var APP_ACTIVITY: MainActivity
lateinit  var MEDIA_PLAYER: MediaPlayer
const val GAME_TIME = 15100L
val random = Random()




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
val items = listOf(
    MainItemModel(R.drawable.catt, "lvl1",1),
    MainItemModel(R.drawable.false_photo, "lvl2",2),
    MainItemModel(R.drawable.lionn, "lvl3",3),
    MainItemModel(R.drawable.kirpich, "lvl4",4),
    MainItemModel(R.drawable.llidan, "lvl5",5),
    MainItemModel(R.drawable.morg, "lv6",6),
    MainItemModel(R.drawable.sobaka, "lvl7",7)
)









