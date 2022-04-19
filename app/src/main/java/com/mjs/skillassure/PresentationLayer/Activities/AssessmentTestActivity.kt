package com.mjs.skillassure.PresentationLayer.Activities

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mjs.skillassure.Common.Common
import com.mjs.skillassure.DataLayer.AssessmentTestData
import com.mjs.skillassure.DomainLayer.Adapters.AssessmentTestAdapter
import com.mjs.skillassure.R
import com.mjs.skillassure.databinding.ActivityAssessmentTestBinding
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mjs.skillassure.DomainLayer.ViewModels.AssessmentTestViewModel
import com.mjs.skillassure.DomainLayer.ViewModels.MyAssessmentViewModel

class AssessmentTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAssessmentTestBinding
    private  var questionsList: MutableList<AssessmentTestData> =ArrayList()
    private  var backpressCounter:Int=0
    private val PERMISSION_REQUEST_READ_PHONE_STATE = 1
    private lateinit var assessmentTestViewModel: AssessmentTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAssessmentTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Common.statusBar(this,window)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE)

        //Blocking phone calls
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED || checkSelfPermission(
                    Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED
            ) {
                val permissions = arrayOf<String>(Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.CALL_PHONE)
                requestPermissions(permissions, PERMISSION_REQUEST_READ_PHONE_STATE)
            }
        }
        //Questions with options
        val assessmentTestAdapter = AssessmentTestAdapter(this)
        assessmentTestViewModel=ViewModelProvider(this)[AssessmentTestViewModel::class.java]
        assessmentTestViewModel.getAssessmentTestData()
        assessmentTestViewModel.assessmentTestViewModel.observe(this,{
            assessmentTestAdapter.setData(it as ArrayList<AssessmentTestData>)
        })
        binding.recyclerView.apply {
            adapter=assessmentTestAdapter
            layoutManager=LinearLayoutManager(this@AssessmentTestActivity)
        }
        //Time Limit
        timeLimit()

        //Submit Assessment
        submitAssessment()

    }

    //Test Time
    private fun timeLimit(){
        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.time.text=""+millisUntilFinished/1000

                if (millisUntilFinished>=30000){
                    binding.time.setTextColor(ContextCompat.getColor(this@AssessmentTestActivity, R.color.green))
                    binding.mintsLeft.setTextColor(ContextCompat.getColor(this@AssessmentTestActivity, R.color.green))

                }else{
                    binding.time.setTextColor(ContextCompat.getColor(this@AssessmentTestActivity, R.color.red))
                    binding.mintsLeft.setTextColor(ContextCompat.getColor(this@AssessmentTestActivity, R.color.red))

                }
            }

            override fun onFinish() {
                submitTheAssessment()
            }
        }
        timer.start()
    }


    //Auto Submit when time is over
    fun submitTheAssessment(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.assesment_submit_dialog_box)
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog.window?.attributes)
        layoutParams.width= WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height= WindowManager.LayoutParams.WRAP_CONTENT
        layoutParams.gravity= Gravity.CENTER
        dialog.window!!.attributes=layoutParams
        val okButton = dialog.findViewById<Button>(R.id.dashboard_button)
        okButton.setOnClickListener{
            startActivity(Intent(this,DashBoardActivity::class.java))
            overridePendingTransition(R.anim.slide_in_left,R.anim.no_animation)
        }
        dialog.show()
    }


    //keeping counter on back pressed
    override fun onBackPressed() {
        backpressCounter++
        if (backpressCounter==2){
            super.onBackPressed()
            //Store into database the counter
        }
    }

    //submit test after finishing test
    private fun submitAssessment(){
        binding.submitFab.setOnClickListener {
            submitTheAssessment()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray, ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_READ_PHONE_STATE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this,
                        "Permission granted: $PERMISSION_REQUEST_READ_PHONE_STATE",
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,
                        "Permission NOT granted: $PERMISSION_REQUEST_READ_PHONE_STATE",
                        Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }
}