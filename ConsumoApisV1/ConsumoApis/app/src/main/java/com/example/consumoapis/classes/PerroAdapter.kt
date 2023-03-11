package com.example.consumoapis.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.consumoapis.R

class PerroAdapter(val imagenes:List<String>) : RecyclerView.Adapter<PerroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerroViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return PerroViewHolder(inflador.inflate(R.layout.item_perro, parent, false))
    }

    override fun onBindViewHolder(holder: PerroViewHolder, position: Int) {
        holder.bind(imagenes[position])
    }

    override fun getItemCount(): Int {
        return imagenes.size
    }
}