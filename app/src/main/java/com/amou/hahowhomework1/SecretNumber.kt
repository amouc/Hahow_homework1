package com.amou.hahowhomework1

import java.util.*

class SecretNumber{
    var count =0
    var secret = Random().nextInt(10)+1

    fun validate(number :Int):Int{
        count++
        return number - secret
    }

    fun reset(){
        secret = Random().nextInt(10)+1
        count = 0
    }

}