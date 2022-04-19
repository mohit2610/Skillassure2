package com.mjs.skillassure.Common

import android.content.BroadcastReceiver
import android.content.Intent
import com.mjs.skillassure.Common.ITelephony
import android.telephony.TelephonyManager
import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import java.lang.Exception

class IncomingCallReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val telephonyService: ITelephony
        try {
            val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
            val number = intent.extras!!.getString(TelephonyManager.EXTRA_INCOMING_NUMBER)
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING, ignoreCase = true)) {
                val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                try {
                    @SuppressLint("SoonBlockedPrivateApi") val m =
                        tm.javaClass.getDeclaredMethod("getITelephony")
                    m.isAccessible = true
                    telephonyService = m.invoke(tm) as ITelephony
                    if (number != null) {
                        telephonyService.endCall()
                        Toast.makeText(context, "Ending the call from: $number", Toast.LENGTH_SHORT)
                            .show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                Toast.makeText(context, "Ring $number", Toast.LENGTH_SHORT).show()
            }
            if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK, ignoreCase = true)) {
                Toast.makeText(context, "Answered $number", Toast.LENGTH_SHORT).show()
            }
            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE, ignoreCase = true)) {
                Toast.makeText(context, "Idle $number", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}