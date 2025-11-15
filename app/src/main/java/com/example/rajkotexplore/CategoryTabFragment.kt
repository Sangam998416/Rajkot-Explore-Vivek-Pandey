package com.example.rajkotexplore.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

class CategoryTabFragment : Fragment() {

    private lateinit var categoryType: String
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryEventAdapter

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String): CategoryTabFragment {
            val fragment = CategoryTabFragment()
            val args = Bundle()
            args.putString(ARG_CATEGORY, category)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryType = arguments?.getString(ARG_CATEGORY) ?: "garbha"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category_tab, container, false)

        recyclerView = view.findViewById(R.id.categoryRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Load data based on category type
        loadCategoryData()

        return view
    }

    private fun loadCategoryData() {
        // Use getEventsByCategory to load events for this category
        val events = CategoryDataProvider.getEventsByCategory(categoryType)

        adapter = CategoryEventAdapter(events)
        recyclerView.adapter = adapter
    }
}