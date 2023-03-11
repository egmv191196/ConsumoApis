package com.example.consumoapis.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.consumoapis.R
import com.example.consumoapis.databinding.ItemQuoteBinding
import com.example.consumoapis.model.QuoteElement

class QuoteAdapter (private val quotesList : List<QuoteElement>) : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    inner class QuoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemQuoteBinding.bind(view)

        fun bind(quote: QuoteElement) {
            binding.tvAuthor.text = quote.author
            binding.tvParrafo.text = quote.en
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return QuoteViewHolder(inflador.inflate(R.layout.item_quote, parent, false))
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(quotesList[position])
    }

    override fun getItemCount(): Int {
        return quotesList.size
    }
}