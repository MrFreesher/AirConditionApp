package com.freesher.airconditionapp.ui.Measures


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.freesher.airconditionapp.R
import com.freesher.airconditionapp.model.Measure
import com.freesher.airconditionapp.network.AirConditionApi
import kotlinx.android.synthetic.main.fragment_measures.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class MeasuresFragment : Fragment(R.layout.fragment_measures) {
    val args:  MeasuresFragmentArgs by  navArgs()
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var measureAdapter: MeasureAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sensorId = args.sensorId
        val sensorName = args.sensorName
        activity?.title = sensorName
        layoutManager = LinearLayoutManager(context)
        measureAdapter =
            MeasureAdapter()
        measuresRecyclerView.layoutManager = layoutManager
        measuresRecyclerView.adapter = measureAdapter
        AirConditionApi.retrofitService.getMeasures(sensorId).enqueue(object:
            Callback<Measure> {
            override fun onFailure(call: Call<Measure>, t: Throwable) {
               Toast.makeText(context,t.localizedMessage,Toast.LENGTH_SHORT).show()
                measuresProgressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<Measure>, response: Response<Measure>) {
                if (response.body() != null) {
                    val measure = response.body()!!
                    measuresProgressBar.visibility = View.GONE
                    measureAdapter.setMeasures(measure)


                }
            }

        })
    }


}
