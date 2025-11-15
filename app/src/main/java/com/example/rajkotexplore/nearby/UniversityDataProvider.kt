package com.example.rajkotexplore.nearby

// Comprehensive University Data Model
data class University(
    val id: Int,
    val name: String,
    val type: String, // "Private" or "Government"
    val imageResId: Int,
    val description: String,
    val established: String,
    val address: String,
    val phone: String,
    val email: String,
    val website: String,
    val latitude: Double,
    val longitude: Double,
    val courses: List<Course>,
    val facilities: List<String>,
    val admissionStatus: AdmissionStatus,
    val accreditation: String,
    val rating: Float
)

data class Course(
    val name: String,
    val degree: String, // "UG", "PG", "Diploma", "PhD"
    val duration: String,
    val feesPerYear: String,
    val eligibility: String,
    val seats: Int
)

data class AdmissionStatus(
    val isOpen: Boolean,
    val lastDate: String,
    val process: String,
    val entranceExam: String?
)

// University Data Provider
object UniversityDataProvider {

    fun getAllUniversities(): List<University> {
        return listOf(
            // Government Universities
            getSaurasthaUniversity(),

            // Private Universities
            getMarwadiUniversity(),
            getAtmiyaUniversity(),
            getDarshanUniversity(),
            getRKUniversity(),

        )
    }

    private fun getSaurasthaUniversity(): University {
        return University(
            id = 1,
            name = "Saurashtra University",
            type = "Government",
            imageResId = com.example.rajkotexplore.R.drawable.saurastraun,
            description = "One of Gujarat's oldest and most prestigious universities, established in 1967. It promotes regional culture, research, and quality education across diverse disciplines.",
            established = "1967",
            address = "University Road, Rajkot - 360005",
            phone = "0281-2576347",
            email = "info@saurashtrauniversity.edu",
            website = "www.saurashtrauniversity.edu",
            latitude = 22.2867,
            longitude = 70.7746,
            courses = listOf(
                Course("B.A. (Arts)", "UG", "3 Years", "₹8,000 - ₹15,000", "12th Pass", 500),
                Course("B.Sc. (Science)", "UG", "3 Years", "₹10,000 - ₹20,000", "12th Science", 400),
                Course("B.Com (Commerce)", "UG", "3 Years", "₹8,000 - ₹15,000", "12th Commerce", 450),
                Course("M.A. (Master of Arts)", "PG", "2 Years", "₹10,000 - ₹18,000", "Bachelor's Degree", 200),
                Course("M.Sc. (Master of Science)", "PG", "2 Years", "₹12,000 - ₹25,000", "B.Sc.", 180),
                Course("M.Com (Master of Commerce)", "PG", "2 Years", "₹10,000 - ₹18,000", "B.Com", 150),
                Course("Ph.D. (Various Fields)", "PhD", "3-5 Years", "₹15,000 - ₹30,000", "Master's Degree", 100)
            ),
            facilities = listOf(
                "Central Library with 2 Lakh+ Books",
                "Research Centers",
                "Sports Complex",
                "Computer Labs",
                "Hostels (Boys & Girls)",
                "Auditorium",
                "Cafeteria",
                "Wi-Fi Campus"
            ),
            admissionStatus = AdmissionStatus(
                isOpen = true,
                lastDate = "30th June 2026",
                process = "Merit-based and Entrance Exam",
                entranceExam = "Gujarat University Entrance Test (GUET)"
            ),
            accreditation = "NAAC A+ Grade, UGC Recognized",
            rating = 4.2f
        )
    }

