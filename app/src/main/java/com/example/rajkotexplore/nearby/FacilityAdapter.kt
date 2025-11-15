package com.example.rajkotexplore.nearby

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

class FacilityAdapter(private val facilities: List<String>) :
    RecyclerView.Adapter<FacilityAdapter.FacilityViewHolder>() {

    class FacilityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val facilityText: TextView = itemView.findViewById(R.id.txtFacility)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacilityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_facility, parent, false)
        return FacilityViewHolder(view)
    }

    override fun onBindViewHolder(holder: FacilityViewHolder, position: Int) {
        holder.facilityText.text = "✓ ${facilities[position]}"
    }

    override fun getItemCount() = facilities.size
}