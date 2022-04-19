package com.mjs.skillassure.PresentationLayer.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mjs.skillassure.Common.Common
import com.mjs.skillassure.Common.Constants
import com.mjs.skillassure.R
import com.mjs.skillassure.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener(this)
        binding.signUpButton.setOnClickListener(this)
        onStart()
    }

    override fun onStart() {
        super.onStart()
        if (!Common.isConnectedToInternet(this)) {
            Common.errorMgs(this, Constants.NO_Internet, Constants.Not_Connected_TO_Internet)
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.login_button -> {
                if (Common.isConnectedToInternet(this)) {
                    startActivity(Intent(this, LoginActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.no_animation)
                } else {
                    Common.errorMgs(this,
                        Constants.NO_Internet,
                        Constants.Not_Connected_TO_Internet)
                }

            }
            R.id.signUp_button -> {
                if (Common.isConnectedToInternet(this)) {
                    startActivity(Intent(this, SignUpActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.no_animation)
                } else {
                    Common.errorMgs(this,
                        Constants.NO_Internet,
                        Constants.Not_Connected_TO_Internet)
                }
            }
        }
    }
}