package com.example.gameforchildren.utilits


import android.media.MediaPlayer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils

import android.widget.ImageView
import android.widget.Toast
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



fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_SHORT).show()
}
fun Boolean.progressChange(count:Int){
    if (this) APP_ACTIVITY.findViewById<ImageView>(progressBarArray[count])?.setImageResource(R.drawable.star)
    else APP_ACTIVITY.findViewById<ImageView>(progressBarArray[count])?.setImageResource(R.drawable.skull)
}


fun mediaPlayerCreate(id: Int){
    MEDIA_PLAYER = MediaPlayer.create(APP_ACTIVITY, id)
    MEDIA_PLAYER.start()
}



fun animation(rId: Int): Animation? {
    return AnimationUtils.loadAnimation(APP_ACTIVITY, rId)
}
fun ImageView.showResult(result: Boolean) {
      this.startAnimation(animation(R.anim.alfa))
    if (result) {
        this.setImageResource(R.drawable.true_photo)
    mediaPlayerCreate(R.raw.true_click)
    } else {
        this.setImageResource(R.drawable.false_photo)
        mediaPlayerCreate(R.raw.false_click)
    }
}
fun clickDelay(item1: ImageView, item2: ImageView, function: () -> Unit) {
    item1.isClickable = false
    item2.isClickable = false
    android.os.Handler().postDelayed({
        item1.isClickable = true
        item2.isClickable = true
        function()
    }, 700)

}
fun ImageView.drawQuestItem(imageId:Int) {
    this.apply {
        this.startAnimation(animation(R.anim.alfa))
        this.setImageResource(imageId)
    }

}
fun MutableList<*>.makeEven(){
    if (this.size%2 != 0)
        this.removeAt((0..this.lastIndex).random())
}