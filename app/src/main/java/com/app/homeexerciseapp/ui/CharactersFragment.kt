package com.app.homeexerciseapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.base.BaseFragment
import com.app.homeexerciseapp.R
import com.app.homeexerciseapp.databinding.FragmentCharactersBinding
import com.app.homeexerciseapp.extenstion.isNetworkAvailable
import com.app.homeexerciseapp.ui.recyclerview.CharactersAdapter
import com.app.homeexerciseapp.ui.recyclerview.LoadMoreAdapter
import com.app.presentation.contract.CharactersContract
import com.app.presentation.viewmodel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CharactersFragment  : BaseFragment<FragmentCharactersBinding>() {


    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCharactersBinding
        get() = FragmentCharactersBinding::inflate

    private val viewModel: CharactersViewModel by viewModels()

    @Inject
    lateinit var charactersAdapter: CharactersAdapter

    private var characteImage = ""

    override fun prepareView(savedInstanceState: Bundle?) {
        if (!requireContext().isNetworkAvailable()) {
            Toast.makeText(
                requireContext(),
                getString(R.string.check_network_msg),
                Toast.LENGTH_LONG
            ).show()
        }
        initObservers()
        setAdapter()
        with(binding){
            charactersRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    charactersRecyclerView.getContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }


    }

    private fun setAdapter() {
        charactersAdapter.setOnItemClickListener { character ->
            character.image?.let {
                characteImage = it
                Log.d("TestImageUrl", "url $characteImage" )
               // viewModel.setEvent(UsersContract.Event.GetUserRepoCount(characteImage))
            }
        }

        charactersAdapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading ||
                loadState.append is LoadState.Loading
            ) {
                binding.loadingPb.isVisible = true
            } else {
                binding.loadingPb.isVisible = false
                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                errorState?.let {
                    Toast.makeText(
                        requireContext(),
                        errorState.error.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        binding.charactersRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = charactersAdapter
        }

        binding.charactersRecyclerView.adapter = charactersAdapter.withLoadStateFooter(
            LoadMoreAdapter {
                charactersAdapter.retry()
            }
        )
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.characters.collect {
                    charactersAdapter.submitData(it)
                }
            }
        }


        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collect {
                    when (it) {
                        is CharactersContract.Effect.ShowError -> {
                            Toast.makeText(
                                requireContext(),
                                it.message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }
}