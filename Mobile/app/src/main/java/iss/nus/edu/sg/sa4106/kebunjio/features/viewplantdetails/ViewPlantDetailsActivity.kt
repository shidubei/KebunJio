package iss.nus.edu.sg.sa4106.kebunjio.features.viewplantdetails

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import iss.nus.edu.sg.sa4106.kebunjio.R
import iss.nus.edu.sg.sa4106.kebunjio.databinding.ActivityViewPlantDetailsBinding
import iss.nus.edu.sg.sa4106.kebunjio.data.EdiblePlantSpecies
import iss.nus.edu.sg.sa4106.kebunjio.service.DownloadImageService

class ViewPlantDetailsActivity : AppCompatActivity() {

    // for the UI
    private var _binding: ActivityViewPlantDetailsBinding? = null
    private val binding get() = _binding!!
    private var currentSpecies: EdiblePlantSpecies? = null
    lateinit var plantNameText: TextView
    lateinit var sciNameText: TextView
    lateinit var showPlantImg: ImageView
    lateinit var edibleGroupText: TextView
    lateinit var descriptionText: TextView
    lateinit var waterTipsText: TextView
    lateinit var sunlightText: TextView
    lateinit var soilTypeText: TextView
    lateinit var harvestTimeText: TextView
    lateinit var commonPestsText: TextView
    lateinit var growingSpaceText: TextView
    lateinit var fertilizerTipsText: TextView
    lateinit var specialNeedsText: TextView

    // for downloading images
    protected var receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            if (action != null && action == "download_completed") {
                val filename = intent.getStringExtra("filename")
                showImage(filename)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // add binding
        _binding = ActivityViewPlantDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        plantNameText = binding.plantNameText
        sciNameText = binding.sciNameText
        showPlantImg = binding.showPlantImg
        edibleGroupText = binding.edibleGroupText
        descriptionText = binding.descriptionText
        waterTipsText = binding.waterTipsText
        sunlightText = binding.sunlightText
        soilTypeText = binding.soilTypeText
        harvestTimeText = binding.harvestTimeText
        commonPestsText = binding.commonPestsText
        growingSpaceText = binding.growingSpaceText
        fertilizerTipsText = binding.fertilizerTipsText
        specialNeedsText = binding.specialNeedsText

        // setup to receive broadcast from MyDownloadService
        initReceiver()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // get the id to show
        val showId = intent.getIntExtra("ediblePlantId",-1)
        if (showId != -1) {
            // Download the data corresponding to the ID and then show species
        }
    }

    private fun showNewSpecies(newSpecies: EdiblePlantSpecies) {
        currentSpecies = newSpecies
        plantNameText.text = currentSpecies!!.name
        sciNameText.text = currentSpecies!!.scientificName
        showPlantImg.setImageBitmap(null)
        requestImageDL(currentSpecies!!.imageURL)
        edibleGroupText.text = currentSpecies!!.ediblePlantGroup
        descriptionText.text = currentSpecies!!.description
        waterTipsText.text = currentSpecies!!.wateringTips
        sunlightText.text = currentSpecies!!.sunlight
        soilTypeText.text = currentSpecies!!.soilType
        harvestTimeText.text = currentSpecies!!.harvestTime
        commonPestsText.text = currentSpecies!!.commonPests
        growingSpaceText.text = currentSpecies!!.growingSpace
        fertilizerTipsText.text = currentSpecies!!.fertilizerTips
        specialNeedsText.text = currentSpecies!!.specialNeeds
    }

    protected fun initReceiver() {
        val filter = IntentFilter()
        filter.addAction("download_completed")
        registerReceiver(receiver, filter, RECEIVER_EXPORTED)
    }

    protected fun requestImageDL(imgURL: String?) {
        val intent = Intent(this, DownloadImageService::class.java)
        intent.setAction("download_file")
        intent.putExtra("url", imgURL)
        startService(intent)
    }

    protected fun showImage(filename: String?) {
        val bitmap = BitmapFactory.decodeFile(filename)
        showPlantImg.setImageBitmap(bitmap)
        deleteFile(filename)
    }

}