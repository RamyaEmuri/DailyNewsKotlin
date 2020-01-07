package com.example.dailynewskotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dailynewskotlin.R
import com.example.dailynewskotlin.adapters.AdapterTwo.ViewHolder
import com.example.dailynewskotlin.view.Test

class AdapterTwo(private var dataList: List<Test.Response.Doc>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_2, parent, false))
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val modelObj = dataList.get(position)

        modelObj.headline.main
        holder.headline.text = modelObj.headline.toString()
        holder.date.text = modelObj.pub_date
        if (modelObj.multimedia.isNotEmpty())
            Glide.with(holder.image.context)
                .load("https://www.nytimes.com/${modelObj.multimedia[0].url}")
                .into(holder.image)

    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item){

        var image: ImageView
        var headline: TextView
        var date: TextView

        init {
            image = item.findViewById(R.id.headImage)
            headline = item.findViewById(R.id.headLineText)
            date = item.findViewById(R.id.dateText)
        }
    }
}
