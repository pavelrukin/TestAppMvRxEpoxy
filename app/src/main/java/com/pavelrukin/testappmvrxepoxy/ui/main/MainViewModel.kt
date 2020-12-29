package com.pavelrukin.testappmvrxepoxy.ui.main

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.Uninitialized
import com.pavelrukin.testappmvrxepoxy.di.AssistedViewModelFactory
import com.pavelrukin.testappmvrxepoxy.di.DaggerMavericksViewModelFactory
import com.pavelrukin.testappmvrxepoxy.repository.CurrentTimeRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

data class CurrentTimeState(val getCurrentTimeTextView: Async<String> = Uninitialized, val getCurrentTimeToast:Async<String> = Uninitialized) : MavericksState
class MainViewModel
@AssistedInject constructor(
    @Assisted state: CurrentTimeState,
    private val repository: CurrentTimeRepository
) : MavericksViewModel<CurrentTimeState>(state) {

init {
    getCurrentDateWithText()
    getCurrentDate()
}
    fun getCurrentDate( ) {
        repository.getCurrentTime("HH\nmm\nss").execute { copy(getCurrentTimeTextView = it ) }
    }


    fun getCurrentDateWithText( ) {
        repository.getCurrentTime("HH:mm:ss").execute { copy(getCurrentTimeToast = it ) }
    }





    @AssistedInject.Factory
    interface Factory : AssistedViewModelFactory<MainViewModel, CurrentTimeState> {
        override fun create(state: CurrentTimeState): MainViewModel
    }

    companion object :
        DaggerMavericksViewModelFactory<MainViewModel, CurrentTimeState>(MainViewModel::class.java)
}