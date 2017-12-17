package io.daio.lifecycleapplication

import android.app.Application
import android.util.Log

// Create a custom appication class extending from Application
// and implementing the LifeCycleDelegate interface
// Remember to set the name of your application to you custom Application class in your manifest
// <application
//   android:name=".App"
//    ....
class App : Application(), LifeCycleDelegate {

    override fun onCreate() {
        super.onCreate()
        val lifeCycleHandler = AppLifecycleHandler(this)
        registerLifecycleHandler(lifeCycleHandler)
    }

    override fun onAppBackgrounded() {
        Log.d("Awww", "App in background")
    }

    override fun onAppForegrounded() {
        Log.d("Yeeey", "App in foreground")
    }

    private fun registerLifecycleHandler(lifeCycleHandler: AppLifecycleHandler) {
        registerActivityLifecycleCallbacks(lifeCycleHandler)
        registerComponentCallbacks(lifeCycleHandler)
    }

}