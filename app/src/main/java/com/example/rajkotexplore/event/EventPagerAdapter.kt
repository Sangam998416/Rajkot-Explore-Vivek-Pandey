package com.example.rajkotexplore.event

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class EventPagerAdapter(
    activity: FragmentActivity,
    private val fragments: List<Fragment>
) : FragmentStateAdapter(activity) {

    // Return total number of fragments
    override fun getItemCount(): Int = fragments.size

    // Return the fragment for the given position
    override fun createFragment(position: Int): Fragment = fragments[position]
}


