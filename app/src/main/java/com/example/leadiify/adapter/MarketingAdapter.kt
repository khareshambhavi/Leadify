package com.example.leadiify.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leadiify.databinding.MarketingCardsBinding
import com.example.leadiify.model.acitivity_data
import com.example.leadiify.model.campaign_data

class MarketingAdapter(var data: campaign_data):RecyclerView.Adapter<MarketingAdapter.ViewHolder>() {
    inner class ViewHolder(var bind:MarketingCardsBinding):RecyclerView.ViewHolder(bind.root)
    {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketingAdapter.ViewHolder {
        var inflater =LayoutInflater.from(parent.context)
        var binding = MarketingCardsBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarketingAdapter.ViewHolder, position: Int) {
        with(holder)
        {
            with(data[holder.adapterPosition])
            {
               bind.textView14.text=this.total_likes
                bind.targetValue.text=this.target.toString()
                bind.impValue.text=this.impressions
                bind.durationData.text=this.duration
                bind.durationProgress.progress= this.duration.toInt()/20*100
            }
        }
    }

    override fun getItemCount(): Int {
      return data.size
    }

}