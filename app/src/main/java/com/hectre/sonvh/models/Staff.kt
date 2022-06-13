package com.hectre.sonvh.models

data class Staff(
    val staffId: Int,
    val firstName: String,
    val lastName: String,
    val orchard: String,
    val block: String,
    var currentRateType: RateType = RateType.PIECE_RATE,
    var rate:Long,
    val staffRows: List<StaffRow>
){
    enum class RateType{
        PIECE_RATE,
        WAGES
    }
}

