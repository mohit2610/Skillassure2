package com.mjs.skillassure.PresentationLayer.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mjs.skillassure.Common.Common
import com.mjs.skillassure.Common.Constants
import com.mjs.skillassure.R
import com.mjs.skillassure.databinding.ActivitySignUpBinding
import com.mjs.skillassure.databinding.FragmentHomeBinding

class SignUpActivity : AppCompatActivity() ,View.OnClickListener{
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signInButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.signIn_Button->{
                if (binding.fullNameEdittext.text.toString().isEmpty()
                    ||binding.passwordToggle.text.toString().isEmpty()
                    ||binding.userNameEdittext.text.toString().isEmpty()
                    ||binding.emailId.text.toString().isEmpty()) {
                    Common.errorMgs(this, Constants.InputError, Constants.Check_Input_Details)
                } else {
                    if (Common.isConnectedToInternet(this)) {
                        startActivity(Intent(this, VerifyActivitionCode::class.java))
                        overridePendingTransition(R.anim.slide_in_right,R.anim.no_animation)
                    } else {
                        Common.errorMgs(this, Constants.NO_Internet, Constants.Not_Connected_TO_Internet)
                    }
                }
            }
        }
    }
}