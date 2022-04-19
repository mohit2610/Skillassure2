package com.mjs.skillassure.Common

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Typeface
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.ViewGroup
import com.irozon.sneaker.Sneaker
import com.mjs.skillassure.R

import androidx.core.content.ContextCompat

import android.os.Build
import android.view.View
import android.view.Window


class Common {
    companion object {


        fun statusBar(context: Context?, window: Window) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
                window.statusBarColor = ContextCompat.getColor(context!!, R.color.creameWhite)
            }
        }
        fun errorMgs(actvitiy: Activity, title: String, msg: String) {
            Sneaker.with(actvitiy)
                .setTitle(title)
                .setMessage(msg)
                .sneakError()
        }

        fun successMgs(actvitiy: Activity, title: String, msg: String) {
            Sneaker.with(actvitiy)
                .setTitle(title)
                .setMessage(msg)
                .sneakSuccess()
        }

        fun infoMgs(actvitiy: Activity, title: String, msg: String) {
            Sneaker.with(actvitiy)
                .setTitle(title, R.color.white)
                .setMessage(msg, R.color.white)
                .setDuration(4000)
                .autoHide(true)
                .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .setIcon(R.drawable.ic_info, R.color.white, false)
                .sneak(R.color.sky_blue_dark)
        }

        fun isConnectedToInternet(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var activeNetworkInfo: NetworkInfo? = cm.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
        }

        fun showProgressDialogBox(context: Context, title: String, mgs: String) {
            val progressDialog = ProgressDialog(context)
            progressDialog.setCancelable(false)
            progressDialog.setTitle(title)
            progressDialog.setMessage(mgs)
            progressDialog.show()
        }
        fun hideProgressDialogBox(context: Context) {
            val progressDialog = ProgressDialog(context)
            progressDialog.hide()
        }
    }
}