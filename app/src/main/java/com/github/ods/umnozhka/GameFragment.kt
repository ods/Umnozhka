package com.github.ods.umnozhka

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.ods.umnozhka.databinding.GameFragmentBinding


class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<GameFragmentBinding>(
            inflater, R.layout.game_fragment, container, false
        )
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.state.observe(viewLifecycleOwner, Observer {
            if (it != GameState.WAIT) {
                Handler().postDelayed({
                    viewModel.newExercise()
                }, 500)
            }
        })

        return binding.root
    }
}
