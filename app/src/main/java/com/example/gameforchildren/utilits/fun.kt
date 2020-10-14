package com.example.gameforchildren.utilits

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
fun replaceEdibleGameFragment(fragment: Fragment){
    APP_ACTIVITY.supportFragmentManager
        .beginTransaction()
        .replace(R.id.edibleGameContainer,fragment)
        .commit()
}