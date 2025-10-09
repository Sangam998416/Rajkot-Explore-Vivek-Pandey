package com.example.rajkotexplore.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

class ConcertFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = EventAdapter(listOf(
            Event(R.drawable.c1, "Sahiyar Club Navratri", "24-09 to 01-10-2025", "Rajkot", "08:00 pm to 12:00 pm"),
            Event(R.drawable.c2, "Bamboo Beats Mahotsav", "27-09 to 02-10-2025", "Rajkot", "07:10 pm to 11:00 pm"),
            Event(R.drawable.c3, "Abtak SURBHI Rasotsav", "27-09 to 30-09-2025", "Rajkot", "08:45 pm"),
            Event(R.drawable.c4, "Sanatan Navratri Utsav", "22-09 to 02-09-2025", "Rajkot", "08:00 pm")
        ))
        return view
    }
}
