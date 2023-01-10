package com.app.homeexerciseapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.app.base.BaseFragment
import com.app.homeexerciseapp.databinding.FragmentHomeBinding
import com.app.presentation.viewmodel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment  : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: CharactersViewModel by viewModels()

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {
        binding.click.setOnClickListener {
            viewModel.getCharactersRepoCount(1)
        }
    }
}