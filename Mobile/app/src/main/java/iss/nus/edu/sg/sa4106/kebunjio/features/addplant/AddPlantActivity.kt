package iss.nus.edu.sg.sa4106.kebunjio.features.addplant

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import iss.nus.edu.sg.sa4106.kebunjio.R
import iss.nus.edu.sg.sa4106.kebunjio.databinding.ActivityAddPlantBinding
import iss.nus.edu.sg.sa4106.kebunjio.service.mlModel.MlModelService
import iss.nus.edu.sg.sa4106.kebunjio.data.Plant
import iss.nus.edu.sg.sa4106.kebunjio.DummyData


class AddPlantActivity : AppCompatActivity() {

    // for the UI
    private var _binding: ActivityAddPlantBinding? = null
    private val binding get() = _binding!!
    private lateinit var nameEditText: EditText
    private lateinit var speciesSpinner: Spinner
    private lateinit var addPlantBtn: Button
    private var dummyData: DummyData = DummyData()

    // services
    //variables for service, set bound to false
    private var svc: MlModelService? = null
    private var isBound: Boolean? = false

    //set up service to connection
    val conn = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            svc = (p1 as MlModelService.LocalBinder).getService()
            isBound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            isBound = false
            svc = null
        }

    }

    //create BroadcastReceiver object
    private val recv = object : BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent){

            //get intent action
            val action = intent.action


            if(action.equals("Predict Species")){
                // need to assign the species index to the dropdown
                runOnUiThread {
                }

            } else if (action.equals("Species List")) {
                // assign the species list as dropdown values
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // add binding
        _binding = ActivityAddPlantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameEditText = binding.nameEditText
        speciesSpinner = binding.speciesSpinner
        addPlantBtn = binding.addPlantBtn

        // set the spinner options
        val spinnerOptions = dummyData.nameList()
        val spinAdapter: ArrayAdapter<String> = ArrayAdapter<String>(this,
                                                                        android.R.layout.simple_spinner_item,
                                                                        spinnerOptions)

        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        speciesSpinner.adapter = spinAdapter

        addPlantBtn.setOnClickListener {
            addNewPlant()
        }

        // bind service
        //bound to service
        val intent = Intent(this@AddPlantActivity, MlModelService::class.java)
        bindService(intent, conn, Context.BIND_AUTO_CREATE)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun addNewPlant() {
        val plantId = -1 // Must assign a proper id later
        val ediblePlantSpeciesId = speciesSpinner.selectedItemPosition // must assign a proper id later
        val userId = -1 // must assign a proper id later
        val name = nameEditText.text.toString()
        val newPlant = Plant(plantId, ediblePlantSpeciesId, userId, name)
        // TODO: add the new plant
    }

    //function for subscribe to broadcast
    protected fun subscribeToActions(){
        val filter = IntentFilter()
        filter.addAction("Predict Species")
        filter.addAction("Species List")
        registerReceiver(recv, filter, RECEIVER_EXPORTED)
    }

    //function for unsubscribe to broadcast
    protected fun unsubscribeToActions(){
        unregisterReceiver(recv)
    }
}