package iss.nus.edu.sg.sa4106.kebunjio.service.reminders

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class ReminderService : Service() {

    inner class LocalBinder: Binder(){
        fun getService(): ReminderService {
            return this@ReminderService
        }
    }

    val binder: IBinder = LocalBinder()

    override fun onBind(intent: Intent): IBinder {
        return binder
    }
}