package com.hectre.sonvh.presentation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.hectre.sonvh.R
import com.hectre.sonvh.databinding.HolderStaffRowBinding
import com.hectre.sonvh.models.StaffRow

class StaffRowAdapter(val staffRows: List<StaffRow>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return StaffRowHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = staffRows.get(position)
        (holder as StaffRowHolder).bind(item)
    }

    override fun getItemCount(): Int {
        return staffRows.size
    }
}

class StaffRowHolder(val binding: HolderStaffRowBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(staffRow: StaffRow){
        binding.tvRowId.text = staffRow.treeRow.rowId.toString()
        binding.root.setOnClickListener {
            staffRow.selected = !staffRow.selected
            if (staffRow.selected) {
                binding.tvRowId.setTextColor(Color.WHITE)
                binding.root.setBackgroundResource(R.drawable.bg_row_selected)
            } else {
                binding.tvRowId.setTextColor(Color.BLACK)
                binding.root.setBackgroundResource(R.drawable.bg_row_not_selected)
            }
        }
        if (staffRow.treeRow.plantedTree > 0) {
            binding.orangeDot.isVisible = true
        } else {
            binding.orangeDot.isGone = true
        }
    }

    companion object{
        fun create(parent: ViewGroup): StaffRowHolder{
            val binding = HolderStaffRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return StaffRowHolder(binding)
        }
    }
}
