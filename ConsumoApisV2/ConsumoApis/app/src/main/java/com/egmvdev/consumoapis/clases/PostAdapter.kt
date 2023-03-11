package com.egmvdev.consumoapis.clases

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.consumoapis.R
import com.egmvdev.consumoapis.model.Post
import com.egmvdev.consumoapis.model.PostResponse

class PostAdapter(val post: List<PostResponse>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return  PostViewHolder(inflador.inflate(R.layout.itempost,parent,false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(post[position])
    }

    override fun getItemCount(): Int = post.size
}