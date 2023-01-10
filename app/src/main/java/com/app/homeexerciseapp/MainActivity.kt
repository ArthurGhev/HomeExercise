package com.app.homeexerciseapp

import android.os.Bundle
import android.view.LayoutInflater
import com.app.base.BaseActivity
import com.app.homeexerciseapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :  BaseActivity<ActivityMainBinding>() {

    override val bindLayout: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {
    }
}