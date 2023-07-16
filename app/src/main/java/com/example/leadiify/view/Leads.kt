package com.example.leadiify.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leadiify.R
import com.example.leadiify.adapter.LeadsAdapter
import com.example.leadiify.databinding.FragmentLeadsBinding
import com.example.leadiify.model.Leads_data_model
import com.example.unacademy.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Leads : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      var binding= FragmentLeadsBinding.inflate(inflater, container, false)
//        var data = ArrayList<Leads_data_model>()
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
        RetrofitClient.init().getLeads().enqueue(object : Callback<Leads_data_model?> {
            override fun onResponse(
                call: Call<Leads_data_model?>,
                response: Response<Leads_data_model?>
            ) {
                if(response.isSuccessful)
                {
                    var adapter= response.body()?.let { LeadsAdapter(it) }
                    var layout = LinearLayoutManager(
                        container?.context,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    binding.leadsRecyclerview.adapter=adapter
                    binding.leadsRecyclerview.layoutManager=layout
                }
            }

            override fun onFailure(call: Call<Leads_data_model?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return binding.root
    }


}