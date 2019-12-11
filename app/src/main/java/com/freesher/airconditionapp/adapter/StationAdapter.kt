package com.freesher.airconditionapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.freesher.airconditionapp.R
import com.freesher.airconditionapp.model.Station
import kotlinx.android.synthetic.main.station_item.view.*

class StationAdapter() :
    RecyclerView.Adapter<StationAdapter.StationViewHolder>() {
    private val listOfStations: MutableList<Station> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.station_item, parent, false)
        val viewHolder = StationViewHolder(view)
        Log.e("My",listOfStations.size.toString())
        return viewHolder
    }

    override fun getItemCount(): Int {
        return listOfStations.size
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int){
        holder.titleTextView.text = listOfStations[position].name
    }
    fun setStations(stationsList:List<Station>){
        listOfStations.clear()
        listOfStations.addAll(stationsList)
        notifyDataSetChanged()
    }
    class StationViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val titleTextView: TextView = item.stationTitle
    }

}
