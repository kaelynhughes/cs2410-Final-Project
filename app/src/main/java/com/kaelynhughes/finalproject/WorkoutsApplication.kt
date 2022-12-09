package com.kaelynhughes.finalproject

import android.app.Application

class WorkoutsApplication: Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: Application? = null

        fun getInstance(): Application {
            return instance!!
        }
    }
}