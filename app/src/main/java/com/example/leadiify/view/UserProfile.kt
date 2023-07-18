package com.example.leadiify.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leadiify.R
import com.example.leadiify.databinding.FragmentUserProfileBinding
import com.example.leadiify.model.Leads_data_modelItem
import com.kofigyan.stateprogressbar.StateProgressBar


class UserProfile : Fragment() {

    var descriptionData = arrayOf("Aware", "Interested", "Desire", "Closed")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        var data  = arguments?.getParcelable<Leads_data_modelItem>("data")
        binding.yourStateProgress.setStateDescriptionData(descriptionData)
        when(data?.state_progress)
        {
            1->binding.yourStateProgress.setCurrentStateNumber(StateProgressBar.StateNumber.ONE)
            2->binding.yourStateProgress.setCurrentStateNumber(StateProgressBar.StateNumber.TWO)
            3->binding.yourStateProgress.setCurrentStateNumber(StateProgressBar.StateNumber.THREE)
            else ->binding.yourStateProgress.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR)
        }
        binding.iid.text=data?.id.toString()
        binding.cName.text=data?.company_name.toString()
        binding.cTitle.text=data?.title.toString()
        binding.email.text=data?.email.toString()
        binding.industry.text=data?.industry.toString()
        binding.institute.text=data?.institute.toString()
        binding.keywords.text=data?.keywords.toString()
        return binding.root
    }


}