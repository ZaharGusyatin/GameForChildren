package com.example.gameforchildren.utilits

import android.app.Activity
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.gameforchildren.R

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
fun Boolean.progressChange(count:Int){
    if (this) APP_ACTIVITY.findViewById<ImageView>(progressBarArray[count])?.setImageResource(R.drawable.star)
    else APP_ACTIVITY.findViewById<ImageView>(progressBarArray[count])?.setImageResource(R.drawable.skull)
}