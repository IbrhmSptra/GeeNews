package id.kotlin.gnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class detailactivity : AppCompatActivity() {

    lateinit var imgContent : ImageView
    lateinit var tvContent : TextView
    lateinit var tvJudul : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //get value intent
        val img = intent.getStringExtra("img")
        val konten = intent.getStringExtra("konten")
        val judul = intent.getStringExtra("judul")

        //initilized
        imgContent = findViewById(R.id.img_content)
        tvContent = findViewById(R.id.tv_content)
        tvJudul = findViewById(R.id.tv_judul)

        //set isi
        Glide.with(this).load(img).into(imgContent)
        tvJudul.text = judul
        tvContent.text = konten

    }
}