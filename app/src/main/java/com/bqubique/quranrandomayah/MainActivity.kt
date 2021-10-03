package com.bqubique.quranrandomayah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bqubique.quranrandomayah.api.QuranApi
import com.bqubique.quranrandomayah.model.Ayah
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


}