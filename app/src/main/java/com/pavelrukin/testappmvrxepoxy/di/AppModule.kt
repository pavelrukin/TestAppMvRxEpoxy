package com.pavelrukin.testappmvrxepoxy.di

import com.pavelrukin.testappmvrxepoxy.ui.main.MainViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@AssistedModule
@Module(includes = [AssistedInject_AppModule::class])
interface AppModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun mainViewModelFactory(factory: MainViewModel.Factory): AssistedViewModelFactory<*, *>
}
