package com.hectre.sonvh.models

data class StaffRow(
    val treeRow: TreeRow,
    val currentTreeDone:Int
){
    var selected = false
}
