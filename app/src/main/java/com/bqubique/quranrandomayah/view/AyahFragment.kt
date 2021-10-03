package com.bqubique.quranrandomayah.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bqubique.quranrandomayah.api.QuranApi
import com.bqubique.quranrandomayah.databinding.FragmentAyahBinding
import com.bqubique.quranrandomayah.viewmodel.AyahViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class AyahFragment : Fragment() {

    @Inject
    @Named("quranApi")
    lateinit var quranApi: QuranApi
    private lateinit var ayahViewModel: AyahViewModel
    private lateinit var binding: FragmentAyahBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAyahBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ayahViewModel = ViewModelProvider(this).get(AyahViewModel::class.java)
        binding.extendedFab.setOnClickListener {
            getContent()
        }
    }

    private fun getContent(){
        ayahViewModel.refresh()

        ayahViewModel.ayahEnglish.observe(
            viewLifecycleOwner,
            { englishAyah ->
                binding.englishTv.text = englishAyah.verse.translations[0].text
            }
        )
        ayahViewModel.ayahArabic.observe(
            viewLifecycleOwner,
            { arabicAyah->
                binding.arabicTv.text = arabicAyah.verses[0].textUthmani
            }
        )
    }
}