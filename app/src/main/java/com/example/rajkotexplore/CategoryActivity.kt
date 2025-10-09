package com.example.rajkotexplore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.rajkotexplore.event.EventPagerAdapter
import com.example.rajkotexplore.event.ConcertFragment
import com.example.rajkotexplore.event.CulturalFragment
import com.example.rajkotexplore.event.ExhibitionFragment
import com.example.rajkotexplore.event.FairsFragment
import com.example.rajkotexplore.more.MoreActivity
import com.example.rajkotexplore.nearby.NearbyActivity
import com.example.rajkotexplore.nearby.UniversityActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CategoryActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        bottomNav = findViewById(R.id.bottomNavigation2)

        // Fragments for tabs
        val fragments = listOf(
            ConcertFragment(),
            ExhibitionFragment(),
            FairsFragment(),
            CulturalFragment()
        )

        val adapter = EventPagerAdapter(this, fragments)
        viewPager.adapter = adapter

        val titles = listOf("Concerts", "Exhibition", "Fairs", "Cultural")
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()

        // Bottom navigation
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_event -> true // already here
                R.id.nav_nearby -> {
                    startActivity(Intent(this, NearbyActivity::class.java)) // ✅ Fixed
                    true
                }
                R.id.nav_transport -> {
                    startActivity(Intent(this, UniversityActivity::class.java))
                    true
                }
                R.id.nav_more -> {
                    startActivity(Intent(this, MoreActivity::class.java))
                    true
                }
                else -> false
            }
        }

        // Default selected
        bottomNav.selectedItemId = R.id.nav_event
    }
}
