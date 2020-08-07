package com.example.apaini.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.apaini.R
import com.example.apaini.data.model.ArtikelModel
import com.example.apaini.rest.ApiClient
import com.example.apaini.rest.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var adapter = AdapterArtikel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mLayoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerView.run {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            adapter = this@MainActivity.adapter
            isNestedScrollingEnabled = true
        }

        refresh()

    }

    fun refresh(){
        showLoading(true)
        val baseUrl = "http://newsapi.org/v2/"
        val apiClient = ApiClient.createServiceWithLoggingIntercpetor(
            baseUrl,
            HttpLoggingInterceptor.Level.BODY,
            30000L,
            ApiInterface::class.java)

        apiClient.getArticle(
            "id",
            "9e2edb9742b649c78eb9c1e40938b1b5")
            .enqueue(object : Callback<ArtikelModel>{
                override fun onFailure(call: Call<ArtikelModel>, t: Throwable) {
                    Log.d("response API", t.toString())
                    showLoading(false)
                }

                override fun onResponse(
                    call: Call<ArtikelModel>,
                    response: Response<ArtikelModel>
                ) {
                    val data = response.body()?.list!!
                    Log.d("response API", data.size.toString())
                    showLoading(false)
                    adapter.update(data)
                }

            })
    }

    fun showLoading(show : Boolean) {
        if(show){
            progressBar.visibility = View.VISIBLE
        } else progressBar.visibility = View.GONE
    }

    override fun onStart() {
        super.onStart()
    }
}