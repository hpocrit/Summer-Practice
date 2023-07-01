package com.example.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentMainBinding
import com.example.summerpractice.databinding.FragmentSettingBinding

class SettingFragment : Fragment(R.layout.fragment_setting) {
    private var binding: FragmentSettingBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingBinding.bind(view)

        binding?.run {
            btnToRandom.setOnClickListener {
                findNavController().navigate(
                    R.id.action_settingFragment_to_randomFragment,
                    RandomFragment.createBundle("You have come from the Setting Fragment to this fragment.")
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}