    private fun getMarwadiUniversity(): University {
        return University(
            id = 2,
            name = "Marwadi University",
            type = "Private",
            imageResId = com.example.rajkotexplore.R.drawable.mu_u1,
            description = "A leading private university known for innovation, entrepreneurship, and quality education. Features state-of-the-art infrastructure and international collaborations.",
            established = "2016",
            address = "Rajkot-Morbi Highway, Rajkot - 360003",
            phone = "0281-2970444",
            email = "admission@marwadieducation.edu.in",
            website = "www.marwadiuniversity.ac.in",
            latitude = 22.2575,
            longitude = 70.7514,
            courses = listOf(
                Course("B.Tech (Engineering)", "UG", "4 Years", "₹1,20,000 - ₹1,80,000", "12th PCM with 50%", 480),
                Course("BBA (Business Administration)", "UG", "3 Years", "₹80,000 - ₹1,20,000", "12th Any Stream", 180),
                Course("BCA (Computer Applications)", "UG", "3 Years", "₹70,000 - ₹1,00,000", "12th Any Stream", 120),
                Course("B.Pharm (Pharmacy)", "UG", "4 Years", "₹1,00,000 - ₹1,40,000", "12th PCB/PCM", 120),
                Course("M.Tech (Engineering)", "PG", "2 Years", "₹1,00,000 - ₹1,50,000", "B.Tech", 120),
                Course("MBA (Business Administration)", "PG", "2 Years", "₹1,50,000 - ₹2,00,000", "Bachelor's Degree", 180),
                Course("M.Sc (Computer Science)", "PG", "2 Years", "₹80,000 - ₹1,20,000", "B.Sc/BCA", 60)
            ),
            facilities = listOf(
                "Smart Classrooms with AI Integration",
                "Innovation & Incubation Center",
                "International Collaborations",
                "Placement Cell (85%+ Placement)",
                "Sports Complex & Gym",
                "Modern Hostels",
                "Industry Tie-ups",
                "Research Labs",
                "24/7 Library",
                "Medical Facilities"
            ),
            admissionStatus = AdmissionStatus(
                isOpen = true,
                lastDate = "15th July 2026",
                process = "Entrance Test & Personal Interview",
                entranceExam = "MU Entrance Test / JEE / GUJCET"
            ),
            accreditation = "NAAC A Grade, UGC Approved, AICTE",
            rating = 4.5f
        )
    }

    private fun getAtmiyaUniversity(): University {
        return University(
            id = 3,
            name = "Atmiya University",
            type = "Private",
            imageResId = com.example.rajkotexplore.R.drawable.atmiya_u2,
            description = "Focuses on value-based education integrating modern learning with traditional values. Known for research excellence and student development.",
            established = "2018",
            address = "Yogidham, Kalawad Road, Rajkot - 360005",
            phone = "0281-2460008",
            email = "info@atmiyauniversity.edu.in",
            website = "www.atmiyauniversity.ac.in",
            latitude = 22.2850,
            longitude = 70.7500,
            courses = listOf(
                Course("B.Tech (All Branches)", "UG", "4 Years", "₹90,000 - ₹1,40,000", "12th PCM", 420),
                Course("B.Sc (Science)", "UG", "3 Years", "₹40,000 - ₹60,000", "12th Science", 240),
                Course("BBA", "UG", "3 Years", "₹60,000 - ₹90,000", "12th Any Stream", 120),
                Course("B.Com", "UG", "3 Years", "₹40,000 - ₹60,000", "12th Commerce", 180),
                Course("M.Tech", "PG", "2 Years", "₹80,000 - ₹1,20,000", "B.Tech", 90),
                Course("M.Sc", "PG", "2 Years", "₹50,000 - ₹80,000", "B.Sc", 80),
                Course("MBA", "PG", "2 Years", "₹1,20,000 - ₹1,60,000", "Bachelor's", 120)
            ),
            facilities = listOf(
                "Value-Based Education Programs",
                "Modern Laboratories",
                "Digital Library",
                "Sports Facilities",
                "Yoga & Meditation Center",
                "Hostels with Modern Amenities",
                "Industry Interface Programs",
                "Entrepreneurship Cell"
            ),
            admissionStatus = AdmissionStatus(
                isOpen = true,
                lastDate = "20th July 2026",
                process = "Entrance Test & Merit",
                entranceExam = "GUJCET / JEE / University Test"
            ),
            accreditation = "UGC Approved, NAAC B++",
            rating = 4.1f
        )
    }

