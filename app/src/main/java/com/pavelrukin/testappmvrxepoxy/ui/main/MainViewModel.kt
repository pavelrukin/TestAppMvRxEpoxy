package com.pavelrukin.testappmvrxepoxy.ui.main

import android.content.Context
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.Uninitialized
import com.pavelrukin.testappmvrxepoxy.di.AssistedViewModelFactory
import com.pavelrukin.testappmvrxepoxy.di.DaggerMavericksViewModelFactory
import com.pavelrukin.testappmvrxepoxy.repository.CurrentTimeRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


data class CurrentTimeState(
    val getCurrentTimeTextView: Async<String?> = Uninitialized
) : MavericksState

class MainViewModel
@AssistedInject constructor(
    @Assisted state: CurrentTimeState,
    private val repository: CurrentTimeRepository
) : MavericksViewModel<CurrentTimeState>(initialState = state) {

    fun getCurrentTimeToast() = repository.getCurrentTimeToast()

    fun getCurrentTimeTextView(context: Context) = viewModelScope.launch {
        delay(1100)
        repository.getCurrentTime(context).execute() { copy(getCurrentTimeTextView = it) }

    }

    @AssistedInject.Factory
    interface Factory : AssistedViewModelFactory<MainViewModel, CurrentTimeState> {
        override fun create(state: CurrentTimeState): MainViewModel
    }

    companion object :
        DaggerMavericksViewModelFactory<MainViewModel, CurrentTimeState>(MainViewModel::class.java)
}