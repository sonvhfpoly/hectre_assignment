package com.hectre.sonvh.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hectre.sonvh.databinding.HolderConfirmBinding
import com.hectre.sonvh.databinding.HolderJobBinding
import com.hectre.sonvh.models.Job

class JobsAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val TYPE_JOB = 0
        private const val TYPE_CONFIRM_BUTTON = 1
    }

    val jobs = arrayListOf<Job>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_CONFIRM_BUTTON){
            return ConfirmButtonHolder.create(parent)
        }
        return JobBoardHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == TYPE_JOB){
            val item = jobs.get(position)
            (holder as JobBoardHolder).bind(item)
        }
    }

    override fun getItemCount(): Int {
        return jobs.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == jobs.size) {
            TYPE_CONFIRM_BUTTON
        } else {
            TYPE_JOB
        }
    }
}

class JobBoardHolder(private val binding: HolderJobBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(job: Job){
        binding.tvJobType.text = job.label
        val adapter = StaffAdapter()
        adapter.staffList.clear()
        adapter.staffList.addAll(job.staffs)
        binding.rcvStaffs.adapter = adapter
    }

    companion object{
        fun create(parent: ViewGroup): JobBoardHolder{
            val binding = HolderJobBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return JobBoardHolder(binding)
        }
    }
}

class ConfirmButtonHolder(private val binding: HolderConfirmBinding): RecyclerView.ViewHolder(binding.root){

    companion object{
        fun create(parent: ViewGroup) : ConfirmButtonHolder{
            val binding = HolderConfirmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ConfirmButtonHolder(binding)
        }
    }
}