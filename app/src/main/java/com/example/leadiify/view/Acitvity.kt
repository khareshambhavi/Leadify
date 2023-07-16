package com.example.leadiify.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leadiify.R
import com.example.leadiify.adapter.ActivityAdapter
import com.example.leadiify.databinding.FragmentAcitvityBinding
import com.example.leadiify.model.acitivity_data


class Acitvity : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding=FragmentAcitvityBinding.inflate(inflater, container, false)
        var data = ArrayList<acitivity_data>()
        data.add(acitivity_data("Bajaj Finserv Facebook","July 06 , 2023 - 16:26","1",R.drawable.group_1000005043))
        data.add(acitivity_data("Bajaj Finserv Facebook","July 06 , 2023 - 16:26","1",R.drawable.group_1000005043))
        data.add(acitivity_data("Bajaj Finserv Facebook","July 06 , 2023 - 16:26","1",R.drawable.group_1000005043))
        data.add(acitivity_data("Bajaj Finserv Facebook","July 06 , 2023 - 16:26","1",R.drawable.group_1000005043))
        data.add(acitivity_data("Bajaj Finserv Facebook","July 06 , 2023 - 16:26","1",R.drawable.group_1000005043))
        data.add(acitivity_data("Bajaj Finserv Facebook","July 06 , 2023 - 16:26","1",R.drawable.group_1000005043))
        var adapter=ActivityAdapter(data)
        var layout = LinearLayoutManager(
            container?.context,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.activityRecyclerview.adapter=adapter
        binding.activityRecyclerview.layoutManager=layout
        return binding.root
    }


}