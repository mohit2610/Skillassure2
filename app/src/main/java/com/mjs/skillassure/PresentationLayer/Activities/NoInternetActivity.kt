package com.mjs.skillassure.PresentationLayer.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mjs.skillassure.Common.Common
import com.mjs.skillassure.Common.Constants
import com.mjs.skillassure.R
import com.mjs.skillassure.databinding.ActivityNoInternetBinding



class NoInternetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoInternetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNoInternetBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.connectButton.setOnClickListener{
                val intent= Intent(android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS)
                startActivity(intent);
            }
    }

    override fun onStart() {
        super.onStart()
        if (Common.isConnectedToInternet(this)){
            val intent=Intent(this,LandingActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.no_animation,R.anim.slide_in_left)

        }
    }

    override fun onBackPressed() {
        if (!Common.isConnectedToInternet(this)){
            Common.errorMgs(this,Constants.NO_Internet,Constants.Not_Connected_TO_Internet)
        }else{
            super.onBackPressed()
        }
    }
}