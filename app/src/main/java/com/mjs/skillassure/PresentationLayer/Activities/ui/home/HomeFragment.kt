package com.mjs.skillassure.PresentationLayer.Activities.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mjs.skillassure.DataLayer.CategoryItems
import com.mjs.skillassure.DataLayer.MyAssessmentData
import com.mjs.skillassure.DataLayer.MyCourseData
import com.mjs.skillassure.DataLayer.ReportCardData
import com.mjs.skillassure.DomainLayer.Adapters.MyAssessmentAdapter
import com.mjs.skillassure.DomainLayer.Adapters.MyCategoriesAdapter
import com.mjs.skillassure.DomainLayer.Adapters.MyCourseAdapter
import com.mjs.skillassure.DomainLayer.Adapters.MyReportCardAdapter
import com.mjs.skillassure.DomainLayer.ViewModels.CategoryViewModel
import com.mjs.skillassure.DomainLayer.ViewModels.MyAssessmentViewModel
import com.mjs.skillassure.DomainLayer.ViewModels.MyCourseViewModel
import com.mjs.skillassure.DomainLayer.ViewModels.MyReportCardViewModel
import com.mjs.skillassure.R
import com.mjs.skillassure.databinding.FragmentHomeBinding
import com.ouattararomuald.slider.ImageSlider
import com.ouattararomuald.slider.SliderAdapter
import com.ouattararomuald.slider.loaders.glide.GlideImageLoaderFactory

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private var myCourseItemList: MutableList<MyCourseData> = ArrayList()
    private var myAssessmentItemList: MutableList<MyAssessmentData> = ArrayList()
    private val binding get() = _binding!!
    private lateinit var categoryItemsViewModel: CategoryViewModel
    private lateinit var myReportCardDataViewModel: MyReportCardViewModel
    private lateinit var myCourseViewModel: MyCourseViewModel
    private lateinit var myAssessmentViewModel: MyAssessmentViewModel

    private var progress = 70
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        //Category Items
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        //CandidateProgress
        updateProgressBar()
        val sliderImage = arrayOf(R.drawable.pic,
            R.drawable.pic2,
            R.drawable.pic,
            R.drawable.pic2,
            R.drawable.pic,
            R.drawable.pic2)
        for (img in sliderImage) {
            setFlipperImage(img)
        }
        val myCategoriesAdapter = MyCategoriesAdapter(requireContext())
        categoryItemsViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
        categoryItemsViewModel.getCategoryItem()
        categoryItemsViewModel.categoryViewModelLiveData.observe(viewLifecycleOwner) {
            myCategoriesAdapter.setData(it as ArrayList<CategoryItems>)
        }
        //Category Handler
        binding.apply {
            myCatrgoriesRecyclerView.adapter = myCategoriesAdapter
            myCatrgoriesRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        }
        //My Course Handler
        val myCourseAdapter = MyCourseAdapter(requireContext())
        myCourseViewModel = ViewModelProvider(this)[MyCourseViewModel::class.java]
        myCourseViewModel.getMyCourseData()
        myCourseViewModel.myCourseViewModel.observe(this, {
            myCourseAdapter.setData(it as ArrayList<MyCourseData>)
        })
        binding.apply {
            myCourseRecyclerview.adapter = myCourseAdapter
            myCourseRecyclerview.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
        }
        val myAssessmentAdapter = MyAssessmentAdapter(requireContext())
        myAssessmentViewModel = ViewModelProvider(this)[MyAssessmentViewModel::class.java]
        myAssessmentViewModel.getAssessment()
        myAssessmentViewModel.assessmentViewModel.observe(this, {
            myAssessmentAdapter.setData(it as ArrayList<MyAssessmentData>)
        })
        binding.apply {
            myAssessmentRecyclerview.adapter = myAssessmentAdapter
            myAssessmentRecyclerview.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
        }
        //MyReportCard Data Adapter
        val myReportCardDataAdapter = MyReportCardAdapter(requireContext())
        myReportCardDataViewModel = ViewModelProvider(this)[MyReportCardViewModel::class.java]
        myReportCardDataViewModel.getReportCardData()
        myReportCardDataViewModel.reportCardViewModel.observe(this, {
            myReportCardDataAdapter.setData(it as ArrayList<ReportCardData>)
        })
        binding.apply {
            myReportCardRecyclerview.adapter = myReportCardDataAdapter
            myReportCardRecyclerview.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Percentage calculator
    private fun percentageCalculator(correctAns: Int, totalQuestion: Int): Int {
        return correctAns * 100 / totalQuestion
    }


    private fun setFlipperImage(res: Int) {
        Log.i("Set Filpper Called", res.toString() + "")
        val image = ImageView(context)
        image.setBackgroundResource(res)
        binding.imageSlider.addView(image)
    }

    private fun updateProgressBar() {
        binding.progressBar.progress = progress
        binding.progressPercentage.text = "$progress%"
    }
}



