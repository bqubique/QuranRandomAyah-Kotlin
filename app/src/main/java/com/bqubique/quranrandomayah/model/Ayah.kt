package com.bqubique.quranrandomayah.model


import com.google.gson.annotations.SerializedName

data class Ayah(
    @SerializedName("verse")
    val verse: Verse
)