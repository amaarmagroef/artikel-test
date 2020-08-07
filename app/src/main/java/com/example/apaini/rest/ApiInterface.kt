package com.example.apaini.rest

import com.example.apaini.data.model.ArtikelModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    companion object {
        const val suffix_top_headlines = "top-headlines"
    }

    @GET(suffix_top_headlines)
    fun getArticle(@Query("country") country : String,
                   @Query("apiKey") apikey : String) : Call<ArtikelModel>
}