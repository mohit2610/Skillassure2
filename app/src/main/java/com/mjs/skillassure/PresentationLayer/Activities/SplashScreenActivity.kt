package com.mjs.skillassure.PresentationLayer.Activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.Slide
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.mjs.skillassure.R
import com.mjs.skillassure.databinding.ActivityMainBinding
import com.mjs.skillassure.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in,R.anim.no_animation)
            finish()
        }, 2000)
    }
}