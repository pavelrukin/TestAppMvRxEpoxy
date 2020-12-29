package com.pavelrukin.testappmvrxepoxy

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.airbnb.mvrx.Mavericks
import com.pavelrukin.testappmvrxepoxy.di.AppComponent
import com.pavelrukin.testappmvrxepoxy.di.DaggerAppComponent


class TestAppMvRxEpoxyApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        Mavericks.initialize(this)
    }
}

fun FragmentActivity.appComponent(): AppComponent {
    return (application as TestAppMvRxEpoxyApplication).appComponent
}
