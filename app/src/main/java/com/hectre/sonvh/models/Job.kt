package com.hectre.sonvh.models

data class Job(
    val staffs: List<Staff>,
    val treeRow: List<TreeRow>,
    val label: String,
    val jobBoardId: Int
)