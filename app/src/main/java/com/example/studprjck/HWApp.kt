package com.example.studprjck

import android.app.Application

class HelloWorldApp: Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(MainModel(this), SecToHours.Base())
    }
}