package com.example.rajkotexplore.nearby

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

class UniversityAdapter(private val universityList: List<UniversityItem>) :
    RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder>() {

    class UniversityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imgUniversity)
        val nameView: TextView = itemView.findViewById(R.id.txtUniversityName)
        val descView: TextView = itemView.findViewById(R.id.txtUniversityDesc)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_university, parent, false)
        return UniversityViewHolder(view)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val item = universityList[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.nameView.text = item.name
        holder.descView.text = item.description
    }

    override fun getItemCount(): Int = universityList.size
}