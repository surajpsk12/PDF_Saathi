package com.surajvanshsv.pdfsaathinew.data.repository

import com.surajvanshsv.pdfsaathinew.domain.model.PdfDocument
import com.surajvanshsv.pdfsaathinew.domain.repository.PdfRepository
import com.surajvanshsv.pdfsaathinew.utils.FileUtils
import javax.inject.Inject

class PdfRepositoryImpl @Inject constructor() : PdfRepository {
    override suspend fun getAllPdfs(): List<PdfDocument> {
        return FileUtils.getPdfFiles().map {
            PdfDocument(
                name = it.name,
                path = it.path,
                size = it.size
            )
        }

    }
}