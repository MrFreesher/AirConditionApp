package com.freesher.airconditionapp.ui.Sensors

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.freesher.airconditionapp.R

import com.freesher.airconditionapp.model.Sensor
import kotlinx.android.synthetic.main.list_item.view.*

class SensorAdapter() :
    RecyclerView.Adapter<SensorAdapter.SensorViewHolder>() {
    private val listOfSensors: MutableList<Sensor> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        val viewHolder =
            SensorViewHolder(
                view
            )
        Log.e("My",listOfSensors.size.toString())
        return viewHolder
    }

    override fun getItemCount(): Int {
        return listOfSensors.size
    }

    override fun onBindViewHolder(holder: SensorViewHolder, position: Int){
        holder.titleTextView.text = listOfSensors[position].param.name
        holder.itemView.setOnClickListener {

val action = SensorsFragmentDirections.actionSensorsFragmentToMeasuresFragment()
    action.sensorName = listOfSensors[position].param.name
    action.sensorId = listOfSensors[position].id
  Navigation.findNavController(it).navigate(action)
        }
    }
    fun setSensors(sensorsList:List<Sensor>){
        listOfSensors.clear()
        listOfSensors.addAll(sensorsList)
        notifyDataSetChanged()
    }
    class SensorViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val titleTextView: TextView = item.stationTitle
    }

}
