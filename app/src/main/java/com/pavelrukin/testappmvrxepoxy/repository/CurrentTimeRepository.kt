package com.pavelrukin.testappmvrxepoxy.repository


import android.content.Context
import com.pavelrukin.testappmvrxepoxy.R
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class CurrentTimeRepository @Inject constructor() {

    suspend fun getCurrentTime(context: Context) = flow {
        val hour = (Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
        val minute = (Calendar.getInstance().get(Calendar.MINUTE))
        val seconds = (Calendar.getInstance().get(Calendar.SECOND))

       var textHour: String? = null
        when (hour) {
            1, 21 -> textHour = context.getString(R.string.hour_single)
            in 2..4, in 22..24 -> textHour = context.getString(R.string.hours_from_two_to_four)
            in 5..20 -> textHour = context.getString(R.string.hours_many)
        }
        var textMinute: String? = null
        when (minute) {
            1, 21,31,41,51 -> textMinute = context.getString(R.string.minute_single)
            in 2..4, in 22..24,in 32..34,in 42..44,in 52..54 -> textMinute = context.getString(R.string.minutes_from_two_to_four)
            in 5..20, in 25..30, in 35..40, in 45..50, in 55..60 -> textMinute = context.getString(R.string.minutes_many)
        }
         var textSecond: String? = null
        when (seconds) {
            1, 21,31,41,51 -> textSecond = context.getString(R.string.second_single)
            in 2..4, in 22..24,in 32..34,in 42..44,in 52..54 -> textSecond = context.getString(R.string.seconds_from_two_to_four)
            in 5..20, in 25..30, in 35..40, in 45..50, in 55..60, 0 -> textSecond = context.getString(R.string.seconds_many)
        }
        val result = "$hour $textHour \n$minute $textMinute \n$seconds $textSecond"

        emit(result)
    }

    fun getCurrentTimeToast(): String {
        val hour = (Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
        val minute = (Calendar.getInstance().get(Calendar.MINUTE))
        val seconds = (Calendar.getInstance().get(Calendar.SECOND))
        val result = "$hour:$minute:$seconds"
        return result
    }

}
