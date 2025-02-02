package iss.nus.edu.sg.sa4106.kebunjio.features.viewplantdetails

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import iss.nus.edu.sg.sa4106.kebunjio.R

class ViewPlantLogInDetailsAdapter(private val context: Context,
                                   protected var activityTypes: MutableList<String>,
                                   protected var timestamps: MutableList<String>
): ArrayAdapter<Any?>(context, R.layout.view_plant_log_in_details) {

    lateinit var actTypeText: TextView
    lateinit var lastTimeText: TextView
    init {
        addAll(*arrayOfNulls<Any>(activityTypes.size))
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var _view = view

        if (_view == null) {
            val inflater = context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            _view = inflater.inflate(R.layout.view_plant_log_in_details, parent, false)
        }

        actTypeText = _view!!.findViewById<TextView>(R.id.activity_type_text)
        lastTimeText = _view.findViewById<TextView>(R.id.last_time_text)

        actTypeText.text = activityTypes[position]
        lastTimeText.text = timestamps[position]

        return _view
    }
}