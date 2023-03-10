package com.example.achievement.core.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil.setContentView
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: B

    abstract fun provideBinding(layoutInflater: LayoutInflater): B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = provideBinding(layoutInflater)
        setContentView(binding.root)
    }


}
