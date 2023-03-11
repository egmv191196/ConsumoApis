package com.egmvdev.consumoapis.clases

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.consumoapis.R

class PerroAdapter(val imagenes: List<String>):RecyclerView.Adapter<PerroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerroViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return  PerroViewHolder(inflador.inflate(R.layout.itemperro,parent,false))
    }

    override fun onBindViewHolder(holder: PerroViewHolder, position: Int) {
        holder.bind(imagenes[position])
    }

    override fun getItemCount(): Int = imagenes.size
}