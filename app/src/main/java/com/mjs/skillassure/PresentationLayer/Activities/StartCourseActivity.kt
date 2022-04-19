package com.mjs.skillassure.PresentationLayer.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.mjs.skillassure.Common.Common
import com.mjs.skillassure.DomainLayer.Adapters.CourseTabAdapter
import com.mjs.skillassure.PresentationLayer.Fragments.CourseDocsFragment
import com.mjs.skillassure.PresentationLayer.Fragments.CourseLabsFragement
import com.mjs.skillassure.PresentationLayer.Fragments.CourseVideosFragment
import com.mjs.skillassure.R
import com.mjs.skillassure.databinding.ActivityMyCourseBinding
import com.mjs.skillassure.databinding.ActivityStartCourseBinding

class StartCourseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartCourseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStartCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Common.statusBar(this,window)
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.Docs))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.Videos))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.Labs))

        val adapter=CourseTabAdapter(supportFragmentManager)
        adapter.addFragment(CourseDocsFragment(),"Docs")
        adapter.addFragment(CourseVideosFragment(),"Videos")
        adapter.addFragment(CourseLabsFragement(),"Labs")

        binding.viewPager.adapter=adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }
}