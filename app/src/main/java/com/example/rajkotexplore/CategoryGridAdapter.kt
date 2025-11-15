package com.example.rajkotexplore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryGridAdapter(
    private val context: Context,
    private val items: List<CardItem>,
    private val category: String
) : RecyclerView.Adapter<CategoryGridAdapter.GridViewHolder>() {

    class GridViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgCard: ImageView = view.findViewById(R.id.imgCard)
        val txtTitle: TextView = view.findViewById(R.id.txtTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_grid, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val item = items[position]

        holder.imgCard.setImageResource(item.imageRes?:0)
        holder.txtTitle.text = item.title

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

    override fun getItemCount() = items.size
}