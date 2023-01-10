package com.app.homeexerciseapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.app.appgithubusers.ui.common.glideSetImage
import com.app.base.BaseFragment
import com.app.homeexerciseapp.R
import com.app.homeexerciseapp.databinding.FragmentImageBinding
import com.app.homeexerciseapp.extenstion.isNetworkAvailable
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class ImageFragment: BaseFragment<FragmentImageBinding>() {

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentImageBinding
        get() = FragmentImageBinding::inflate

    private val args: ImageFragmentArgs by navArgs()

    override fun prepareView(savedInstanceState: Bundle?) {
        if (!requireContext().isNetworkAvailable()) {
            Toast.makeText(
                requireContext(),
                getString(R.string.check_network_msg),
                Toast.LENGTH_LONG
            ).show()
        }

        binding.btnBack.setOnClickListener {
            goBack()
        }
        binding.txtCharacterName.text = args.name
        glideSetImage(requireContext(), args.image, binding.imgAvatar)
    }

    private fun goBack() {
        findNavController().popBackStack()
    }

}