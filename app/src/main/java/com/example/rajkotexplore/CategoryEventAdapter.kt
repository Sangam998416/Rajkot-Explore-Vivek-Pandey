package com.example.rajkotexplore.category

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.EventDetailActivity
import com.example.rajkotexplore.R

class CategoryEventAdapter(
    private val events: List<CategoryEvent>
) : RecyclerView.Adapter<CategoryEventAdapter.EventViewHolder>() {

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.itemImage)
        val title: TextView = itemView.findViewById(R.id.itemTitle)
        val date: TextView = itemView.findViewById(R.id.itemDate)
        val venue: TextView = itemView.findViewById(R.id.itemVenue)
        val time: TextView = itemView.findViewById(R.id.itemDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_event_item, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        val context = holder.itemView.context

        // Bind data to views
        holder.image.setImageResource(event.image)
        holder.title.text = event.title
        holder.date.text = event.date
        holder.venue.text = event.venue
        holder.time.text = event.time

        // Click listener to open EventDetailActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, EventDetailActivity::class.java).apply {
                // Pass all event data
                putExtra("EVENT_TITLE", event.title)
                putExtra("EVENT_ORGANIZER", event.organizer)
                putExtra("EVENT_CATEGORY", event.category)
                putExtra("EVENT_DATE", event.date)
                putExtra("EVENT_TIME", event.time)
                putExtra("EVENT_VENUE", event.venue)
                putExtra("EVENT_PRICE", event.price)
                putExtra("EVENT_DESCRIPTION", event.description)
                putExtra("EVENT_IMAGE", event.image)
                putExtra("EVENT_LATITUDE", event.latitude)
                putExtra("EVENT_LONGITUDE", event.longitude)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = events.size
}