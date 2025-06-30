package com.exampletafsyr.tafsyr

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class PassArgsSharedViewM @Inject constructor() : ViewModel() {
    private val _tafsyrType = mutableStateOf<Int?>(null)
    val tafsyrType: State<Int?> = _tafsyrType
    private val _ayaNum = mutableStateOf<Int?>(null)
    val ayaNum: State<Int?> = _ayaNum
    private val _ayaNumbers = mutableStateOf<Int?>(null)
    val ayaNumbers: State<Int?> = _ayaNumbers
    private val _suraName = mutableStateOf<Int?>(null)
    val suraName: State<Int?> = _suraName

    fun saveTafsyrType(type: Int) {
        _tafsyrType.value = type
    }

    fun saveAyaNum(aya: Int) {
        _ayaNum.value = aya
    }

    fun saveTSuraNum(sura: Int) {
        _suraName.value = sura
    }
}