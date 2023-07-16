package com.example.leadiify.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.leadiify.databinding.LeadsDataBinding
import com.example.leadiify.model.Leads_data_model

class LeadsAdapter(var data: Leads_data_model):RecyclerView.Adapter<LeadsAdapter.ViewHolder>() {
    var descriptionData = arrayOf("Aware", "Interested", "Desire", "Closed")
    inner class ViewHolder(var bind:LeadsDataBinding):RecyclerView.ViewHolder(bind.root)
    {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeadsAdapter.ViewHolder {
      var inflater =LayoutInflater.from(parent.context)
        var binding = LeadsDataBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LeadsAdapter.ViewHolder, position: Int) {
        with(holder)
        {
            with(data[holder.adapterPosition])
            {
               bind.textView10.text=this.company_name
//                bind.textView7.text=this
                bind.yourStateProgress.setStateDescriptionData(descriptionData)
//                bind.imageView5.setBackgroundResource()
//                bind.profilePhoto.load(this.photo)
            }
        }
    }

    override fun getItemCount(): Int {
      return data.size
    }

}