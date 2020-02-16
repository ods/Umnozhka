package com.github.ods.umnozhka

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.github.ods.umnozhka.databinding.StartFragmentBinding


class StartFragment : Fragment() {

    private lateinit var viewModel: StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<StartFragmentBinding>(
            inflater, R.layout.start_fragment, container, false
        )

        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.startPressed.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(
                StartFragmentDirections.actionStartFragmentToGameFragment())
        })

        return binding.root
    }

}
