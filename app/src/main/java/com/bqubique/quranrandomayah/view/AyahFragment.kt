package com.bqubique.quranrandomayah.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bqubique.quranrandomayah.R
import com.bqubique.quranrandomayah.api.QuranApi
import com.bqubique.quranrandomayah.model.Ayah
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class AyahFragment : Fragment() {

    @Inject
    @Named("quranApi")
    lateinit var quranApi: QuranApi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ayah, container, false)
    }

    fun getAyah(){
        var ayah: Ayah?
        runBlocking {
            val job = launch {
                ayah = quranApi.getRandomAyah()
                Log.d("MAINACTIVITY", ayah?.verse?.translations.toString())
            }
            job.join()
        }
    }
}