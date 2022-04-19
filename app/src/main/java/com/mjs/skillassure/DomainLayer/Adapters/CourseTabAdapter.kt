package com.mjs.skillassure.DomainLayer.Adapters

import android.content.Context
import android.icu.text.CaseMap
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.mjs.skillassure.PresentationLayer.Fragments.CourseDocsFragment
import com.mjs.skillassure.PresentationLayer.Fragments.CourseLabsFragement
import com.mjs.skillassure.PresentationLayer.Fragments.CourseVideosFragment
import com.mjs.skillassure.databinding.FragmentCourseLabsFragementBinding

class CourseTabAdapter(supportedFragmentManager: FragmentManager):FragmentStatePagerAdapter(supportedFragmentManager) {

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()
    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }
    fun addFragment(fragment: Fragment,title:String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
}