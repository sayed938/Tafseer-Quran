package com.exampletafsyr.tafsyr

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class PassArgsSharedViewM @Inject constructor() : ViewModel() {
    private val _tafsyrType = mutableStateOf<String?>(null)
    val tafsyrType: State<String?> = _tafsyrType
    private val _ayaNum = mutableStateOf<Int?>(null)
    val ayaNum: State<Int?> = _ayaNum

    private val _suraName = mutableStateOf<String?>(null)
    val suraName: State<String?> = _suraName

    fun saveTafsyrType(type: String) {
        _tafsyrType.value = type
    }

    fun saveAyaNum(aya: Int) {
        _ayaNum.value = aya
    }

    fun saveTSuraNAme(sura: String) {
        _suraName.value = sura
    }
}