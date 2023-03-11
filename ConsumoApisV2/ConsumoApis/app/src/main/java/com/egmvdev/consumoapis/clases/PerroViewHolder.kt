package com.egmvdev.consumoapis.clases

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.consumoapis.databinding.ItemperroBinding
import com.squareup.picasso.Picasso

class PerroViewHolder(vista:View):RecyclerView.ViewHolder(vista) {
    private val bind = ItemperroBinding.bind(vista)
    fun bind(imagen:String){
        Picasso.get().load(imagen).into(bind.ivPerro)
    }
}