package com.surajvanshsv.pdfsaathinew.domain.usecase

import com.surajvanshsv.pdfsaathinew.domain.model.PdfDocument
import com.surajvanshsv.pdfsaathinew.domain.repository.PdfRepository
import javax.inject.Inject

class GetPdfFilesUseCase @Inject constructor(
   private val repository: PdfRepository
){
    suspend operator fun invoke() : List<PdfDocument>{
        return repository.getAllPdfs()
    }
}