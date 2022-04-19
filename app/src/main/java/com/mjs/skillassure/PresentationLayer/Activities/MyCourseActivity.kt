package com.mjs.skillassure.PresentationLayer.Activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mjs.skillassure.Common.Common
import com.mjs.skillassure.R
import com.mjs.skillassure.databinding.ActivityMyCourseBinding

class MyCourseActivity : AppCompatActivity() ,View.OnClickListener{
    private lateinit var binding : ActivityMyCourseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMyCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Common.statusBar(this,window)
        binding.startCourse.setOnClickListener(this)
        binding.include.moveBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.start_course->{
                startActivity(Intent(this,StartCourseActivity::class.java))
            }
            R.id.move_back->{
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}