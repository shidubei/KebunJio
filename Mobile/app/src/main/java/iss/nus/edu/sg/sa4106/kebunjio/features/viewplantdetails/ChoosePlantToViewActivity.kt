package iss.nus.edu.sg.sa4106.kebunjio.features.viewplantdetails

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import iss.nus.edu.sg.sa4106.kebunjio.R
import iss.nus.edu.sg.sa4106.kebunjio.databinding.ActivityChoosePlantToViewBinding

// for testing
import iss.nus.edu.sg.sa4106.kebunjio.DummyData

class ChoosePlantToViewActivity : AppCompatActivity() {

    private var _binding: ActivityChoosePlantToViewBinding? = null
    private val binding get() = _binding!!
    private val dummy = DummyData()
    private val userId = 0

    lateinit var plantList: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // add binding
        _binding = ActivityChoosePlantToViewBinding.inflate(layoutInflater)
        setContentView(binding.root)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // get the species list view
        plantList = binding.plantList

        val userPlants = dummy.getUserPlants(0)
        val idList: MutableList<Int> = mutableListOf<Int>()
        val nameList: MutableList<String> = mutableListOf<String>()

        for (i in 0..userPlants.size-1) {
            idList.add(userPlants[i].plantId)
            nameList.add(userPlants[i].name)
        }

        plantList.adapter = PlantToChooseAdapter(this,idList,nameList)
        //speciesList.setOnItemClickListener(this)
        //update grid view
        //(speciesList.adapter as ChoosePlantAdapter).notifyDataSetChanged()
    }
}