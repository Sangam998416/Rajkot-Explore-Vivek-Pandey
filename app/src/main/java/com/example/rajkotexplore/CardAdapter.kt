package com.example.rajkotexplore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rajkotexplore.nearby.NearbyActivity
import com.example.rajkotexplore.nearby.ParkActivity
import com.example.rajkotexplore.nearby.RestaurantActivity
import com.example.rajkotexplore.nearby.TouristActivity

class CardAdapter(
    private val context: Context,
    private val fullList: List<CardItem>,
    private val category: String
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private var filteredList: MutableList<CardItem> = fullList.toMutableList()

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        val itemTitle: TextView = itemView.findViewById(R.id.itemTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = filteredList[position]
        holder.itemTitle.text = item.title

        when {
            item.imageRes != null -> {
                holder.itemImage.visibility = View.VISIBLE
                holder.itemImage.setImageResource(item.imageRes)
            }
            !item.imageUrl.isNullOrEmpty() -> {
                holder.itemImage.visibility = View.VISIBLE
                Glide.with(holder.itemView.context)
                    .load(item.imageUrl)
                    .into(holder.itemImage)
            }
            else -> {
                holder.itemImage.visibility = View.GONE
            }
        }

        // Handle click based on category
        holder.itemView.setOnClickListener {
            when (category) {
                "events" -> context.startActivity(Intent(context, CategoryActivity::class.java))
                "nearby" -> context.startActivity(Intent(context, NearbyActivity::class.java))
                "nature" -> context.startActivity(Intent(context, ParkActivity::class.java))
                "restaurants" -> context.startActivity(Intent(context, RestaurantActivity::class.java))
                "heritage" -> context.startActivity(Intent(context, TouristActivity::class.java))
                "university" -> context.startActivity(Intent(context, TouristActivity::class.java))
            }
        }
    }

    override fun getItemCount(): Int = filteredList.size

    // Filter function
    fun filter(query: String) {
        val lowerQuery = query.lowercase().trim()
        filteredList = if (lowerQuery.isEmpty()) {
            fullList.toMutableList()
        } else {
            fullList.filter {
                it.title.lowercase().contains(lowerQuery)
            }.toMutableList()
        }
        notifyDataSetChanged()
    }
}
