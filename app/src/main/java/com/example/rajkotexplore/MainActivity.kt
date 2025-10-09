package com.example.rajkotexplore

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.more.MoreActivity
import com.example.rajkotexplore.settings.LogoActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var eventsAdapter: CardAdapter
    private lateinit var nearbyAdapter: CardAdapter
    private lateinit var natureAdapter: CardAdapter
    private lateinit var restaurantsAdapter: CardAdapter
    private lateinit var heritageAdapter: CardAdapter
    private lateinit var universityAdapter: CardAdapter

    private lateinit var eventsList: List<CardItem>
    private lateinit var nearbyList: List<CardItem>
    private lateinit var natureList: List<CardItem>
    private lateinit var restaurantsList: List<CardItem>
    private lateinit var heritageList: List<CardItem>
    private lateinit var universityList: List<CardItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Settings button
        val imgsettings = findViewById<ImageView>(R.id.imgSettings)
        imgsettings.setOnClickListener {
            startActivity(Intent(this, LogoActivity::class.java))
        }

        // Bottom Navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> startActivity(Intent(this, MainActivity::class.java))
                R.id.nav_category -> startActivity(Intent(this, CategoryActivity::class.java))
                R.id.nav_map -> Toast.makeText(this, "Map Clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_more -> startActivity(Intent(this, MoreActivity::class.java))
            }
            true
        }

        // Initialize lists
        eventsList = listOf(
            CardItem(R.drawable.e1, title = "Music Fest"),
            CardItem(R.drawable.e2, title = "Kite Festival"),
            CardItem(R.drawable.e3, title = "Garba Fest"),
            CardItem(R.drawable.e4, title = "Dubai Real Estate Event"),
            CardItem(R.drawable.e5, title = "Sangeet Mai Zaroor Aana")
        )

        nearbyList = listOf(
            CardItem(R.drawable.p1, title = "Ranjit Vilas Palace"),
            CardItem(R.drawable.p2, title = "KHIRASARA PALACE"),
            CardItem(R.drawable.p3, title = "Kaba Gandhi No Delo"),
            CardItem(R.drawable.p4, title = "Watson Museum"),
            CardItem(R.drawable.p5, title = "Rotary Dolls Museum")
        )

        natureList = listOf(
            CardItem(R.drawable.n1, title = "Pradhyuman Zoological Park"),
            CardItem(R.drawable.n2, title = "Lalpari Lake"),
            CardItem(R.drawable.n3, title = "Nyari Dam"),
            CardItem(R.drawable.n4, title = "Aji Dam"),
            CardItem(R.drawable.n5, title = "Atal Sarowar")
        )

        restaurantsList = listOf(
            CardItem(R.drawable.r1, title = "Waves Restaurant"),
            CardItem(R.drawable.r2, title = "The Grand Thakar"),
            CardItem(R.drawable.r3, title = "Saraza Restaurant"),
            CardItem(R.drawable.r4, title = "Lords Banquet Restaurant"),
            CardItem(R.drawable.r5, title = "Gordhan Thal")
        )

        heritageList = listOf(
            CardItem(R.drawable.h1, title = "Watson Museum"),
            CardItem(R.drawable.h2, title = "Ranjit Vilas Palace"),
            CardItem(R.drawable.h3, title = "Mahatma Gandhi Museum"),
            CardItem(R.drawable.h4, title = "Jubilee Garden Library"),
            CardItem(R.drawable.h5, title = "Jam Tower")
        )

        universityList = listOf(
            CardItem(R.drawable.mu_fest, title = "MU Fest, Marwadi University"),
            CardItem(R.drawable.mu_ganesh, title = "Ganesh Utsav, Marwadi University"),
            CardItem(R.drawable.mu1, title = "Krishna Janmashtami"),
            CardItem(R.drawable.mu_garbha, title = "Mu Garbha Night"),
            CardItem(R.drawable.mu_tech, title = "Mu Non Technical Event")
        )

        // Setup RecyclerViews with category
        eventsAdapter = setupRecycler(R.id.rvEvents, eventsList, "events")
        nearbyAdapter = setupRecycler(R.id.rvNearbyPlaces, nearbyList, "nearby")
        natureAdapter = setupRecycler(R.id.rvNature, natureList, "nature")
        restaurantsAdapter = setupRecycler(R.id.rvRestaurants, restaurantsList, "restaurants")
        heritageAdapter = setupRecycler(R.id.rvHaritage, heritageList, "heritage")
        universityAdapter = setupRecycler(R.id.rvUniversity, universityList, "university")

        // SearchView
        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterAll(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterAll(newText)
                return true
            }
        })
    }

    // Setup RecyclerView with category
    private fun setupRecycler(recyclerId: Int, items: List<CardItem>, category: String): CardAdapter {
        val recyclerView = findViewById<RecyclerView>(recyclerId)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = CardAdapter(this, items, category)
        recyclerView.adapter = adapter
        return adapter
    }

    // Filter all lists
    private fun filterAll(query: String?) {
        val q = query ?: ""
        eventsAdapter.filter(q)
        nearbyAdapter.filter(q)
        natureAdapter.filter(q)
        restaurantsAdapter.filter(q)
        heritageAdapter.filter(q)
        universityAdapter.filter(q)
    }
}


