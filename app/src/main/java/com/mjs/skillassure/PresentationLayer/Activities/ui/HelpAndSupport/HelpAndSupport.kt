package com.mjs.skillassure.PresentationLayer.Activities.ui.HelpAndSupport

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mjs.skillassure.R

class HelpAndSupport : Fragment() {

    companion object {
        fun newInstance() = HelpAndSupport()
    }

    private lateinit var viewModel: HelpAndSupportViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.help_and_support_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HelpAndSupportViewModel::class.java)
        // TODO: Use the ViewModel
    }

}