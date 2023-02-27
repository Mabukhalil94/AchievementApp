package com.example.achievement.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.achievement.databinding.ActivityMainBinding
import com.example.achievement.core.base.BaseActivity
import com.example.achievement.data.model.AchievementResponseModel
import com.example.achievement.ui.home.adapters.HomeAdapter

class HomeActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var viewModel: HomeViewModel

    override fun provideBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        initObserver()
    }

    private fun setLoading(isLoading: Boolean) {
        Toast.makeText(this, "Is Loading", Toast.LENGTH_LONG).show()
    }

    private fun setError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    private fun setRecyclerData(result: List<AchievementResponseModel>) {
        binding.rvAchievement.adapter = HomeAdapter(result)
    }


    private fun initObserver() {
        viewModel.loadingLiveData.observe(this, ::setLoading)
        viewModel.errorLiveData.observe(this, ::setError)
        viewModel.successLiveData.observe(this, ::setRecyclerData)
    }


    private fun initViewModel() {
        viewModel=ViewModelProvider(this)[HomeViewModel::class.java]
    }


}