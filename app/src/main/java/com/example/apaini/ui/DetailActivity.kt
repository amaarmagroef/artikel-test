package com.example.apaini.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.apaini.R
import com.example.apaini.data.model.List
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val stringJson  = intent.getStringExtra("data")
        val data = Gson().fromJson<List>(stringJson, List::class.java)
        Glide.with(this)
            .load(data.imageUrl)
            .into(image)
        description.text = data.description
        content.text = data.content
        author.text = data.author
        titles.text = data.title
    }
}