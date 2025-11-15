package com.example.rajkotexplore.nearby

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R
import com.google.android.material.chip.Chip

class CourseAdapter(private val courses: List<Course>) :
    RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseName: TextView = itemView.findViewById(R.id.txtCourseName)
        val courseDegree: Chip = itemView.findViewById(R.id.chipDegree)
        val courseDuration: TextView = itemView.findViewById(R.id.txtDuration)
        val courseFees: TextView = itemView.findViewById(R.id.txtFees)
        val courseEligibility: TextView = itemView.findViewById(R.id.txtEligibility)
        val courseSeats: TextView = itemView.findViewById(R.id.txtSeats)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.courseName.text = course.name
        holder.courseDegree.text = course.degree
        holder.courseDuration.text = "Duration: ${course.duration}"
        holder.courseFees.text = "Fees: ${course.feesPerYear}/year"
        holder.courseEligibility.text = "Eligibility: ${course.eligibility}"

        if (course.seats > 0) {
            holder.courseSeats.text = "Seats: ${course.seats}"
            holder.courseSeats.visibility = View.VISIBLE
        } else {
            holder.courseSeats.visibility = View.GONE
        }
    }

    override fun getItemCount() = courses.size
}