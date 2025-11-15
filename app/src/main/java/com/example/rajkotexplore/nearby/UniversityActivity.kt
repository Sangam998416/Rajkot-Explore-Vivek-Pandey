package com.example.rajkotexplore.nearby

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.CategoryEventActivity
import com.example.rajkotexplore.MainActivity
import com.example.rajkotexplore.R
import com.example.rajkotexplore.more.MoreActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class UniversityActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var toolbar: MaterialToolbar
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var universityAdapter: UniversityAdapter
    private lateinit var universityList: List<University>
    private var emptyState: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university)

        // Initialize views
        initializeViews()

        // Setup toolbar, recycler view, and bottom navigation
        setupToolbar()
        setupRecyclerView()
        setupBottomNavigation()
        setupBackPressHandler()
    }

    /** Initialize all views from layout */
    private fun initializeViews() {
        recyclerView = findViewById(R.id.recyclerUniversity)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        toolbar = findViewById(R.id.toolbar)
        emptyState = findViewById(R.id.emptyState)
    }

    /** Configure the top MaterialToolbar */
    private fun setupToolbar() {
        try {
            setSupportActionBar(toolbar)
            supportActionBar?.apply {
                title = "Nearby Universities"
                setDisplayHomeAsUpEnabled(true)
            }

            toolbar.setNavigationOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        } catch (e: Exception) {
            // If using a custom toolbar, fallback to manual back button
            val btnBack = findViewById<View>(R.id.btnBack)
            btnBack?.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    /** Setup RecyclerView for university list */
    private fun setupRecyclerView() {
        // Load all universities from data provider
        universityList = UniversityDataProvider.getAllUniversities()

        if (universityList.isEmpty()) {
            emptyState?.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            emptyState?.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE

            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@UniversityActivity)
                setHasFixedSize(true)
                universityAdapter = UniversityAdapter(universityList)
                adapter = universityAdapter
            }
        }
    }

    /** Configure bottom navigation bar actions */
    private fun setupBottomNavigation() {
        bottomNavigation.selectedItemId = R.id.nav_university

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    navigateToActivity(MainActivity::class.java)
                    true
                }
                R.id.nav_category -> {
                    navigateToActivity(CategoryEventActivity::class.java)
                    true
                }
                R.id.nav_university -> true // Already on this page
                R.id.nav_more -> {
                    navigateToActivity(MoreActivity::class.java)
                    true
                }
                else -> false
            }
        }
    }

    /** Setup modern back press handler */
    private fun setupBackPressHandler() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigateToActivity(MainActivity::class.java)
            }
        })
    }

    /** Common navigation method with smooth transition */
    @Suppress("DEPRECATION")
    private fun navigateToActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    /** Keep University tab highlighted when returning */
    override fun onResume() {
        super.onResume()
        bottomNavigation.selectedItemId = R.id.nav_university
    }
}