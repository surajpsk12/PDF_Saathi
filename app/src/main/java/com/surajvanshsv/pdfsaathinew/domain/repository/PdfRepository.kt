package com.surajvanshsv.pdfsaathinew.domain.repository

import com.surajvanshsv.pdfsaathinew.domain.model.PdfDocument


interface PdfRepository {
    suspend fun getAllPdfs(): List<PdfDocument>
}