package com.example.gameforchildren.utilits

import com.example.gameforchildren.R
import com.example.gameforchildren.model.EnimalModel
var ENIMAL_ARRAY = EnimalArray()

var fullListEnimals:MutableList<EnimalModel> = mutableListOf()
var currentQuestEnimals:MutableList<EnimalModel> =  mutableListOf()
class EnimalArray {
    val picture = intArrayOf(
        R.drawable.lionn,
        R.drawable.catt,
        R.drawable.morg,
        R.drawable.sobaka,
        R.drawable.llidan

    )
    val sounds = intArrayOf(
        R.raw.lion,
        R.raw.cat,
        R.raw.petuh,
        R.raw.lai,
        R.raw.u_are_not
    )
}
fun initListOfEnimals() {
    ENIMAL_ARRAY.picture.forEachIndexed { index, i ->
        fullListEnimals.add(EnimalModel(ENIMAL_ARRAY.picture[index], ENIMAL_ARRAY.sounds[index]))}
    fullListEnimals.makeEven()


}
fun  updateListOfcurrentEnimals(){
  currentQuestEnimals.clear()
    repeat(2){
   if (fullListEnimals.isEmpty()) initListOfEnimals()
        val randomPosition =  (0..fullListEnimals.lastIndex).random()
   currentQuestEnimals.add(fullListEnimals[randomPosition])
    fullListEnimals.removeAt(randomPosition)}
println()
}