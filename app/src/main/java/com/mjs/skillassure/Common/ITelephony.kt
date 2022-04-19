package com.mjs.skillassure.Common

interface ITelephony {
    fun endCall(): Boolean
    fun answerRingingCall()
    fun silenceRinger()
}