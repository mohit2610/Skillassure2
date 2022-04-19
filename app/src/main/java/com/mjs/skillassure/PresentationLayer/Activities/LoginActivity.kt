package com.mjs.skillassure.PresentationLayer.Activities

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mjs.skillassure.databinding.ActivityLoginBinding
import android.content.Intent
import com.mjs.skillassure.Common.Common
import com.mjs.skillassure.Common.Constants
import com.mjs.skillassure.R
class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener(this)
        binding.googleLogin.setOnClickListener(this)
        binding.linkedinLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.login_button -> {
                if (binding.emailId.text.toString().isEmpty()||binding.passwordToggle.text.toString().isEmpty()) {
                    Common.errorMgs(this, Constants.InputError,Constants.Check_Input_Details)
                } else {
                    if (Common.isConnectedToInternet(this)) {
                        startActivity(Intent(this, DashBoardActivity::class.java))
                        overridePendingTransition(R.anim.slide_in_right,R.anim.no_animation)
                    } else {
                        Common.errorMgs(this, Constants.NO_Internet,Constants.Not_Connected_TO_Internet)
                    }
                }
            }
            R.id.google_login -> {
                Common.infoMgs(this, Constants.Info, Constants.This_Feature_Will_Be_Available_Soon)
            }
            R.id.linkedin_login -> {
                Common.infoMgs(this, Constants.Info, Constants.This_Feature_Will_Be_Available_Soon)
            }
        }
    }


}