package com.hectre.sonvh.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hectre.sonvh.R
import com.hectre.sonvh.databinding.ActivityMainBinding
import com.hectre.sonvh.models.Job
import com.hectre.sonvh.models.Staff
import com.hectre.sonvh.models.StaffRow
import com.hectre.sonvh.models.TreeRow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val treeRow = arrayListOf<TreeRow>(
        TreeRow(
            rowId = 3,
            totalTree = 556,
            plantedTree = 0,
            plantedTreeLabel = ""
        ),
        TreeRow(
            rowId = 4,
            totalTree = 556,
            plantedTree = 250,
            plantedTreeLabel = "Yi Wan"
        ),
        TreeRow(
            rowId = 5,
            totalTree = 270,
            plantedTree = 100,
            plantedTreeLabel = "Elizabeth Jargrave"
        ),
    )

    private val jobs = arrayListOf<Job>(
        Job(
            staffs = arrayListOf<Staff>(
                Staff(
                    staffId = 0,
                    firstName = "Barco",
                    lastName = "",
                    orchard = "Benji(v1394u)",
                    block = "UB13",
                    rate = 35,
                    staffRows = arrayListOf<StaffRow>(
                        StaffRow(
                            treeRowId = 3,
                            currentTreeDone = 2
                        ),
                        StaffRow(
                            treeRowId = 4,
                            currentTreeDone = 2
                        ),
                    )
                ),
                Staff(
                    staffId = 1,
                    firstName = "Henry",
                    lastName = "Pham",
                    orchard = "Benji(v1394u)",
                    block = "UB13",
                    rate = 35,
                    staffRows = arrayListOf<StaffRow>(
                        StaffRow(
                            treeRowId = 3,
                            currentTreeDone = 2
                        ),
                        StaffRow(
                            treeRowId = 4,
                            currentTreeDone = 4
                        ),
                        StaffRow(
                            treeRowId = 5,
                            currentTreeDone = 5,
                        )
                    )
                )
            ),
            treeRow = treeRow,
            label = "Pruning",
            jobBoardId = 0
        ),
        Job(
            staffs = arrayListOf<Staff>(
                Staff(
                    staffId = 2,
                    firstName = "Darjian",
                    lastName = "",
                    orchard = "Benji(v1394u)",
                    block = "UB13",
                    rate = 35,
                    staffRows = arrayListOf<StaffRow>(
                        StaffRow(
                            treeRowId = 3,
                            currentTreeDone = 2
                        ),
                        StaffRow(
                            treeRowId = 4,
                            currentTreeDone = 2
                        ),
                        StaffRow(
                            treeRowId = 5,
                            currentTreeDone = 5,
                        )
                    )
                ),
            ),
            treeRow = treeRow,
            label = "Thining",
            jobBoardId = 1
        ),
    )

    private lateinit var adapter: JobsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = JobsAdapter()
        adapter.jobs.clear()
        adapter.jobs.addAll(jobs)
        binding.rcvJobs.adapter = adapter
    }
}