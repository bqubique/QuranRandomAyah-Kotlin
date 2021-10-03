package com.bqubique.quranrandomayah.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bqubique.quranrandomayah.model.Ayah
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AyahViewModel : ViewModel() {
    val ayah = MutableLiveData<Ayah>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()
}