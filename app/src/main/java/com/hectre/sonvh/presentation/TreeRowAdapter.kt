package com.hectre.sonvh.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.hectre.sonvh.databinding.HolderTreeRowBinding
import com.hectre.sonvh.models.StaffRow
import com.hectre.sonvh.models.TreeRow

class TreeRowAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val staffRows = arrayListOf<StaffRow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TreeRowHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val staffRow = staffRows.get(position)
        (holder as TreeRowHolder).bind(staffRow)
    }

    override fun getItemCount(): Int {
        return staffRows.size
    }
}

class TreeRowHolder(private val binding: HolderTreeRowBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(staffRow: StaffRow){
        binding.tvTreeRowLabel.text = "Trees for row ${staffRow.treeRow.rowId}"
        binding.tvTotalTree.text = "/ ${staffRow.treeRow.totalTree}"
        binding.tvStaffTree.setText("${staffRow.currentTreeDone}")
        if (staffRow.treeRow.plantedTree > 0) {
            binding.tvPlantedTreesLabel.isVisible = true
            binding.tvPlantedTreesLabel.text = "${staffRow.treeRow.plantedTreeLabel} (${staffRow.treeRow.plantedTree})"
        } else {
            binding.tvPlantedTreesLabel.isGone = true
        }
    }

    companion object {
        fun create(parent: ViewGroup): TreeRowHolder {
            val binding =
                HolderTreeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TreeRowHolder(binding)
        }
    }

}