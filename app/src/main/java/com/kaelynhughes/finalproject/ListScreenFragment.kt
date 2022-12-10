package com.kaelynhughes.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaelynhughes.finalproject.databinding.DateScreenListItemBinding
import com.kaelynhughes.finalproject.databinding.FragmentListScreenBinding
import com.kaelynhughes.finalproject.models.Workout

class ListScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentListScreenBinding.inflate(inflater, container, false)
        val viewModel = WorkoutsViewModel()
        viewModel.loadWorkouts()

        binding.toAddItemFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.list_to_create)
        }

        binding.dateRecyclerView.adapter = ListScreenAdapter(viewModel.workouts)
        binding.dateRecyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
}

class ListScreenAdapter(val workouts: List<Workout>): RecyclerView.Adapter<ListScreenAdapter.ViewHolder>() {
    class ViewHolder(val binding: DateScreenListItemBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun getItemCount(): Int {
        return workouts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DateScreenListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val workout = workouts[position]
        holder.binding.dateTextView.text = workout.date
        holder.binding.descriptionTextView.text = workout.description
        holder.binding.weightTextView.text = String.format("%s pounds", workout.weight.toString())
        holder.binding.infoTextView.text = String.format("%s sets of %s reps", workout.sets.toString(), workout.reps.toString())
    }
}