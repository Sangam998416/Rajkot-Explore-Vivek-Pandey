package com.example.rajkotexplore.nearby

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.tabs.TabLayout

class UniversityDetailActivity : AppCompatActivity() {

    private lateinit var university: University
    private lateinit var coursesRecyclerView: RecyclerView
    private lateinit var facilitiesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university_detail)

        val universityId = intent.getIntExtra("UNIVERSITY_ID", 1)
        university = UniversityDataProvider.getUniversityById(universityId) ?: return

        setupToolbar()
        setupBasicInfo()
        setupTabs()
        setupButtons()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupBasicInfo() {
        findViewById<ImageView>(R.id.imgUniversityDetail).setImageResource(university.imageResId)
        findViewById<TextView>(R.id.txtUniversityName).text = university.name
        findViewById<TextView>(R.id.txtDescription).text = university.description
        findViewById<Chip>(R.id.chipType).text = university.type
        findViewById<TextView>(R.id.txtEstablished).text = "Established: ${university.established}"
        findViewById<TextView>(R.id.txtAccreditation).text = university.accreditation

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        if (university.rating > 0) {
            ratingBar.rating = university.rating
            findViewById<TextView>(R.id.txtRating).text = "${university.rating}/5.0"
        } else {
            ratingBar.visibility = View.GONE
            findViewById<TextView>(R.id.txtRating).visibility = View.GONE
        }

        // Admission Status
        val admissionStatus = findViewById<TextView>(R.id.txtAdmissionStatus)
        if (university.admissionStatus.isOpen) {
            admissionStatus.text = "✓ Admissions Open - Last Date: ${university.admissionStatus.lastDate}"
            admissionStatus.setTextColor(getColor(android.R.color.holo_green_dark))
        } else {
            admissionStatus.text = "✗ Admissions Closed"
            admissionStatus.setTextColor(getColor(android.R.color.holo_red_dark))
        }

        // Contact Info
        findViewById<TextView>(R.id.txtAddress).text = "📍 ${university.address}"
        findViewById<TextView>(R.id.txtPhone).text = "📞 ${university.phone}"
        findViewById<TextView>(R.id.txtEmail).text = "📧 ${university.email}"
        findViewById<TextView>(R.id.txtWebsite).text = "🌐 ${university.website}"
    }

    private fun setupTabs() {
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val coursesLayout = findViewById<RecyclerView>(R.id.recyclerCourses)
        val facilitiesLayout = findViewById<RecyclerView>(R.id.recyclerFacilities)
        val admissionLayout = findViewById<View>(R.id.admissionLayout)

        // Setup Courses RecyclerView
        coursesRecyclerView = findViewById(R.id.recyclerCourses)
        coursesRecyclerView.layoutManager = LinearLayoutManager(this)
        coursesRecyclerView.adapter = CourseAdapter(university.courses)

        // Setup Facilities RecyclerView
        facilitiesRecyclerView = findViewById(R.id.recyclerFacilities)
        facilitiesRecyclerView.layoutManager = LinearLayoutManager(this)
        facilitiesRecyclerView.adapter = FacilityAdapter(university.facilities)

        // Setup Admission Info
        findViewById<TextView>(R.id.txtAdmissionProcess).text = university.admissionStatus.process
        findViewById<TextView>(R.id.txtEntranceExam).text =
            university.admissionStatus.entranceExam ?: "No specific entrance exam"

        // Tab Selection
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        coursesLayout.visibility = View.VISIBLE
                        facilitiesLayout.visibility = View.GONE
                        admissionLayout.visibility = View.GONE
                    }
                    1 -> {
                        coursesLayout.visibility = View.GONE
                        facilitiesLayout.visibility = View.VISIBLE
                        admissionLayout.visibility = View.GONE
                    }
                    2 -> {
                        coursesLayout.visibility = View.GONE
                        facilitiesLayout.visibility = View.GONE
                        admissionLayout.visibility = View.VISIBLE
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun setupButtons() {
        // Get Directions - NOW USING LinearLayout instead of MaterialButton
        findViewById<LinearLayout>(R.id.btnGetDirections).setOnClickListener {
            val gmmIntentUri = Uri.parse(
                "geo:${university.latitude},${university.longitude}?q=${university.latitude},${university.longitude}(${university.name})"
            )
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")

            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com/maps/search/?api=1&query=${university.latitude},${university.longitude}")
                )
                startActivity(browserIntent)
            }
        }

        // Call - NOW USING LinearLayout instead of MaterialButton
        findViewById<LinearLayout>(R.id.btnCall).setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:${university.phone}")
            startActivity(callIntent)
        }

        // Visit Website - NOW USING LinearLayout instead of MaterialButton
        findViewById<LinearLayout>(R.id.btnWebsite).setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://${university.website}"))
            startActivity(browserIntent)
        }

        // Share - NOW USING LinearLayout instead of MaterialButton
        findViewById<LinearLayout>(R.id.btnShare).setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, university.name)
                putExtra(Intent.EXTRA_TEXT, """
                    ${university.name}
                    
                    ${university.description}
                    
                    Type: ${university.type}
                    Established: ${university.established}
                    
                    Contact: ${university.phone}
                    Website: ${university.website}
                """.trimIndent())
            }
            startActivity(Intent.createChooser(shareIntent, "Share University Info"))
        }
    }
}