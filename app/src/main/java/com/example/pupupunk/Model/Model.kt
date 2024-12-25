package com.example.pupupunk.Model

import java.util.Calendar
import kotlin.math.abs

class Model {
    fun checkDataAndTimeCorrect(date: String, time: String): Boolean{
        val arrDate = date.split('.')
        val arrTime = time.split(':')
        return arrDate.size == 3 && arrDate[0].length <= 2 && arrDate[1].length <= 2 && arrDate[2].length == 2 &&
                arrTime.size == 2 && arrTime[0].length <= 2 && arrTime[1].length <= 2 && arrDate[2].toInt() >= 24 &&
                arrDate[0].toInt() > 0 && arrDate[0].toInt() < 32 && arrDate[1].toInt() > 0 && arrDate[1].toInt() < 13 &&
                arrTime[0].toInt() >= 0 && arrTime[0].toInt() < 24 && arrTime[1].toInt() >= 0 && arrTime[1].toInt() < 60 && arrDate[0].toInt() >= Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    }

    fun checkTimeOut(itemActivity: ItemActivity): Boolean{
        val minutPerDay = 24 * 60
        val activityCreationTime = timeAndDateToInt(itemActivity.date, itemActivity.time) / minutPerDay
        val timeOut = (((Calendar.getInstance().get(Calendar.YEAR) % 100 - 24) * 365 + Calendar.getInstance().get(Calendar.DAY_OF_YEAR)  + 7))
        return abs(timeOut - activityCreationTime)  > 7

    }

    fun timeAndDateToInt(date: String, time: String): Int{
        val arrDate = date.split('.')
        val arrTime = time.split(':')
        val intTime = ((arrDate[0].toInt() + (arrDate[1].toInt() - 1) * 31
                + (arrDate[2].toInt() - 24) * 365) * 24 * 60)  + arrTime[0].toInt() * 60 + arrTime[1].toInt()

        return intTime
    }
}