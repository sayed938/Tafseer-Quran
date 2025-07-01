package com.exampletafsyr.tafsyr

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.exampletafsyr.domain.entities.AyaDataModel
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
    private val _suraNumber = mutableStateOf<Int?>(null)
    val suraNumber: State<Int?> = _suraNumber
    private var _suraResult=mutableStateOf<List<AyaDataModel>>(emptyList())
    val suraResult:State<List<AyaDataModel>> =_suraResult

    fun saveTafsyrType(type: Int) {
        _tafsyrType.value = type
    }

    fun saveAyaNum(aya: Int) {
        _ayaNum.value = aya
    }

    fun saveTSuraNum(sura: Int) {
        _suraNumber.value = sura
    }
    fun saveSuraResult(sura :List<AyaDataModel>) {
        _suraResult.value = sura
    }
}