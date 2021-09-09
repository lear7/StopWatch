package org.koin.sample

import com.lear7.stopwatch.viewmodel.MyViewModel
import com.lear7.stopwatch.viewmodel.TimeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // single instance of HelloRepository
    single<HelloRepository> { HelloRepositoryImpl() }

    // MyViewModel ViewModel
    viewModel { MyViewModel(get()) }
    viewModel { TimeViewModel() }
}