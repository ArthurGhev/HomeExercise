package com.app.homeexerciseapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.app.base.BaseFragment
import com.app.homeexerciseapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment  : BaseFragment<FragmentHomeBinding>() {
    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {

    }
}