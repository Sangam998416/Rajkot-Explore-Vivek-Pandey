package com.example.rajkotexplore.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

class FairsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = EventAdapter(listOf(
            Event(R.drawable.f1, "Royal Mela Rajkot", "14-08-2025 to 18-08-2025", "Rajkot", "an annual fair in Rajkot that features rides, attractions"),
            Event(R.drawable.f2, "Janmashtami Lok Mela", "16-08-2025", "Rajkot", "The most famous of these fairs is the one held in Rajkot.")
        ))
        return view
    }
}
