package com.surajvanshsv.pdfsaathinew.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surajvanshsv.pdfsaathinew.domain.model.PdfDocument
import com.surajvanshsv.pdfsaathinew.domain.usecase.GetPdfFilesUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPdfFilesUseCase: GetPdfFilesUseCase

) : ViewModel(){

    var pdfList by mutableStateOf<List<PdfDocument>>(emptyList())
        private set


    init {
        loadPdfs()
    }

    private fun loadPdfs(){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                getPdfFilesUseCase()
            }
            pdfList = result
        }

    }
}