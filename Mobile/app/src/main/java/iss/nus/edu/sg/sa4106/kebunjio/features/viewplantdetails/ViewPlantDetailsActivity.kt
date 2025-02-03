package iss.nus.edu.sg.sa4106.kebunjio.features.viewplantdetails

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import iss.nus.edu.sg.sa4106.kebunjio.DummyData
import iss.nus.edu.sg.sa4106.kebunjio.R
import iss.nus.edu.sg.sa4106.kebunjio.databinding.ActivityViewPlantDetailsBinding
import iss.nus.edu.sg.sa4106.kebunjio.data.EdiblePlantSpecies
import iss.nus.edu.sg.sa4106.kebunjio.service.DownloadImageService
import java.io.File

class ViewPlantDetailsActivity : AppCompatActivity() {

    // for the UI
    private var _binding: ActivityViewPlantDetailsBinding? = null
    private val binding get() = _binding!!

    lateinit var plantNameText: TextView
    lateinit var speciesNameText: TextView
    lateinit var plantDateText: TextView
    lateinit var harvestDateText: TextView
    lateinit var healthText: TextView
    lateinit var diseaseText: TextView
    lateinit var harvestedText: TextView
    lateinit var listLog: ListView
    lateinit var backBtn: Button

    private val dummy = DummyData()

    // for downloading images
    //protected var receiver: BroadcastReceiver = object : BroadcastReceiver() {
    //    override fun onReceive(context: Context, intent: Intent) {
    //        val action = intent.action
    //        if (action != null && action == "download_completed") {
    //            val filename = intent.getStringExtra("filename")
    //            Log.d("ViewPlantDetailsActivity", "filename: ${filename}")
    //            if (filename != null) {
    //                val bitmap = BitmapFactory.decodeFile(filename)
    //                showPlantImg.setImageBitmap(bitmap)
    //                val file = File(filename)
    //                if (file.exists()) {
    //                    val handler = android.os.Handler()
    //                    handler.postDelayed({
    //                        file.delete()
    //                    },5000)
    //                }
                //if (file.exists() && file.delete()) {
                    //    Log.d("ViewPlantDetailsActivity", "File deleted successfully")
                    //} else {
                    //    Log.e("ViewPlantDetailsActivity", "Failed to delete the file")
                    //}
    //            }
    //        }
    //    }
    //}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // add binding
        _binding = ActivityViewPlantDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        plantNameText = binding.plantNameText
        speciesNameText = binding.speciesNameText
        plantDateText = binding.plantDateTimeText
        harvestDateText = binding.harvestDateTimeText
        healthText = binding.plantHealthText
        diseaseText = binding.plantDiseaseText
        harvestedText = binding.harvestedText
        listLog = binding.logList
        backBtn = binding.goBackBtn

        backBtn.setOnClickListener {
            finish()
        }

        // setup to receive broadcast from MyDownloadService
        //initReceiver()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // get the id to show
        val plantId = intent.getIntExtra("plantId",-1)
        if (plantId != -1) {
            // make dummy data
            showPlant(plantId)
        }
    }

    private fun showPlant(plantId: Int) {
        val thisPlant = dummy.PlantDummy[plantId]
        plantNameText.text = "Name: ${thisPlant.name}"
        val thisSpecies = dummy.SpeciesDummy[thisPlant.ediblePlantSpeciesId]
        val speciesText = "Species: ${thisSpecies.name} (${thisSpecies.scientificName})"
        speciesNameText.text = speciesText
        plantDateText.text = thisPlant.plantedDate
        harvestDateText.text = thisPlant.harvestStartDate
        healthText.text = thisPlant.plantHealth
        diseaseText.text = thisPlant.disease
        if (thisPlant.harvested) {
            harvestedText.text = "Harvested"
        } else {
            harvestedText.text = "Not Harvested"
        }

        val loggedActivities = dummy.getPlantLogs(plantId)
        val actTypeList = mutableListOf<String>()
        val timestampList = mutableListOf<String>()
        for (i in 0..loggedActivities.size-1) {
            actTypeList.add(loggedActivities[i].activityType)
            timestampList.add(loggedActivities[i].timestamp)
        }
        listLog.adapter = ViewPlantLogInDetailsAdapter(this,actTypeList,timestampList)
    }

    //protected fun initReceiver() {
    //    val filter = IntentFilter()
    //    filter.addAction("download_completed")
    //    registerReceiver(receiver, filter, RECEIVER_EXPORTED)
    //}

    //protected fun requestImageDL(imgURL: String?) {
    //    val intent = Intent(this, DownloadImageService::class.java)
    //    intent.setAction("download_file")
    //    intent.putExtra("url", imgURL)
    //    intent.putExtra("returnBitmap",false)
    //    Log.d("ViewPlantDetailsActivity","Requested URL: ${imgURL}")
    //    startService(intent)
    //}

}