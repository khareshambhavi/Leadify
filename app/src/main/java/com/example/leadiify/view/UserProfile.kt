package com.example.leadiify.view

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.leadiify.R
import com.example.leadiify.adapter.EnrichedDataAdapter
import com.example.leadiify.adapter.LeadsAdapter
import com.example.leadiify.databinding.FragmentUserProfileBinding
import com.example.leadiify.model.EnrichedDataModel
import com.example.leadiify.model.Leads_data_modelItem
import com.example.leadiify.model.SendConnection
import com.example.unacademy.network.RetrofitClient
import com.kofigyan.stateprogressbar.StateProgressBar
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserProfile : Fragment() {

    var descriptionData = arrayOf("Aware", "Interested", "Desire", "Closed")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        var data  = arguments?.getParcelable<Leads_data_modelItem>("data")
//        Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_SHORT).show()
        val data_enc = HashMap<String, String>()
        data_enc["https://www.linkedin.com/in/ashish-panchal-639bb04/"]="Sure, here is the summary of the input text you provided:\n" +
                "\n" +
                "**Job Description:** Ashish Panchal is the Executive Director and Chief Executive Officer of Bajaj Markets, a retail banking and payments company in India. He has over 25 years of experience in the financial services industry, and has held senior positions at Citibank, Standard Chartered, Barclays, and Bajaj Finance.\n" +
                "\n" +
                "**Geography:** Ashish Panchal is based in Pune, Maharashtra, India.\n" +
                "\n" +
                "**Interesting Characteristics:** Ashish Panchal is a versatile retail-banking & payments business professional with a strong track record of success. He has a deep understanding of the retail financial services industry, and has a proven ability to lead and grow businesses. He is also a strong people manager, and has a knack for building and motivating high-performing teams.\n" +
                "\n" +
                "**Profile:** Ashish Panchal would be a good match for a variety of senior-level roles in the retail financial services industry. He would be a particularly good fit for roles in strategy, sales, marketing, and product development.\n" +
                "\n" +
                "**Additional Information:**\n" +
                "\n" +
                "* Education: Harvard Business School, Advanced Management Program (AMP)\n" +
                "* MBA: Jamnalal Bajaj Institute of Management Studies (JBIMS)\n" +
                "* LinkedIn Profile: https://www.linkedin.com/in/ashish-panchal-639bb04/\n" +
                "\n" +
                "I hope this summary is helpful. Please let me know if you have any other questions."
        data_enc["https://www.linkedin.com/in/ramandeep-singh-gulati-9a3a61168/"]="Sure, here is the summary of the input text:\n" +
                "\n" +
                "**Job Description:** Assistant Manager at Bajaj Allianz General Insurance, with a focus on Multi-Channel Marketing.\n" +
                "\n" +
                "**Geography:** Mumbai, Maharashtra, India.\n" +
                "\n" +
                "**Interesting Characteristics:**\n" +
                "* Passionate about new ideas and has a strong goal orientation.\n" +
                "* Has superior understanding of various domains.\n" +
                "* Good at conducting market research, designing long term strategies and immediate tacticals with flawless execution.\n" +
                "* Highly effective with communication to present a product or a service to the clients.\n" +
                "\n" +
                "**Profile Match:**\n" +
                "* Sales & Marketing\n" +
                "* Market Research\n" +
                "* Retail Marketing\n" +
                "* Business Development\n" +
                "* Business-to-Business (B2B)\n" +
                "* Marketing\n" +
                "* Sales Management\n" +
                "* Fast-Moving Consumer Goods (FMCG)\n" +
                "* Recruiting\n" +
                "* Advertising\n" +
                "* Strategic Negotiations\n" +
                "* Team Building\n" +
                "\n" +
                "**Additional Information:**\n" +
                "* Graduated from International School of Business & Media with a PGDM in Marketing & Finance.\n" +
                "* Bachelor of Business Administration from St. aloysius College in Human Resources Management/Personnel Administration.\n" +
                "* Currently based in Mumbai, Maharashtra, India.\n" +
                "\n" +
                "I hope this summary is helpful. Please let me know if you have any other questions."
        data_enc["https://www.linkedin.com/in/devang-mody-6922834/"]="Sure, here is the summary of the input text:\n" +
                "\n" +
                "**Job Description:** Devang Mody is the CEO of Bajaj Finserv Health, a health insurance company in India. He is responsible for transforming the company into a full-stack diversified lender leveraging group franchise. He has a strong track record of innovation and has successfully re-modeled global sales finance business for India.\n" +
                "\n" +
                "**Geography and where he lives:** Devang Mody is based in Pune, Maharashtra, India.\n" +
                "\n" +
                "**Interesting characteristics about his profile:**\n" +
                "* He is passionate about solving real-life problems at scale and believes that technology is the big enabler in making this a reality.\n" +
                "* He has a strong track record of innovation and has successfully re-modeled global sales finance business for India.\n" +
                "* He is a strong believer that innovation doesn't need to be brewed in a lab and comes from the most regular processes.\n" +
                "\n" +
                "**For what profile would he be a good match:** Devang Mody would be a good match for a CEO or other senior leadership role in a technology-enabled financial services company. He has a proven track record of innovation and success in this space. He would also be a good fit for a company that is looking to transform its business model or expand into new markets.\n" +
                "\n" +
                "Here are some additional details about Devang Mody's experience:\n" +
                "* He has over 20 years of experience in the financial services industry.\n" +
                "* He has held senior positions at Bajaj Finance Ltd, Reliance Commercial Finance, and PayU.\n" +
                "* He is a graduate of the Wharton School and the Indian Institute of Management, Ahmedabad.\n" +
                "\n" +
                "I hope this summary is helpful. Please let me know if you have any other questions."
            data_enc["https://www.linkedin.com/in/bhattrakesh/"] ="Sure, here is the summary of the input text:\n" +
                    "\n" +
                    "**Job Description:** Executive Director at Bajaj Finance Ltd.\n" +
                    "\n" +
                    "**Geography:** Pune, Maharashtra, India.\n" +
                    "\n" +
                    "**Interesting Characteristics:**\n" +
                    "\n" +
                    "* Over 29 years of experience in the financial services industry.\n" +
                    "* Passionate about leading digital transformations.\n" +
                    "* Proven track record of success in both large enterprises and startups.\n" +
                    "* Strong leadership and management skills.\n" +
                    "* Expertise in team management, vendor management, business analysis, IT strategy, and pre-sales.\n" +
                    "\n" +
                    "**Profile Match:**\n" +
                    "\n" +
                    "Rakesh Bhatt would be a good match for a variety of profiles, including:\n" +
                    "\n" +
                    "* Executive Director\n" +
                    "* Chief Executive Officer\n" +
                    "* Managing Director\n" +
                    "* Head of Digital Transformation\n" +
                    "* Head of IT Strategy\n" +
                    "* Head of Business Analysis\n" +
                    "\n" +
                    "He would also be a good fit for startups that are looking to grow their business through digital transformation.\n" +
                    "\n" +
                    "**Additional Information:**\n" +
                    "\n" +
                    "* Rakesh Bhatt is currently based in Pune, Maharashtra, India.\n" +
                    "* He has a Master's degree in Computer Applications from Gujarat University and a Bachelor's degree in Physics from The Maharaja Sayajirao University of Baroda.\n" +
                    "* He is passionate about using technology to solve real-world problems.\n" +
                    "* He is a strong advocate for continuous learning and innovation.\n" +
                    "\n" +
                    "I hope this summary is helpful. Please let me know if you have any other questions."

        binding.name.text=data?.fullName.toString()
        binding.yourStateProgress.setStateDescriptionData(descriptionData)
        binding.profilePhoto.load(data?.profileImageUrl.toString())
        binding.iid.text=data?.lead_score.toString()
        binding.cName.text=data?.category.toString()
        binding.cTitle.text=data?.query.toString()
        binding.function.text=data?.detailed_leads?.location.toString()
        binding.textView28.text=data?.detailed_leads?.connectionDegree.toString()
        if(data?.email=="nan" || data?.email=="")
        binding.email.text=data?.detailed_leads?.email.toString()
        else
            binding.email.text=data?.email.toString()
        binding.industry.text=data?.detailed_leads?.jobTitle.toString()
        binding.institute.text=data?.additionalInfo.toString()
        binding.keywords.text=data?.url.toString()
        if(data_enc.get(data?.detailed_leads?.linkedinProfileUrl.toString())!=null)
        binding.textvalue1234.text= data_enc.get(data?.detailed_leads?.linkedinProfileUrl.toString())
        else
            binding.textvalue1234.text="Has over 20 years of experience in the tech industry.\n" +
                    "Has a proven track record of driving growth and innovation.\n" +
                    "Is a visionary leader with a deep understanding of the market and customer needs.\n" +
                    "Is highly respected for his integrity, intelligence, and ability to inspire others.\n" +
                    "Has led XYZ Corporation to become a leader in its field, known for cutting-edge technology and exceptional customer service." +"They possess exceptional skills, experience, and leadership qualities.\n" +
                    "They are highly motivated, driven, and goal-oriented.\n" +
                    "They have a deep understanding of their industry and are able to make strategic decisions.\n" +
                    "They are excellent communicators, able to articulate their ideas clearly and persuasively.\n" +
                    "They are highly adaptable, able to navigate change and uncertainty with grace and resilience.\n" +
                    "They inspire and lead others towards a common vision."
        binding.keywords.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(binding.keywords.text.toString())
            startActivity(i)
        }
        binding.name.setOnClickListener {
            val url = data?.detailed_leads?.linkedinProfileUrl.toString() ?: "https:LinkedIn.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        binding.button.setOnClickListener {
            val dialodView = LayoutInflater.from(requireContext()).inflate(R.layout.message_input, null)
            val mBuilder = AlertDialog.Builder(requireContext())
                .setView(dialodView)

            val alertDialog: AlertDialog = mBuilder.create()
            alertDialog.show()
            var text = "Greetings, I would love to explore full time opportunities at your company, could we connect so I can share my resume"
            text=dialodView.findViewById<TextView>(R.id.textvalue).text.toString()
            dialodView.findViewById<Button>(R.id.send_message).setOnClickListener {
                RetrofitClient.init().sendConnection(SendConnection(text,
                    data?.id ?: 0
                )).enqueue(object : Callback<ResponseBody?> {
                    override fun onResponse(
                        call: Call<ResponseBody?>,
                        response: Response<ResponseBody?>
                    ) {
                        if(response.isSuccessful)
                        {
                            Toast.makeText(requireContext(),"Request Sent",Toast.LENGTH_LONG).show()

                        }
                        else
                            Toast.makeText(requireContext(),"Already Connected",Toast.LENGTH_LONG).show()
                        alertDialog.cancel()
                    }

                    override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                        Toast.makeText(requireContext(),"",Toast.LENGTH_LONG).show()
                        alertDialog.cancel()
                    }
                })
            }
        }
        when(data?.state_progress)
        {
            1->binding.yourStateProgress.setCurrentStateNumber(StateProgressBar.StateNumber.ONE)
            2->binding.yourStateProgress.setCurrentStateNumber(StateProgressBar.StateNumber.TWO)
            3->binding.yourStateProgress.setCurrentStateNumber(StateProgressBar.StateNumber.THREE)
            else ->binding.yourStateProgress.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR)
        }

        val data1 = arrayListOf<Pair<String, String>>()

        data1.add(Pair("id", data?.detailed_leads?.id.toString()))
        data1.add(Pair("linkedinProfileUrl",data?.detailed_leads?.linkedinProfileUrl.toString()))
        data1.add(Pair("email", data?.detailed_leads?.email.toString()))
        data1.add(Pair("linkedinProfile", data?.detailed_leads?.linkedinProfile.toString()))
        data1.add(Pair("headline", data?.detailed_leads?.headline.toString()))
        data1.add(Pair("location", data?.location.toString()))
        data1.add(Pair("imgUrl", data?.detailed_leads?.imgUrl.toString()))
        data1.add(Pair("firstName", data?.detailed_leads?.firstName.toString()))
        data1.add(Pair("lastName", data?.detailed_leads?.lastName.toString()))
        data1.add(Pair("fullName", data?.detailed_leads?.fullName.toString()))
        data1.add(Pair("subscribers", data?.detailed_leads?.subscribers.toString()))
        data1.add(Pair("connectionDegree",data?.detailed_leads?.connectionDegree.toString()))
        data1.add(Pair("vmid", data?.detailed_leads?.vmid.toString()))
        data1.add(Pair("userId", data?.detailed_leads?.userId.toString()))
        data1.add(Pair("linkedinSalesNavigatorUrl",data?.detailed_leads?.linkedinSalesNavigatorUrl.toString()))
        data1.add(Pair("connectionsCount",data?.detailed_leads?.connectionsCount.toString()))
        data1.add(Pair("connectionsUrl", data?.detailed_leads?.connectionsUrl.toString()))
        data1.add(Pair("mutualConnectionsUrl", data?.detailed_leads?.mutualConnectionsUrl.toString()))
        data1.add(Pair("mutualConnectionsText", data?.detailed_leads?.mutualConnectionsText.toString()))
        data1.add(Pair("company", data?.detailed_leads?.company.toString()))
        data1.add(Pair("companyUrl", data?.detailed_leads?.companyUrl.toString()))
        data1.add(Pair("jobTitle", data?.detailed_leads?.jobTitle.toString()))
        data1.add(Pair("jobDescription", data?.detailed_leads?.jobDescription.toString()))
        data1.add(Pair("jobLocation", data?.detailed_leads?.jobLocation.toString()))
        data1.add(Pair("jobDateRange", data?.detailed_leads?.jobDateRange.toString()))
        data1.add(Pair("jobDuration", data?.detailed_leads?.jobDuration.toString()))
        data1.add(Pair("company2", data?.detailed_leads?.company2.toString()))
        data1.add(Pair("companyUrl2", data?.detailed_leads?.companyUrl2.toString()))
        data1.add(Pair("jobTitle2",data?.detailed_leads?.jobTitle2.toString()))
        data1.add(Pair("jobDescription2", data?.detailed_leads?.jobDescription2.toString()))
        data1.add(Pair("jobLocation2", data?.detailed_leads?.jobLocation2.toString()))
        data1.add(Pair("jobDateRange2",data?.detailed_leads?.jobDateRange2.toString()))
        data1.add(Pair("jobDuration2", data?.detailed_leads?.jobDuration2.toString()))
        data1.add(Pair("school", data?.detailed_leads?.school.toString()))
        data1.add(Pair("schoolUrl", data?.detailed_leads?.schoolUrl.toString()))
        data1.add(Pair("schoolDegree", data?.detailed_leads?.schoolDegree.toString()))
        data1.add(Pair("schoolDateRange", data?.detailed_leads?.schoolDateRange.toString()))
        data1.add(Pair("school2", data?.detailed_leads?.school2.toString()))
        data1.add(Pair("schoolDegree2", data?.detailed_leads?.schoolDegree2.toString()))
        data1.add(Pair("schoolDateRange2", data?.detailed_leads?.schoolDateRange2.toString()))
        data1.add(Pair("civilityFromDropContact",data?.detailed_leads?.civilityFromDropContact.toString()))
        data1.add(Pair("websiteFromDropContact", data?.detailed_leads?.websiteFromDropContact.toString()))
        data1.add(Pair("companyWebsite", data?.detailed_leads?.companyWebsite.toString()))
        data1.add(Pair("allSkills", data?.detailed_leads?.allSkills.toString()))
        data1.add(Pair("skill1", data?.detailed_leads?.skill1.toString()))
        data1.add(Pair("endorsement1", data?.detailed_leads?.endorsement1.toString()))
        data1.add(Pair("skill2", data?.detailed_leads?.skill2.toString()))
        data1.add(Pair("endorsement2",data?.detailed_leads?.endorsement2.toString()))
        data1.add(Pair("skill3", data?.detailed_leads?.skill3.toString()))
        data1.add(Pair("endorsement3",data?.detailed_leads?.endorsement3.toString()))
        data1.add(Pair("skill4", data?.detailed_leads?.skill4.toString()))
        data1.add(Pair("endorsement4",data?.detailed_leads?.endorsement4.toString()))
        data1.add(Pair("skill5", data?.detailed_leads?.skill5.toString()))
        data1.add(Pair("endorsement5", data?.detailed_leads?.endorsement5.toString()))
        data1.add(Pair("skill6", data?.detailed_leads?.skill6.toString()))
        data1.add(Pair("endorsement6", data?.detailed_leads?.endorsement6.toString()))
        data1.add(Pair("baseUrl", data?.detailed_leads?.baseUrl.toString()))
        data1.add(Pair("profileId",data?.detailed_leads?.profileId.toString()))
        data1.add(Pair("timestamp", data?.detailed_leads?.timestamp.toString()))
        data1.add(Pair("description", data?.detailed_leads?.description.toString()))
        data1.add(Pair("schoolUrl2", data?.detailed_leads?.schoolUrl2.toString()))
        data1.add(Pair("website", data?.detailed_leads?.website.toString()))
        data1.add(Pair("birthday", data?.detailed_leads?.birthday.toString()))
        data1.add(Pair("mail", data?.detailed_leads?.mail.toString()))
        data1.add(Pair("schoolDescription", data?.detailed_leads?.schoolDescription.toString()))
        data1.add(Pair("twitter", data?.detailed_leads?.twitter.toString()))
        data1.add(Pair("twitterProfileUrl", data?.detailed_leads?.twitterProfileUrl.toString()))
        data1.add(Pair("mailFromDropcontact", data?.detailed_leads?.mailFromDropcontact.toString()))
        data1.add(Pair("qualificationFromDropContact",data?.detailed_leads?.qualificationFromDropContact.toString()))

       var  adapter= EnrichedDataAdapter(data1)
        var layout = LinearLayoutManager(
            container?.context,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.enrichedRecyclerView.adapter=adapter
        binding.enrichedRecyclerView.layoutManager=layout



        return binding.root
    }


}