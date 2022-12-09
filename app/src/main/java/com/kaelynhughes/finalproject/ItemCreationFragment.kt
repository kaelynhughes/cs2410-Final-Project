package com.kaelynhughes.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.kaelynhughes.finalproject.databinding.FragmentItemCreationBinding

class ItemCreationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentItemCreationBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this).get(WorkoutsViewModel::class.java)
        var num = 0

        viewModel.hasError.observe(viewLifecycleOwner) {
        }

        binding.saveButton.setOnClickListener {
            viewModel.createWorkout(num.toString())
            num++
        }
        binding.toListScreenButton.setOnClickListener {
            findNavController().navigate(R.id.create_to_list)
        }
        return binding.root
    }
}