package com.example.gameforchildren.utilits


import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.Toast

import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import java.util.logging.Handler

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
