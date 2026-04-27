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
import android.content.Context
import android.net.Uri
import androidx.documentfile.provider.DocumentFile

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

    fun loadPdfsFromUri(context: Context, uri: Uri) {

        val result = mutableListOf<PdfDocument>()

        val pickedDir = DocumentFile.fromTreeUri(context, uri)

        pickedDir?.listFiles()?.forEach { file ->

            if (file.name?.endsWith(".pdf") == true) {
                result.add(
                    PdfDocument(
                        name = file.name ?: "Unknown",
                        path = file.uri.toString(),
                        size = file.length()
                    )
                )
            }
        }

        pdfList = result
    }
}