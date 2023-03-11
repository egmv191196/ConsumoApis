package com.example.consumoapis.classes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.consumoapis.databinding.ItemPerroBinding
import com.squareup.picasso.Picasso

class PerroViewHolder(vista : View) : RecyclerView.ViewHolder(vista) {

    private val binding = ItemPerroBinding.bind(vista)
    fun bind(imagen : String){
        Picasso
            .get()
            .load(imagen)
            .into(binding.ivPerro)
    }



}