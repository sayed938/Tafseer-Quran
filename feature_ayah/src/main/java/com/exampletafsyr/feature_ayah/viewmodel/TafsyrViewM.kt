package com.exampletafsyr.feature_ayah.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exampletafsyr.domain.entities.AyaDataModel
import com.exampletafsyr.domain.usecase.TafsyrUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TafsyrViewM @Inject constructor(var tafsyrUseCase: TafsyrUseCase) : ViewModel() {

    private val _tafsyrKatheer: MutableStateFlow<List<AyaDataModel>> = MutableStateFlow(emptyList())
    val tafsyrQuranKatheer: StateFlow<List<AyaDataModel>> = _tafsyrKatheer
    private val _tafsyrBaghawy: MutableStateFlow<List<AyaDataModel>> = MutableStateFlow(emptyList())
    val tafsyrQuranBaghawy: StateFlow<List<AyaDataModel>> = _tafsyrBaghawy
    private val _tafsyrTbry: MutableStateFlow<List<AyaDataModel>> = MutableStateFlow(emptyList())
    val tafsyrQuranTbry: StateFlow<List<AyaDataModel>> = _tafsyrTbry
    private val _tafsyrSady: MutableStateFlow<List<AyaDataModel>> = MutableStateFlow(emptyList())
    val tafsyrQuranSady: StateFlow<List<AyaDataModel>> = _tafsyrSady

    fun setTafsyrType(flag: Int, sura: Int) {
        when (flag) {
            0 -> getTafsyrQuranKatheer(sura)
            1 -> getTafsyrQuranBaghawy(sura)
            2 -> getTafsyrQuranTbry(sura)
            3 -> getTafsyrQuranSady(sura)
        }
    }

    fun getTafsyrQuranKatheer(suraNum: Int) {
        viewModelScope.launch {
            _tafsyrKatheer.value = tafsyrUseCase.getTafsyrUseCase("tafsir-katheer", suraNum)

        }
    }

    fun getTafsyrQuranBaghawy(suraNum: Int) {
        viewModelScope.launch {
            _tafsyrBaghawy.value = tafsyrUseCase.getTafsyrUseCase("tafsir-baghawy", suraNum)

        }

    }

    fun getTafsyrQuranTbry(suraNum: Int) {
        viewModelScope.launch {
            _tafsyrTbry.value = tafsyrUseCase.getTafsyrUseCase("tafsir-tabary", suraNum)

        }
    }

    fun getTafsyrQuranSady(suraNum: Int) {
        viewModelScope.launch {
            _tafsyrSady.value = tafsyrUseCase.getTafsyrUseCase("tafsir-saadi", suraNum)

        }
    }
}