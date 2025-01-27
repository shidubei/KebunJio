package iss.nus.edu.sg.sa4106.kebunjio.features.viewplantdetails;

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.registerReceiver
import iss.nus.edu.sg.sa4106.kebunjio.R
import iss.nus.edu.sg.sa4106.kebunjio.service.DownloadImageService
import java.io.File


class ChoosePlantAdapter(private val context: Context,
                         protected var speciesId: MutableList<Int>,
                         protected var imgUrls: MutableList<String>,
                         protected var names: MutableList<String>
        ): ArrayAdapter<Any?>(context, R.layout.view_plant_to_choose) {

    lateinit var showSpeciesImg: ImageButton
    private var showSpeciesImgArray: MutableList<ImageButton> = mutableListOf<ImageButton>()
    lateinit var showSpeciesName: TextView
    lateinit var storedSpeciesId:  MutableList<Int>

    protected var receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            Log.d("ChoosePlantAdapter","Got feedback ${intent}, ${action}")
            if (action != null) {
                if (action == "download_completed_id") {
                    Log.d("ChoosePlantAdapter","Getting filename")

                //val filename = intent.getStringExtra("filename")
                    val position = intent.getIntExtra("id",-1)
                    val filename = intent.getStringExtra("filename")
                    Log.d("ChoosePlantAdapter", "received position ${position} filename: ${filename}")
                    if (filename != null) {
                        val bitmap = BitmapFactory.decodeFile(filename)
                        Log.d("ChoosePlantAdapter","Set image bitmap for ${position}: ${showSpeciesImgArray[position]}")
                        showSpeciesImgArray[position].setImageBitmap(bitmap)
                        val file = File(filename)
                        if (file.exists()) {
                            val handler = android.os.Handler()
                            handler.postDelayed({
                                file.delete()
                                Log.d("ChoosePlantAdapter","Deleted file for position ${position}")
                            },5000)

                        }
                    }
                }
            } else {
                Log.d("ChoosePlantAdapter","ERROR: Action is null")
            }

        }
    }


    init {
        addAll(*arrayOfNulls<Any>(names.size))
    }
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var _view = view

        if (_view == null) {
            val inflater = context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            // if we are not responsible for adding the view to the parent,
            // then attachToRoot should be 'false' (which is in our case)
            _view = inflater.inflate(R.layout.view_plant_to_choose, parent, false)
        }
        this.storedSpeciesId = speciesId
        showSpeciesImg = _view!!.findViewById<ImageButton>(R.id.show_species_choose_img)
        Log.d("ChoosePlantAdapter","Position ${position}'s ImageButton: ${showSpeciesImg}")
        showSpeciesImgArray.add(showSpeciesImg)
        Log.d("ChoosePlantAdapter","ImgArray Size: ${showSpeciesImgArray.size}")
        showSpeciesName = _view.findViewById<TextView>(R.id.species_name_choose_text)
        Log.d("ChoosePlantAdapter","Position ${position}'s TextView: ${showSpeciesName}")

        showSpeciesName.text = names[position]

        // setup to receive broadcast from MyDownloadService
        initReceiver()

        if (imgUrls.size > position) {
            val url = imgUrls[position]
            requestImageDL(url,position)
        }

        showSpeciesImg.setOnClickListener {
            Log.d("ChoosePlantAdapter","*** Viewing Position: $position ***")
            val thisId = this.storedSpeciesId[position]
            Log.d("ChoosePlantAdapter","thisId: $thisId")
            val intent = Intent(getContext(), ViewPlantDetailsActivity::class.java)
            intent.putExtra("ediblePlantId", thisId)
            getContext().startActivity(intent)
        }

        return _view
    }

    protected fun requestImageDL(imgURL: String, position: Int) {
        val intent = Intent(getContext(), DownloadImageService::class.java)
        intent.setAction("download_file_id")
        intent.putExtra("url", imgURL)
        intent.putExtra("id", position)
        intent.putExtra("returnBitmap",false)
        Log.d("ChoosePlantAdapter","URL for position ${position}: ${imgURL}")
        getContext().startService(intent)
    }

    protected fun initReceiver() {
        val filter = IntentFilter()
        filter.addAction("download_completed_id")
        registerReceiver(getContext(),receiver, filter, ContextCompat.RECEIVER_EXPORTED)
    }
}