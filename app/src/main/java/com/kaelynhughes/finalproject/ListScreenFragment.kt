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

data class ListItem(
    val date: String,
    val description: String
)

class ListScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListScreenBinding.inflate(inflater, container, false)
        val viewModel = WorkoutsViewModel()
        binding.toAddItemFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.list_to_create)
        }

        val workouts1 = listOf(
            Workout(0, "11/25/2022", "workout 1", 0, 0),
            Workout(0, "11/26/2022", "workout 2", 0, 0),
            Workout(0, "11/27/2022", "workout 3", 0, 0),
            Workout(0, "11/28/2022", "workout 4", 0, 0),
            Workout(0, "11/29/2022", "workout 5", 0, 0),
            Workout(0, "11/30/2022", "workout 6", 0, 0),
            Workout(0, "12/1/2022", "workout 7", 0, 0),
            Workout(0, "12/2/2022", "workout 8", 0, 0),
            Workout(0, "12/3/2022", "workout 9", 0, 0),
            Workout(0, "12/4/2022", "workout 10", 0, 0)
        )
//        val dates = listOf(
//            ListItem("11/25/2022", "workout 1"),
//            ListItem("11/26/2022", "workout 2"),
//            ListItem("11/27/2022", "workout 3"),
//            ListItem("11/28/2022", "workout 4"),
//            ListItem("11/29/2022", "workout 5"),
//            ListItem("11/30/2022", "workout 6"),
//            ListItem("12/1/2022", "workout 7"),
//            ListItem("12/2/2022", "workout 8"),
//            ListItem("12/3/2022", "workout 9"),
//            ListItem("12/4/2022", "workout 10"),
        //)
        //val dates = WorkoutRepository.getAllWorkouts()
        binding.dateRecyclerView.adapter = ListScreenAdapter(workouts1)
        //binding.dateRecyclerView.adapter = ListScreenAdapter(viewModel.workouts)
        binding.dateRecyclerView.layoutManager = LinearLayoutManager(this.context)
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
    }
}