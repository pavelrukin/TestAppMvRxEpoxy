package com.pavelrukin.testappmvrxepoxy.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CurrentTimeRepository @Inject constructor(){


/*    fun getCurrentTime(data:String): Flow<String> = flow {
        val dateFormat = SimpleDateFormat(data)
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val today = Calendar.getInstance().time
        emit(dateFormat.format(today))
        Log.d("repository", "getCurrentDate: ${dateFormat.format(today)}")
    }   */

    fun getCurrentTime(data:String): Flow<String> = flow {
        val sdf = SimpleDateFormat(data)
        val currentDate = sdf.format(Date())
        emit(currentDate)
        Log.d("repository", "getCurrentDate: ${currentDate}")
    }
}
