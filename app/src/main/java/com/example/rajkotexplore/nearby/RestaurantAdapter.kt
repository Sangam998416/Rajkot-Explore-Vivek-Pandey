package com.example.rajkotexplore.nearby

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

class RestaurantAdapter(private val places: List<RestaurantPlace>) :
    RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val placeImage: ImageView = itemView.findViewById(R.id.ivPlace)
        val placeTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val placeLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val placeDistance: TextView = itemView.findViewById(R.id.tvDistance)
        val placeDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_religious, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val place = places[position]
        holder.placeImage.setImageResource(place.imageRestaurant)
        holder.placeTitle.text = place.title
        holder.placeLocation.text = place.location
        holder.placeDistance.text = place.distance
        holder.placeDescription.text = place.description
    }

    override fun getItemCount(): Int = places.size
}