package iss.nus.edu.sg.sa4106.kebunjio.features.viewplantdetails

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import iss.nus.edu.sg.sa4106.kebunjio.R
import iss.nus.edu.sg.sa4106.kebunjio.databinding.ActivityChoosePlantToViewBinding

class ChoosePlantToViewActivity : AppCompatActivity() {

    private var _binding: ActivityChoosePlantToViewBinding? = null
    private val binding get() = _binding!!

    lateinit var speciesList: ListView


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
        speciesList = binding.speciesList

        //update grid view
        (speciesList.adapter as ChoosePlantAdapter).notifyDataSetChanged()
    }
}