    private fun getDarshanUniversity(): University {
        return University(
            id = 4,
            name = "Darshan University",
            type = "Private",
            imageResId = com.example.rajkotexplore.R.drawable.darshan,
            description = "Known for strong engineering and management programs with emphasis on practical learning and industry collaboration.",
            established = "2015",
            address = "Morbi-Rajkot Highway, Hadala, Rajkot - 363650",
            phone = "02822-252062",
            email = "admission@darshan.ac.in",
            website = "www.darshan.ac.in",
            latitude = 22.3500,
            longitude = 70.8500,
            courses = listOf(
                Course("B.Tech (CSE/IT/Mechanical/Civil)", "UG", "4 Years", "₹85,000 - ₹1,30,000", "12th PCM", 600),
                Course("Diploma Engineering", "Diploma", "3 Years", "₹50,000 - ₹75,000", "10th Pass", 360),
                Course("BBA", "UG", "3 Years", "₹60,000 - ₹90,000", "12th Any Stream", 120),
                Course("BCA", "UG", "3 Years", "₹55,000 - ₹85,000", "12th Any Stream", 120),
                Course("M.Tech (All Branches)", "PG", "2 Years", "₹75,000 - ₹1,10,000", "B.Tech", 120),
                Course("MBA", "PG", "2 Years", "₹1,10,000 - ₹1,50,000", "Bachelor's", 120)
            ),
            facilities = listOf(
                "Industry-Standard Labs",
                "Innovation & Research Center",
                "Placement Cell (80%+ Placement)",
                "Sports Complex",
                "Modern Library",
                "Hostel Facilities",
                "Cafeteria",
                "Transport Facility",
                "Medical Center"
            ),
            admissionStatus = AdmissionStatus(
                isOpen = true,
                lastDate = "25th June 2026",
                process = "GUJCET / JEE Main Score",
                entranceExam = "GUJCET / JEE Main"
            ),
            accreditation = "AICTE Approved, NAAC A Grade",
            rating = 4.3f
        )
    }

    private fun getRKUniversity(): University {
        return University(
            id = 5,
            name = "RK University",
            type = "Private",
            imageResId = com.example.rajkotexplore.R.drawable.rkuniver,
            description = "A multidisciplinary university emphasizing practical learning, research, and global exposure with modern infrastructure.",
            established = "2011",
            address = "Rajkot-Bhavnagar Highway, Kasturbadham, Rajkot - 360020",
            phone = "02827-253701",
            email = "info@rku.ac.in",
            website = "www.rku.ac.in",
            latitude = 22.2389,
            longitude = 70.8172,
            courses = listOf(
                Course("B.Tech (All Streams)", "UG", "4 Years", "₹1,00,000 - ₹1,50,000", "12th PCM", 480),
                Course("B.Pharm", "UG", "4 Years", "₹90,000 - ₹1,30,000", "12th PCB/PCM", 120),
                Course("BBA", "UG", "3 Years", "₹70,000 - ₹1,00,000", "12th Any Stream", 120),
                Course("B.Sc (Nursing)", "UG", "4 Years", "₹80,000 - ₹1,20,000", "12th PCB", 100),
                Course("LLB (Law)", "UG", "3 Years", "₹70,000 - ₹1,00,000", "Bachelor's", 120),
                Course("M.Tech", "PG", "2 Years", "₹90,000 - ₹1,30,000", "B.Tech", 120),
                Course("MBA", "PG", "2 Years", "₹1,30,000 - ₹1,80,000", "Bachelor's", 180),
                Course("M.Pharm", "PG", "2 Years", "₹1,00,000 - ₹1,40,000", "B.Pharm", 60)
            ),
            facilities = listOf(
                "International Collaborations",
                "Research & Development Centers",
                "Smart Campus",
                "Skill Development Programs",
                "Sports Infrastructure",
                "Modern Hostels",
                "Industry Partnerships",
                "Entrepreneurship Cell",
                "Hospital & Medical Facilities"
            ),
            admissionStatus = AdmissionStatus(
                isOpen = true,
                lastDate = "10th July 2026",
                process = "Entrance Test & Interview",
                entranceExam = "RKU-CET / GUJCET / JEE"
            ),
            accreditation = "UGC Approved, NAAC A Grade, AICTE",
            rating = 4.4f
        )
    }


    fun getUniversityById(id: Int): University? {
        return getAllUniversities().find { it.id == id }
    }

    fun getGovernmentUniversities(): List<University> {
        return getAllUniversities().filter { it.type == "Government" }
    }

    fun getPrivateUniversities(): List<University> {
        return getAllUniversities().filter { it.type == "Private" }
    }
}