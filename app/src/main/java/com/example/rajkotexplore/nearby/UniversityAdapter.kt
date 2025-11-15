package com.example.rajkotexplore.nearby

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R
import com.google.android.material.chip.Chip

class UniversityAdapter(private val universityList: List<University>) :
    RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder>() {

    class UniversityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imgUniversity)
        val nameView: TextView = itemView.findViewById(R.id.txtUniversityName)
        val descView: TextView = itemView.findViewById(R.id.txtUniversityDesc)
        val typeChip: Chip = itemView.findViewById(R.id.chipUniversityType)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingUniversity)
        val establishedView: TextView = itemView.findViewById(R.id.txtEstablished)
        val admissionStatusView: TextView = itemView.findViewById(R.id.txtAdmissionStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_university, parent, false)
        return UniversityViewHolder(view)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val university = universityList[position]
        val context = holder.itemView.context

        holder.imageView.setImageResource(university.imageResId)
        holder.nameView.text = university.name
        holder.descView.text = university.description
        holder.typeChip.text = university.type
        holder.establishedView.text = "Est. ${university.established}"

        // Set rating
        if (university.rating > 0) {
            holder.ratingBar.rating = university.rating
            holder.ratingBar.visibility = View.VISIBLE
        } else {
            holder.ratingBar.visibility = View.GONE
        }

        // Set admission status
        if (university.admissionStatus.isOpen) {
            holder.admissionStatusView.text = "Admissions Open"
            holder.admissionStatusView.setTextColor(context.getColor(android.R.color.holo_green_dark))
        } else {
            holder.admissionStatusView.text = "Admissions Closed"
            holder.admissionStatusView.setTextColor(context.getColor(android.R.color.holo_red_dark))
        }

        // Set type chip color
        if (university.type == "Government") {
            holder.typeChip.setChipBackgroundColorResource(android.R.color.holo_blue_light)
        } else {
            holder.typeChip.setChipBackgroundColorResource(android.R.color.holo_orange_light)
        }

        // Click listener to open detail page
        holder.itemView.setOnClickListener {
            val intent = Intent(context, UniversityDetailActivity::class.java)
            intent.putExtra("UNIVERSITY_ID", university.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = universityList.size
}