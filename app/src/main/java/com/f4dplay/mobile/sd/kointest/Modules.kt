package com.f4dplay.mobile.sd.kointest

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { MainRepository() }
    viewModel { MainViewModel(get()) }
}
