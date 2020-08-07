package com.example.apaini.data.model

import com.google.gson.annotations.SerializedName

class ArtikelModel {
    @SerializedName("articles")
    var list : MutableList<List>? = null
}

class List(){
    @SerializedName("title")
    var title : String = ""
    @SerializedName("description")
    var description : String = ""
    @SerializedName("urlToImage")
    var imageUrl : String = ""
    @SerializedName("url")
    var url : String = ""
    @SerializedName("author")
    var author : String = ""
    @SerializedName("content")
    var content : String = ""
}