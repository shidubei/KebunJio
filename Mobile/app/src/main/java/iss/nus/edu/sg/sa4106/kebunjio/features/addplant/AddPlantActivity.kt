package iss.nus.edu.sg.sa4106.kebunjio.features.addplant

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import iss.nus.edu.sg.sa4106.kebunjio.R
import iss.nus.edu.sg.sa4106.kebunjio.databinding.ActivityAddPlantBinding
import iss.nus.edu.sg.sa4106.kebunjio.service.mlModel.MlModelService

class AddPlantActivity : AppCompatActivity() {

    // for the UI
    private var _binding: ActivityAddPlantBinding? = null
    private val binding get() = _binding!!
    private lateinit var nameEditText: EditText
    private lateinit var speciesSpinner: Spinner

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

            //if intent action is update
            if(action.equals("Predict Species")){

                runOnUiThread {
                }

            } else if (action.equals("Species List")) {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityAddPlantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameEditText = binding.nameEditText
        speciesSpinner = binding.speciesSpinner

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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