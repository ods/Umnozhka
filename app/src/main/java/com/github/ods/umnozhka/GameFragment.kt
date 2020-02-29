package com.github.ods.umnozhka

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
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

        val shakeAnimation = AnimationUtils.loadAnimation(context, R.anim.shake)

        viewModel.state.observe(viewLifecycleOwner, Observer {
            if (it != GameState.WAIT) {
                if (it == GameState.LOSS) {
                    binding.exerciseView.startAnimation(shakeAnimation)
                }
                Handler().postDelayed({
                    viewModel.newExercise()
                }, 500)
            }
        })

        return binding.root
    }
}
