package com.example.rajkotexplore.nearby

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

class ParkAdapter(private val places: List<ParkPlace>) :
    RecyclerView.Adapter<ParkAdapter.ParkViewHolder>() {

    class ParkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val placeImage: ImageView = itemView.findViewById(R.id.ivPlace)
        val placeTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val placeLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val placeDistance: TextView = itemView.findViewById(R.id.tvDistance)
        val placeDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_park, parent, false)
        return ParkViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        val place = places[position]
        holder.placeImage.setImageResource(place.imageRes)
        holder.placeTitle.text = place.title
        holder.placeLocation.text = place.location
        holder.placeDistance.text = place.distance
        holder.placeDescription.text = place.description
    }

    override fun getItemCount(): Int = places.size
}