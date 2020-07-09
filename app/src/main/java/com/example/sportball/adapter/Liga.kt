package com.example.sportball.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import anko.Item
import coil.api.load
import com.example.sportball.R
import com.example.sportball.model.DataLiga
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class Liga(private val dataLiga: List<DataLiga>, private val listener: (DataLiga) -> Unit) :
    RecyclerView.Adapter<Liga.LigaViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LigaViewholder =
        LigaViewholder(Item().createView(AnkoContext.create(parent.context, parent)))

    override fun getItemCount(): Int = dataLiga.size

    override fun onBindViewHolder(holder: LigaViewholder, position: Int) {
        holder.bindView(dataLiga[position], listener)
    }

    class LigaViewholder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val logo = itemView.find<ImageView>(R.id.itemLogo)
        val title = itemView.find<TextView>(R.id.itemTitle)

        fun bindView(getDataLiga: DataLiga, listener: (DataLiga) -> Unit) {
            getDataLiga.logo?.let { logo.load(it) }
            title.text = getDataLiga.name

            itemView.setOnClickListener { listener(getDataLiga) }
        }
    }
}