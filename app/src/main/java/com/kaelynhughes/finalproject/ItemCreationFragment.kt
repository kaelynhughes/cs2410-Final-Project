package com.kaelynhughes.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kaelynhughes.finalproject.databinding.FragmentItemCreationBinding

class ItemCreationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentItemCreationBinding.inflate(inflater, container, false)
        val viewModel = ItemCreationViewModel()
        //val viewModel = WorkoutsViewModel()

        binding.saveButton.setOnClickListener {
            viewModel.createWorkout(
                binding.editTextDate.text.toString(),
                binding.editTextDescription.text.toString(),
                binding.editTextWeight.text.toString().toInt(),
                binding.editTextSets.text.toString().toInt(),
                binding.editTextReps.text.toString().toInt()
            )

            binding.editTextDate.setText("")
            binding.editTextDescription.setText("")
            binding.editTextWeight.setText("")
            binding.editTextSets.setText("")
            binding.editTextReps.setText("")
        }
        binding.toListScreenButton.setOnClickListener {
            //findNavController().navigate(R.id.create_to_list)
            findNavController().navigateUp()
        }
        return binding.root
    }
}