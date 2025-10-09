    package com.example.rajkotexplore.event

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.Fragment
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.example.rajkotexplore.R

    class CulturalFragment : Fragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val view = inflater.inflate(R.layout.fragment_event, container, false)
            val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)

            recycler.layoutManager = LinearLayoutManager(requireContext())
            recycler.adapter = EventAdapter(listOf(
                Event(R.drawable.cul1, "International Kite Festival", "14 Jan", "Rajkot", "The flourishing city of Rajkot which is located in Gujarat."),
                Event(R.drawable.cul2, "Navratri Festival", "22-Sep-2025", "Rajkot", "one festival that truly stands out and has gained popularity.")
            ))
            return view
        }
    }
