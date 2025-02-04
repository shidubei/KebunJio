package iss.nus.edu.sg.sa4106.kebunjio

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import iss.nus.edu.sg.sa4106.kebunjio.databinding.ActivityMainBinding
import iss.nus.edu.sg.sa4106.kebunjio.features.logactivities.LogActivitiesActivity
import iss.nus.edu.sg.sa4106.kebunjio.features.planthealthcheck.PlantHealthCheckActivity
import iss.nus.edu.sg.sa4106.kebunjio.features.reminders.ReminderActivity
import iss.nus.edu.sg.sa4106.kebunjio.features.viewplantdetails.ChoosePlantToViewActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startActivity()

    }
    private fun startActivity() {
        //val intent = Intent(this, ReminderActivity::class.java)
        //val intent = Intent(this, ChooseLogToViewActivity::class.java)
        val intent = Intent(this, ChoosePlantToViewActivity::class.java)
        //val intent = Intent(this, ReminderActivity::class.java)
        startActivity(intent)

    }
}
