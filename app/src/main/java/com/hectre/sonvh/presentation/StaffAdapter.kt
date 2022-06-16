package com.hectre.sonvh.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.hectre.sonvh.R
import com.hectre.sonvh.databinding.HolderStaffBinding
import com.hectre.sonvh.models.Staff

class StaffAdapter(val jobName: String): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val staffList = arrayListOf<Staff>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = HolderStaffBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StaffDetailHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = staffList.get(position)
        (holder as StaffDetailHolder).bind(item, position != 0)
    }

    override fun getItemCount(): Int {
        return staffList.size
    }

    inner class StaffDetailHolder(private val binding: HolderStaffBinding): RecyclerView.ViewHolder(binding.root){

        lateinit var staffRowAdapter: StaffRowAdapter
        lateinit var treeRowAdapter: TreeRowAdapter

        fun bind(staff: Staff, showDivider: Boolean){
            binding.btnPieceRate.setOnClickListener {
                staff.currentRateType = Staff.RateType.PIECE_RATE
                binding.btnPieceRate.backgroundTintList = ContextCompat.getColorStateList(binding.root.context, R.color.primary_button_color)
                binding.btnWages.backgroundTintList = ContextCompat.getColorStateList(binding.root.context, R.color.uncheck_button_color)
                binding.rcvStaffRow.isVisible = true
                binding.rcvTreeRows.isVisible = true
                binding.tvWagesLabel.isGone = true
            }

            binding.btnWages.setOnClickListener {
                staff.currentRateType = Staff.RateType.WAGES
                binding.btnWages.backgroundTintList = ContextCompat.getColorStateList(binding.root.context, R.color.primary_button_color)
                binding.btnPieceRate.backgroundTintList = ContextCompat.getColorStateList(binding.root.context, R.color.uncheck_button_color)
                binding.rcvStaffRow.isGone = true
                binding.rcvTreeRows.isGone = true
                binding.tvWagesLabel.isVisible = true
            }
            binding.tvUsername.text = "${staff.firstName} ${staff.lastName}"
            binding.divider.isVisible = showDivider
            binding.tvStaffOrchard.text = staff.orchard
            binding.tvStaffBlock.text = staff.block
            binding.tvWagesLabel.text = "$jobName will be paid by wages in this timesheet."
            binding.tvAvatar.text = "${staff.firstName.firstOrNull() ?: ""}${staff.lastName.firstOrNull() ?: ""}"
            treeRowAdapter = TreeRowAdapter()

            staffRowAdapter = StaffRowAdapter(staffRows = staff.staffRows) { staffRow ->
                val filter = treeRowAdapter.staffRows.firstOrNull {
                    it == staffRow
                }
                if (filter != null) {
                    treeRowAdapter.staffRows.remove(staffRow)
                } else {
                    treeRowAdapter.staffRows.add(staffRow)
                }
                treeRowAdapter.notifyDataSetChanged()
            }
            binding.rcvTreeRows.adapter = treeRowAdapter
            binding.rcvStaffRow.adapter = staffRowAdapter
        }
    }
}

