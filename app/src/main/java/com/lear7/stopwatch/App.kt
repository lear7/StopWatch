package com.lear7.stopwatch

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.sample.appModule

/**
@author Lear
@description
@date 2019/12/27 14:01
 */
class App : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger()
            // 加载的模块
            modules(appModule)
        }
    }
}