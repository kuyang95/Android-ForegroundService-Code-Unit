package com.example.foregroundservicecodeunit

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.text.TextUtils
import android.util.Log
import java.util.concurrent.TimeUnit

class MyService : Service() {

    private lateinit var mNotification: ForegroundNotification

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("ForegroundServiceCodeUnit", "onStartCommand")
        super.onStartCommand(intent, flags, startId)

        mNotification = ForegroundNotification(this)

        startForeground(3, mNotification.buildForegroundNotification(this))

        return START_STICKY
    }


    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}