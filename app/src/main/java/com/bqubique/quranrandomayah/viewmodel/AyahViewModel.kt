package com.bqubique.quranrandomayah.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bqubique.quranrandomayah.api.QuranApi
import com.bqubique.quranrandomayah.model.ArabicAyah
import com.bqubique.quranrandomayah.model.Ayah
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class AyahViewModel @Inject constructor(
    @Named("quranApi")
    val quranApi: QuranApi
) : ViewModel() {
    val ayahEnglish = MutableLiveData<Ayah>()
    val ayahArabic = MutableLiveData<ArabicAyah>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()

    fun refresh(){
        loading.value = true
        loadRandomAyah()
    }

    private fun loadRandomAyah(){
        lateinit var english: Ayah
        lateinit var arabic: ArabicAyah

        runBlocking {
            CoroutineScope(Dispatchers.IO).launch {
                english = quranApi.getRandomAyah()
                arabic = quranApi.getArabicAyah(english.verse.verseKey)
            }.join()
        }
        english.let {
            loading.value = false
            error.value = false
            ayahEnglish.value = it
        }
        arabic.let {
            loading.value = false
            ayahArabic.value = it
        }
    }
}