package com.github.ods.umnozhka

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.github.ods.umnozhka.databinding.GameFragmentBinding


class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.game_fragment, container, false
        )

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("XXX", "Activity: $activity")
        activity?.let {
//            it.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
            val requestFocus = view.requestFocus()
            val requestFocusFromTouch = view.requestFocusFromTouch()
            Log.i("XXX", "requestFocus: $requestFocus, requestFocusFromTouch: $requestFocusFromTouch")
            val inputMethodManager = it.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            val showSoftInput = inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED)
            Log.i("XXX", "showSoftInput: $showSoftInput")
        }
    }
}
