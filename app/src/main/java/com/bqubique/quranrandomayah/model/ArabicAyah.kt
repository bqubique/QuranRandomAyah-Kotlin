package com.bqubique.quranrandomayah.model


import com.google.gson.annotations.SerializedName

data class ArabicAyah(
    @SerializedName("verses")
    val verses: List<VerseX>
)