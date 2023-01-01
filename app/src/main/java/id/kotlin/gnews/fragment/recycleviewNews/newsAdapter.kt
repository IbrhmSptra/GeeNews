package id.kotlin.gnews.fragment.recycleviewNews

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.kotlin.gnews.R
import id.kotlin.gnews.detailactivity

class newsAdapter (private val newslist : ArrayList<dataclassnews>)
    : RecyclerView.Adapter<newsAdapter.newsviewholder>() {

    class newsviewholder(view : View) : RecyclerView.ViewHolder(view) {
        val imgrc : ImageView = view.findViewById(R.id.imgnews)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news , parent , false)
        return newsviewholder(view)
    }

    override fun onBindViewHolder(holder: newsviewholder, position: Int) {
        val data = newslist[position]
        Glide.with(holder.imgrc.context).load(data.imgrc).into(holder.imgrc)
        holder.imgrc.setOnClickListener {
            val intent = Intent(holder.imgrc.context , detailactivity::class.java)
            intent.putExtra("judul" , data.judul)
            intent.putExtra("img" , data.img)
            intent.putExtra("konten" , data.konten)
            holder.imgrc.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return newslist.size
    }

}