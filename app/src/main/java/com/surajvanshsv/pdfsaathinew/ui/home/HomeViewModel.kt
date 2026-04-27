package com.surajvanshsv.pdfsaathinew.ui.home

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surajvanshsv.pdfsaathinew.domain.model.PdfDocument
import com.surajvanshsv.pdfsaathinew.domain.usecase.GetPdfFilesUseCase
import kotlinx.coroutines.launch


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPdfFilesUseCase: GetPdfFilesUseCase

) : ViewModel(){

    var pdfList : List<PdfDocument> = emptyList()
    init {
        loadPdfs()
    }

    private fun loadPdfs(){
        viewModelScope.launch {
            pdfList = getPdfFilesUseCase()
        }

    }
}