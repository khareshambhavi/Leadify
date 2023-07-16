package com.example.leadiify.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leadiify.databinding.ActivityDataBinding
import com.example.leadiify.model.acitivity_data

class ActivityAdapter(var data:ArrayList<acitivity_data>):RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {
    inner class ViewHolder(var bind:ActivityDataBinding):RecyclerView.ViewHolder(bind.root)
    {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityAdapter.ViewHolder {
      var inflater =LayoutInflater.from(parent.context)
        var binding = ActivityDataBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityAdapter.ViewHolder, position: Int) {
        with(holder)
        {
            with(data[holder.adapterPosition])
            {
                bind.textView7.text=this.name
                bind.imageView7.setBackgroundResource(this.bimage)
                bind.textView10.text=this.time
                bind.textView11.text="Token: " + this.token
            }
        }
    }

    override fun getItemCount(): Int {
      return data.size
    }

}