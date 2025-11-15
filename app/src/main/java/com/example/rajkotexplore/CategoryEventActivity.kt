package com.example.rajkotexplore

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.rajkotexplore.more.MoreActivity
import com.example.rajkotexplore.nearby.UniversityActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.rajkotexplore.category.CategoryTabFragment

class CategoryEventActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_category)

        // Initialize views
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        bottomNav = findViewById<BottomNavigationView>(R.id.bottom_category_navigation)

        // Handle back button click
        btnBack?.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Setup back press handler
        setupBackPressHandler()

        // Create fragments for event categories
        val fragments = listOf(
            CategoryTabFragment.newInstance("garbha"),
            CategoryTabFragment.newInstance("exhibition"),
            CategoryTabFragment.newInstance("fairs"),
            CategoryTabFragment.newInstance("cultural"),
            CategoryTabFragment.newInstance("religious")
        )

        val adapter = CategoryPagerAdapter(this, fragments)
        viewPager.adapter = adapter

        // Tab titles for event categories
        val titles = listOf("Garbha", "Exhibition", "Fairs", "Cultural", "Religious")
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()

        // Setup bottom navigation
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    navigateToActivity(MainActivity::class.java)
                    true
                }
                R.id.nav_category -> true // Already on this page
                R.id.nav_university -> {
                    navigateToActivity(UniversityActivity::class.java)
                    true
                }
                R.id.nav_more -> {
                    navigateToActivity(MoreActivity::class.java)
                    true
                }
                else -> false
            }
        }

        bottomNav.selectedItemId = R.id.nav_category
    }

    private fun setupBackPressHandler() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigateToActivity(MainActivity::class.java)
            }
        })
    }

    @Suppress("DEPRECATION")
    private fun navigateToActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onResume() {
        super.onResume()
        bottomNav.selectedItemId = R.id.nav_category
    }
}