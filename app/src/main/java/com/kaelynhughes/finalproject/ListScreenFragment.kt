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
        binding.toAddItemFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.list_to_create)
        }

        val dates = listOf(
            ListItem("11/25/2022", "workout 1"),
            ListItem("11/26/2022", "workout 2"),
            ListItem("11/27/2022", "workout 3"),
            ListItem("11/28/2022", "workout 4"),
            ListItem("11/29/2022", "workout 5"),
            ListItem("11/30/2022", "workout 6"),
            ListItem("12/1/2022", "workout 7"),
            ListItem("12/2/2022", "workout 8"),
            ListItem("12/3/2022", "workout 9"),
            ListItem("12/4/2022", "workout 10"),
        )
        //val dates = WorkoutRepository.getAllWorkouts()
        binding.dateRecyclerView.adapter = ListScreenAdapter(dates)
        binding.dateRecyclerView.layoutManager = LinearLayoutManager(this.context)
        return binding.root
    }
}

class ListScreenAdapter(val dates: List<ListItem>): RecyclerView.Adapter<ListScreenAdapter.ViewHolder>() {
    class ViewHolder(val binding: DateScreenListItemBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun getItemCount(): Int {
        return dates.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DateScreenListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val date = dates[position]
        holder.binding.dateTextView.text = date.date
        holder.binding.descriptionTextView.text = date.description
    }
}