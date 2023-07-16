package com.example.leadiify.network

import com.example.leadiify.model.Leads_data_model
import com.example.leadiify.model.campaign_data
import retrofit2.Call
import retrofit2.http.GET


interface Api {

 @GET("/campaigns")
 fun getCampaigns(): Call<campaign_data>

 @GET("/leads")
 fun getLeads():Call<Leads_data_model>
}