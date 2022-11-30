package com.example.dndmonstersbook.model

import com.google.gson.annotations.SerializedName

data class MonstersResponse(
    @SerializedName("results")
    val monsters : List<MonstersModel>
)