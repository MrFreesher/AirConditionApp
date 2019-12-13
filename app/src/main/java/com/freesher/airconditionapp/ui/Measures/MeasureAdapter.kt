package com.freesher.airconditionapp.ui.Measures

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.freesher.airconditionapp.R
import com.freesher.airconditionapp.model.Measure
import com.freesher.airconditionapp.model.Values
import kotlinx.android.synthetic.main.measure_item.view.*

class MeasureAdapter() :
    RecyclerView.Adapter<MeasureAdapter.MeasureViewHolder>() {
    private val listOfMeasures: MutableList<Values> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeasureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.measure_item, parent, false)
        val viewHolder =
            MeasureViewHolder(
                view
            )
        Log.e("My",listOfMeasures.size.toString())
        return viewHolder
    }

    override fun getItemCount(): Int {
        return listOfMeasures.size
    }

    override fun onBindViewHolder(holder: MeasureViewHolder, position: Int){
        holder.dateTextView.text = "Data : ${listOfMeasures[position].date}"
        holder.valueTextView.text = "Wartość : ${listOfMeasures[position].value.toString()}"
    }
    fun setMeasures(measure:Measure){
        listOfMeasures.clear()
        listOfMeasures.addAll(measure.values)
        notifyDataSetChanged()
    }
    class MeasureViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val dateTextView: TextView = item.measureDate
        val valueTextView:TextView = item.measureValue
    }

}
