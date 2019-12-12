package com.freesher.airconditionapp


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.freesher.airconditionapp.adapter.SensorAdapter
import com.freesher.airconditionapp.adapter.StationAdapter
import com.freesher.airconditionapp.model.Sensor
import com.freesher.airconditionapp.model.Station
import com.freesher.airconditionapp.network.AirConditionApi
import kotlinx.android.synthetic.main.fragment_sensors.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class SensorsFragment : Fragment(R.layout.fragment_sensors) {
    val args: SensorsFragmentArgs by navArgs()
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var sensorAdapter: SensorAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Sensors"
        val stationsId = args.stationId
        Log.v("My",stationsId.toString())
        layoutManager = LinearLayoutManager(context)
        sensorAdapter = SensorAdapter()
        sensorsRecyclerView.layoutManager = layoutManager
        sensorsRecyclerView.adapter = sensorAdapter
        AirConditionApi.retrofitService.getSensors(stationsId).enqueue(object: Callback<List<Sensor>> {
            override fun onFailure(call: Call<List<Sensor>>, t: Throwable) {
                Log.e("My",t.localizedMessage)
                Log.v("dd",stationsId.toString())
            }

            override fun onResponse(call: Call<List<Sensor>>, response: Response<List<Sensor>>) {
                if (response.body() != null) {
                    sensorAdapter.setSensors(response.body()!!)

                    Log.v("xx",stationsId.toString())
                }
            }

        })

    }


}
