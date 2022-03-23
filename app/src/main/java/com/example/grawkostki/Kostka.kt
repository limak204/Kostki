package com.example.grawkostki

import java.util.*
class Kostka(val numSides:Int=6) {
    fun roll(isRangesRandom:Boolean=true):Int{
        if(isRangesRandom){
            return(1..numSides).random()
        }
        else{
            return Random().nextInt(numSides)+1
        }
    }


}