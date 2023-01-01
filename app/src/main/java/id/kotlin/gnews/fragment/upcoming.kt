package id.kotlin.gnews.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.gnews.R
import id.kotlin.gnews.fragment.recycleviewNews.APInews
import id.kotlin.gnews.fragment.recycleviewNews.dataclassnews
import id.kotlin.gnews.fragment.recycleviewNews.newsAdapter
import id.kotlin.gnews.fragment.recycleviewUpcoming.APIupcoming
import id.kotlin.gnews.fragment.recycleviewUpcoming.dataclassUpcoming
import id.kotlin.gnews.fragment.recycleviewUpcoming.upcomingAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class upcoming : Fragment() {

    //recycleview
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: upcomingAdapter
    lateinit var data : ArrayList<dataclassUpcoming>

    //API
    val apikey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im1ub2Fldm9hcWJuY2hmdXVxeWhrIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA5ODMxODIsImV4cCI6MTk4NjU1OTE4Mn0.xZxCW_G2-ZR3rknP2Mz3s2VQc-IBYqZTmQgUbFRXkgU"
    val token = "Bearer $apikey"
    val api = RetrofitHelper.getInstance().create(APIupcoming::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_upcoming, container, false)


        recyclerView = view.findViewById(R.id.rcupcoming)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
        CoroutineScope(Dispatchers.Main).launch {
            data = ArrayList()
            val response = api.get(token = token , apiKey = apikey)
            response.body()?.forEach {
                data.add(
                    dataclassUpcoming(
                        img = it.img,
                        judul = it.game,
                        konten = it.description,
                        tvrc = it.title
                )
                )
            }
            adapter = upcomingAdapter(data)
            recyclerView.adapter = adapter
        }



        return view
    }
}