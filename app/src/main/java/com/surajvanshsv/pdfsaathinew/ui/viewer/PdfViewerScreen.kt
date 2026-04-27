package com.surajvanshsv.pdfsaathinew.ui.viewer

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PdfViewerScreen(pdfPath:String){
    Text(
        text = "Opening PDF : $pdfPath"
    )
}