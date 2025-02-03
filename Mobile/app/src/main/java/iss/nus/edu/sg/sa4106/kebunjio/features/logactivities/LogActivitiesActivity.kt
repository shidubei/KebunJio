package iss.nus.edu.sg.sa4106.kebunjio.features.logactivities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import iss.nus.edu.sg.sa4106.kebunjio.DummyData
import iss.nus.edu.sg.sa4106.kebunjio.R
import iss.nus.edu.sg.sa4106.kebunjio.TimeClassHandler
import iss.nus.edu.sg.sa4106.kebunjio.data.ActivityLog
import iss.nus.edu.sg.sa4106.kebunjio.databinding.ActivityLogActivitiesBinding

class LogActivitiesActivity : AppCompatActivity() {

    // for ui
    private var _binding: ActivityLogActivitiesBinding? = null
    private val binding get() = _binding!!

    lateinit var timeStampHandler: TimeClassHandler
    lateinit var timeStampText: TextView
    lateinit var changeDateBtn: Button
    lateinit var changeTimeBtn: Button

    lateinit var logActivitiesBtn: Button
    lateinit var activityTypeSpinner: Spinner
    lateinit var activityDescText: EditText
    lateinit var plantSpinner: Spinner
    var currentUser: Int = 0
    private var dummyData: DummyData = DummyData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityLogActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timeStampText = binding.timeStampText
        changeDateBtn = binding.changeDateBtn
        changeTimeBtn = binding.changeTimeBtn

        timeStampHandler = TimeClassHandler(timeStampText,changeDateBtn,changeTimeBtn,this)

        activityTypeSpinner = binding.activityTypeSpinner
        activityDescText = binding.activityDescText
        logActivitiesBtn = binding.logActivitiesBtn
        plantSpinner = binding.plantSpinner

        val userPlants = dummyData.getUserPlants(currentUser)
        val userPlantNames: MutableList<String> = mutableListOf<String>()
        userPlantNames.add("NO PLANT")
        for (i in 0..userPlants.size-1) {
            userPlantNames.add(userPlants[i].name)
        }
        val logActTypes: MutableList<String> = mutableListOf<String>()
        logActTypes.add("Water")
        logActTypes.add("Fertilize")
        logActTypes.add("Harvest")
        logActTypes.add("Withered")

        val plantAdapter = ArrayAdapter(this,
                                    android.R.layout.simple_spinner_item,
                                    userPlantNames)
        plantAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        plantSpinner.adapter = plantAdapter

        val logActAdapter = ArrayAdapter(this,
                                    android.R.layout.simple_spinner_item,
                                    logActTypes)
        activityTypeSpinner.adapter = logActAdapter

        logActivitiesBtn.setOnClickListener {
            logNewActivity()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun logNewActivity() {
        val logId = -1 // Must assign a proper id later
        val userId = -1 // must assign a proper id later
        var plantId: Int? = null // must assign a proper id later
        if (plantSpinner.selectedItemPosition > 0) {
            plantId = plantSpinner.selectedItemPosition - 1
        }
        val activityType = activityTypeSpinner.selectedItem.toString()
        val activityDesc = activityDescText.text.toString()
        val timeStamp = timeStampText.text.toString()

        var ActivityLog = ActivityLog(logId,userId,plantId,activityType,activityDesc,timeStamp)
        // TODO: log the new activity
    }

}