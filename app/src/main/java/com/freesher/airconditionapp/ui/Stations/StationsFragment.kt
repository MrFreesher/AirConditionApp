package com.freesher.airconditionapp.ui.Stations


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.freesher.airconditionapp.R
import com.freesher.airconditionapp.model.Station
import com.freesher.airconditionapp.network.AirConditionApi
import kotlinx.android.synthetic.main.fragment_stations.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class StationsFragment : Fragment(R.layout.fragment_stations) {
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var stationAdapter: StationAdapter
    private lateinit var listOfStations:List<Station>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title="Stations"
        layoutManager = LinearLayoutManager(context)
        stationAdapter =
            StationAdapter()

        stationRecyclerView.layoutManager = layoutManager
        stationRecyclerView.adapter = stationAdapter

        AirConditionApi.retrofitService.getAllStations().enqueue(object: Callback<List<Station>>{
            override fun onFailure(call: Call<List<Station>>, t: Throwable) {
                Toast.makeText(requireContext(),"Failed",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Station>>, response: Response<List<Station>>) {
                if (response.body() != null) {
                    listOfStations = response.body()!!
                    stationAdapter.setStations(listOfStations)

                }
            }

        })
        searchBtn.setOnClickListener {
            val searchText = searchTextView.text.toString()
            searchStation(searchText)
        }
    }
    fun searchStation(searchText:String){
        val regexExpression = searchText.toRegex()
        val filteredList = listOfStations.filter { regexExpression.containsMatchIn(it.name) }
        stationAdapter.setStations(filteredList)
    }



}
