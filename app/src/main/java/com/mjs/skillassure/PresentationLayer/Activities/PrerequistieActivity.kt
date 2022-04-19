package com.mjs.skillassure.PresentationLayer.Activities

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mjs.skillassure.Common.Common
import com.mjs.skillassure.Common.Constants
import com.mjs.skillassure.R
import com.mjs.skillassure.databinding.ActivityPrerequistieBinding
import com.mjs.skillassure.databinding.DisagreeBottomSheetBinding

class PrerequistieActivity : AppCompatActivity() ,View.OnClickListener{
    private lateinit var binding: ActivityPrerequistieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPrerequistieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Common.statusBar(this,window)
        binding.agreeButton.setOnClickListener(this)
        binding.disAgreeButton.setOnClickListener(this)
        binding.include3.moveBack.setOnClickListener(this)
        binding.include3.headerTitle.text = Constants.Prerequistie

    }

    override fun onClick(v: View?) {
        val sound=MediaPlayer.create(this,R.raw.alertbell)
        when(v!!.id){
            R.id.move_back->{
                onBackPressed()
            }
            R.id.agree_button->{
                if (Common.isConnectedToInternet(this)){
                    startActivity(Intent(this, AssessmentTestActivity::class.java))
                }else{
                    Common.errorMgs(this,Constants.NO_Internet,Constants.Not_Connected_TO_Internet)
                }
            }
            R.id.dis_agree_button->{
                openBottomSheet()
                sound.start()
            }
        }
    }

    private fun openBottomSheet() {
        val dialog = BottomSheetDialog(this)
        val bottomBinding:DisagreeBottomSheetBinding = DisagreeBottomSheetBinding.inflate(layoutInflater)
        dialog.setContentView(bottomBinding.root)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        bottomBinding.bAgreeButton.setOnClickListener{
            if(Common.isConnectedToInternet(this)){
                startActivity(Intent(this, AssessmentTestActivity::class.java))
            }else{
                Common.errorMgs(this,Constants.NO_Internet,Constants.Not_Connected_TO_Internet)
            }
        }
        dialog.show()
    }
}