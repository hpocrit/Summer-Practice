package com.example.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.summerpractice.databinding.FragmentRandomBinding
import com.google.android.material.snackbar.Snackbar

class RandomFragment: Fragment(R.layout.fragment_random) {
    private var _binding: FragmentRandomBinding? = null
    var binding = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRandomBinding.bind(view)

        val name = arguments?.getString(ARG_NAME)

        if (name != null) {
            Snackbar.make(binding.root, name, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val ARG_NAME = "ARG_NAME"

        fun createBundle(name: String): Bundle {
            val bundle = Bundle()
            bundle.putString(ARG_NAME, name)
            return bundle
        }
    }
}