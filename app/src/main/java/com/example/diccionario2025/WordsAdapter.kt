package com.example.diccionario2025

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class WordsAdapter(private val mList: List<WorldViewModel>) : RecyclerView.Adapter<WordsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_words, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemViewModel = mList[position]
        holder.entrataTextView.text = ItemViewModel.entrada
        holder.superindiceTextView.text = ItemViewModel.superIndice
        holder.acepcionesTextView.text = ItemViewModel.acepciones
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        var entrataTextView: TextView = itemView.findViewById(R.id.entrada_text)
        var superindiceTextView: TextView = itemView.findViewById(R.id.superIndice_text)
        var acepcionesTextView: TextView = itemView.findViewById(R.id.acepciones_text)

    }
}