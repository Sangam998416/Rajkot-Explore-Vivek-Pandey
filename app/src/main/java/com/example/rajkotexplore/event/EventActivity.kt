package com.example.rajkotexplore.event

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.rajkotexplore.more.MoreActivity
import com.example.rajkotexplore.nearby.NearbyActivity
import com.example.rajkotexplore.R
import com.example.rajkotexplore.nearby.UniversityActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class EventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        val fragments = listOf(
            ConcertFragment(),
            ExhibitionFragment(),
            FairsFragment(),
            CulturalFragment()
        )
        val titles = listOf("Concerts", "Exhibition", "Fairs", "Cultural")

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_category_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_event -> {
                    startActivity(Intent(this, EventActivity::class.java))
                    true
                }
                R.id.nav_nearby -> {
                    startActivity(Intent(this, NearbyActivity::class.java))
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

        val adapter = EventPagerAdapter(this, fragments)
        viewPager.adapter = adapter

        // Fix lambda type error by explicitly specifying tab type
        TabLayoutMediator(tabLayout, viewPager) { tab: TabLayout.Tab, position: Int ->
            tab.text = titles[position]
        }.attach()
    }
}

