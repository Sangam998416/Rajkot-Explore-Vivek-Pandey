package com.example.rajkotexplore.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

class EventAdapter(private val items: List<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.itemImage)
        val title: TextView = itemView.findViewById(R.id.itemTitle)
        val date: TextView = itemView.findViewById(R.id.itemDate)
        val venue: TextView = itemView.findViewById(R.id.itemVenue)
        val desc: TextView = itemView.findViewById(R.id.itemDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_event_item, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val item = items[position]
        holder.img.setImageResource(item.image)
        holder.title.text = item.title
        holder.date.text = "${item.date}"
        holder.venue.text = "${item.venue}"
        holder.desc.text = "${item.desc}"
    }

    override fun getItemCount(): Int = items.size
}

