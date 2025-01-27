package iss.nus.edu.sg.sa4106.kebunjio.features.viewplantdetails;

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity.RECEIVER_EXPORTED
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.registerReceiver

import iss.nus.edu.sg.sa4106.kebunjio.R;
import iss.nus.edu.sg.sa4106.kebunjio.service.DownloadImageService


class ChoosePlantAdapter(private val context: Context,
                         protected var speciesId: MutableList<Int>,
                         protected var imgUrls: MutableList<String>,
                         protected var names: MutableList<String>
        ): ArrayAdapter<Any?>(context, R.layout.view_plant_to_choose) {

    lateinit var showSpeciesImg: ImageButton
    lateinit var showSpeciesName: TextView
    lateinit var storedSpeciesId:  MutableList<Int>

    protected var receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            if (action != null && action == "download_completed") {
                val filename = intent.getStringExtra("filename")
                showImage(filename)
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
        showSpeciesName = _view.findViewById<TextView>(R.id.species_name_choose_text)

        showSpeciesName.text = names[position]

        // setup to receive broadcast from MyDownloadService
        initReceiver()

        if (imgUrls.size > position) {
            val url = imgUrls[position]
            Thread{
                requestImageDL(url)
            }
        }

        showSpeciesImg.setOnClickListener {
            val thisId = speciesId[position]
            val intent = Intent(getContext(), ViewPlantDetailsActivity::class.java)
            intent.putExtra("ediblePlantId", thisId)
            getContext().startActivity(intent)
        }

        return _view
    }

    protected fun requestImageDL(imgURL: String?) {
        val intent = Intent(getContext(), DownloadImageService::class.java)
        intent.setAction("download_file")
        intent.putExtra("url", imgURL)
        getContext().startService(intent)
    }

    protected fun initReceiver() {
        val filter = IntentFilter()
        filter.addAction("download_completed")
        registerReceiver(getContext(),receiver, filter, ContextCompat.RECEIVER_EXPORTED)
    }

    protected fun showImage(filename: String?) {
        val bitmap = BitmapFactory.decodeFile(filename)
        showSpeciesImg.setImageBitmap(bitmap)
        getContext().deleteFile(filename)
    }
}