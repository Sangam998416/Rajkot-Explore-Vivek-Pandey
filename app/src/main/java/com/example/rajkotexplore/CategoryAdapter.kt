package com.example.rajkotexplore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    private val context: Context,
    private val categories: List<CategoryItem>
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgCategory: ImageView = view.findViewById(R.id.imgCategory)
        val txtCategoryName: TextView = view.findViewById(R.id.txtCategoryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]

        holder.imgCategory.setImageResource(category.image)
        holder.txtCategoryName.text = category.name

        // Click listener to open CategoryDetailActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CategoryDetailActivity::class.java)
            intent.putExtra("CATEGORY_NAME", category.name)
            intent.putExtra("CATEGORY_TYPE", category.category)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = categories.size
}