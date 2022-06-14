package com.hectre.sonvh.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.hectre.sonvh.databinding.HolderStaffBinding
import com.hectre.sonvh.models.Staff

class StaffAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val staffList = arrayListOf<Staff>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StaffDetailHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = staffList.get(position)
        (holder as StaffDetailHolder).bind(item, position != 0)
    }

    override fun getItemCount(): Int {
        return staffList.size
    }
}

class StaffDetailHolder(private val binding: HolderStaffBinding): RecyclerView.ViewHolder(binding.root){

    lateinit var adapter: StaffRowAdapter

    fun bind(staff: Staff, showDivider: Boolean){
        binding.tvUsername.text = staff.firstName
        binding.divider.isVisible = showDivider
        binding.tvStaffOrchard.text = staff.orchard
        binding.tvStaffBlock.text = staff.block



        adapter = StaffRowAdapter(staffRows = staff.staffRows)
        binding.rcvStaffRow.adapter = adapter
    }

    companion object{
        fun create(parent: ViewGroup) : StaffDetailHolder{
            val binding = HolderStaffBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return StaffDetailHolder(binding)
        }
    }
}