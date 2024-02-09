package com.example.studprjck

import android.util.Patterns
import android.widget.Toast

/**
 * MVVM - ViewModel
 */

class MainViewModel(private val model:MainModel, private val secToHours: SecToHours): Observer {

    private var callback: UIStateCallback = UIStateCallback.Empty()

    override fun observe(callback: UIStateCallback) {
        this.callback = callback
    }

    fun clear() {
        callback = UIStateCallback.Empty()
    }

    fun startTrackingTime() {
        callback.post(secToHours.map(model.time()))
        model.startTracking()
    }

    fun stopTrackingTime() {
        model.stopTracking()
    }

}

interface Observer {
    fun observe(callback: UIStateCallback)
}


interface UIStateCallback {
    fun post(message: String)
    class Empty : UIStateCallback {
        override fun post(message: String) = Unit
    }
}