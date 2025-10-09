package com.example.rajkotexplore.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

class ExhibitionFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = EventAdapter(listOf(
            Event(R.drawable.ex1, "Engiexpo Rajkot 2025", "24-Oct-2025", "Rajkot", "Music Festival"),
            Event(R.drawable.ex2, "Swayamvar Rajkot", "03 Jan ", "Rajkot", "It is a remarkable event set to take place")
        ))
        return view
    }
}
