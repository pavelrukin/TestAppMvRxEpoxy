package com.pavelrukin.testappmvrxepoxy.utils

import android.app.Activity
import android.widget.TextView
import android.widget.Toast
import com.pavelrukin.testappmvrxepoxy.R





fun Toast.redToast(message: String, activity: Activity) {
    val layout = activity.layoutInflater.inflate (
        R.layout.custom_toast,
        activity.findViewById(R.id.cl_customToastContainer)
    )

    val textView = layout.findViewById<TextView>(R.id.tv_message)
    textView.text = message

    this.apply {

        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }

}
