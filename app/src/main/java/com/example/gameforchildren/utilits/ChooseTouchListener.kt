package com.example.gameforchildren.utilits

import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import com.example.gameforchildren.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ChooseTouchListener(
    val ImageView: ImageView,  //принимает вью, по которой кликаешь
    val chooseResult: Boolean, //принимает результат, который ьудет при нажатии на эту кнопку
    val functionOnUp: () -> Unit //функция которую хочешь выполнить при отпускании пальца
) : View.OnTouchListener {


    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {



        when (p1?.action) {
            MotionEvent.ACTION_DOWN -> {
                 action(ImageView)
            }
            MotionEvent.ACTION_UP -> {
                functionOnUp()
            }

        }
        return false
    }

    private fun action(Image: ImageView?) {
        if (chooseResult){
            Image?.setImageResource(R.drawable.true_photo)

        }
        else{
            Image?.setImageResource(R.drawable.false_photo)
        }

    }


}