package id.kotlin.gnews.fragment.recycleviewUpcoming

import android.content.Intent
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.gnews.R
import id.kotlin.gnews.detailactivity


class upcomingAdapter (private val upcominglist : ArrayList<dataclassUpcoming>)
    : RecyclerView.Adapter<upcomingAdapter.upcomingviewholder>() {

    class upcomingviewholder(view : View) : RecyclerView.ViewHolder(view) {
        val tvrc : TextView = view.findViewById(R.id.tvrc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): upcomingviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_upcoming , parent , false)
        return upcomingviewholder(view)
    }

    override fun onBindViewHolder(holder: upcomingviewholder, position: Int) {
        val data = upcominglist[position]
        holder.tvrc.text = data.tvrc
        holder.tvrc.setOnClickListener{
            val intent = Intent(holder.tvrc.context, detailactivity::class.java)
            intent.putExtra("judul" , data.judul)
            intent.putExtra("img" , data.img)
            intent.putExtra("konten" , data.konten)
            holder.tvrc.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return upcominglist.size
    }

}