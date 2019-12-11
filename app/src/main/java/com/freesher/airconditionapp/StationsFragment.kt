package com.freesher.airconditionapp


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.freesher.airconditionapp.adapter.StationAdapter
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
    private lateinit var stationAdapter:StationAdapter
    var listOfStations = mutableListOf<Station>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(context)
        stationAdapter = StationAdapter()
        Log.e("My",listOfStations.size.toString())
        stationRecyclerView.layoutManager = layoutManager
        stationRecyclerView.adapter = stationAdapter

        AirConditionApi.retrofitService.getAllStations().enqueue(object: Callback<List<Station>>{
            override fun onFailure(call: Call<List<Station>>, t: Throwable) {
                Toast.makeText(requireContext(),"Failed",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Station>>, response: Response<List<Station>>) {
                if (response.body() != null) {
                    stationAdapter.setStations(response.body()!!)

                }
            }

        })

    }



}
