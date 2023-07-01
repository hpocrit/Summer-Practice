package com.example.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentMessengerBinding

class MessengerFragment: Fragment(R.layout.fragment_messenger) {
    private var binding: FragmentMessengerBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMessengerBinding.bind(view)

        binding?.run {
            btnToRandom.setOnClickListener {
                findNavController().navigate(
                    R.id.action_messengerFragment_to_randomFragment,
                    RandomFragment.createBundle("You have come from the Messenger Fragment to this fragment.")
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}