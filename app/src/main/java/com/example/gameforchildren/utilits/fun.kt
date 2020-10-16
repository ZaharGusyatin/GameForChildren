package com.example.gameforchildren.utilits


import EdibleGameQuestionFragment
import android.app.AlertDialog

import android.media.MediaPlayer
import android.view.View

import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

import com.example.gameforchildren.R

import com.example.gameforchildren.ui.fragments.LevelSelectionFragment



fun replaceFragment(fragment: Fragment, addStack: Boolean = true) {
    if (addStack) {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.dataContainer,
                fragment
            ).commit()
    } else {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .replace(
                R.id.dataContainer,
                fragment
            ).commit()
    }


}



fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_SHORT).show()
}
fun Boolean.progressChange(count:Int){
    if (this) APP_ACTIVITY.findViewById<ImageView>(progressBarArray[count])?.setImageResource(R.drawable.star)
    else APP_ACTIVITY.findViewById<ImageView>(progressBarArray[count])?.setImageResource(R.drawable.skull)
}
 ChooseOnTouchUpdate

 fun endLevel(trueCount: Int, rounds: Int) {
    val builder = AlertDialog.Builder(APP_ACTIVITY)
    builder.setTitle("Игра окончена")
        .setMessage("Вы ответили на  $trueCount из $rounds правильно. Вы молодец и бла бла бла")
        .setPositiveButton("Начать снова") { dialogInterface, i ->
            replaceFragment(
                EdibleGameQuestionFragment()
            )
        }
        .setNeutralButton("Вернуться к выбору игры") { dialogInterface, i ->
            replaceFragment(
                LevelSelectionFragment()
            )
        }
        .show()
}

fun mediaPlayerCreate(id: Int){
    mediaPlayer = MediaPlayer.create(APP_ACTIVITY, id)
    mediaPlayer.start()

}

fun visible(view: View) {
    view.visibility = View.VISIBLE
}
fun invisible(view: View) {
    view.visibility = View.INVISIBLE
}

