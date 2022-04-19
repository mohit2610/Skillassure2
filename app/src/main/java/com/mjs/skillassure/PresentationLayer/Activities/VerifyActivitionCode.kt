package com.mjs.skillassure.PresentationLayer.Activities

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.core.content.ContextCompat
import com.mjs.skillassure.Common.Common
import com.mjs.skillassure.Common.Constants
import com.mjs.skillassure.R
import com.mjs.skillassure.databinding.ActivitySignUpBinding
import com.mjs.skillassure.databinding.ActivityVerifyActivitionCodeBinding

class VerifyActivitionCode : AppCompatActivity() ,View.OnClickListener{
    private lateinit var binding: ActivityVerifyActivitionCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVerifyActivitionCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.resendButton.setOnClickListener(this)
        binding.verifyButton.setOnClickListener(this)
        timeLimit()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.verify_Button->{
                if (binding.codeEditText.text.toString().isEmpty()||binding.codeEditText.text.toString().length==6){
                    if (Common.isConnectedToInternet(this)){
                        //logic to check activation code is Valid or not
                        startActivity(Intent(this,DashBoardActivity::class.java))
                        overridePendingTransition(R.anim.slide_in_right,R.anim.no_animation)
                    }else{
                        Common.errorMgs(this,Constants.NO_Internet,Constants.Not_Connected_TO_Internet)
                    }

                }else{
                    Common.infoMgs(this,Constants.Activation_Code,Constants.Check_Activation_Code)
                }
            }
            R.id.resend_button->{
                Common.infoMgs(this,Constants.ResendCode,Constants.Code_Send_On_Email)
            }
        }
    }

    private fun timeLimit(){
        val timer = object: CountDownTimer(120000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timer.text="sec"+millisUntilFinished/1000
            }

            override fun onFinish() {
                binding.resendButton.visibility=View.VISIBLE
            }
        }
        timer.start()
    }
}