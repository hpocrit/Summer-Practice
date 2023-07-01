package com.example.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentNewsBinding

class NewsFragment: Fragment(R.layout.fragment_news) {
    private var binding: FragmentNewsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)

        binding?.run {
            btnToRandom.setOnClickListener {
                findNavController().navigate(
                    R.id.action_newsFragment_to_randomFragment,
                    RandomFragment.createBundle("You have come from the News Fragment to this fragment.")
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}