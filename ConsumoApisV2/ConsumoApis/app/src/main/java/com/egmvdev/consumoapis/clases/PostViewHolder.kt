package com.egmvdev.consumoapis.clases

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.consumoapis.databinding.ItempostBinding
import com.egmvdev.consumoapis.model.Post
import com.egmvdev.consumoapis.model.PostResponse

class PostViewHolder(vista:View):RecyclerView.ViewHolder(vista) {
    private val bind= ItempostBinding.bind(vista)
    fun bind(post:PostResponse){
        bind.tvTitle.text = post.title
        bind.tvCuerpo.text = post.body
    }
}