package com.example.rajkotexplore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(
    private val context: Context,
    private val items: List<CardItem>,
    private val category: String
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>(), Filterable {

    private var filteredItems = items

    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgCard: ImageView = view.findViewById(R.id.imgCard)
        val txtTitle: TextView = view.findViewById(R.id.txtTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = filteredItems[position]
        holder.imgCard.setImageResource(item.imageRes ?: 0)
        holder.txtTitle.text = item.title

        // Add click listener to open PlaceDetailActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, PlaceDetailActivity::class.java)
            intent.putExtra("PLACE_IMAGE", item.imageRes)
            intent.putExtra("PLACE_TITLE", item.title)
            intent.putExtra("PLACE_CATEGORY", category)
            intent.putExtra("PLACE_DESCRIPTION", item.description)
            intent.putExtra("PLACE_LOCATION", item.location)
            intent.putExtra("PLACE_TIMING", item.timing)
            intent.putExtra("PLACE_LATITUDE", item.latitude)
            intent.putExtra("PLACE_LONGITUDE", item.longitude)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = filteredItems.size

    /**
     * Enhanced filter function that searches across multiple fields
     * Returns true if results found, false if no results
     */
    fun filter(query: String): Boolean {
        val searchQuery = query.trim()

        filteredItems = if (searchQuery.isEmpty()) {
            items
        } else {
            items.filter { item ->
                // Search in title
                item.title.contains(searchQuery, ignoreCase = true) ||
                        // Search in description
                        item.description?.contains(searchQuery, ignoreCase = true) == true ||
                        // Search in location
                        item.location?.contains(searchQuery, ignoreCase = true) == true ||
                        // Search in timing
                        item.timing?.contains(searchQuery, ignoreCase = true) == true
            }
        }

        notifyDataSetChanged()
        return filteredItems.isNotEmpty()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint?.toString() ?: ""
                filteredItems = if (query.isEmpty()) {
                    items
                } else {
                    items.filter { item ->
                        // Search across all fields
                        item.title.contains(query, ignoreCase = true) ||
                                item.description?.contains(query, ignoreCase = true) == true ||
                                item.location?.contains(query, ignoreCase = true) == true ||
                                item.timing?.contains(query, ignoreCase = true) == true
                    }
                }
                return FilterResults().apply { values = filteredItems }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                notifyDataSetChanged()
            }
        }
    }

    /**
     * Get the count of currently filtered items
     */
    fun getFilteredCount(): Int = filteredItems.size
}