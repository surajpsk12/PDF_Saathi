package com.surajvanshsv.pdfsaathinew.utils

import android.os.Environment
import com.surajvanshsv.pdfsaathinew.data.model.PdfFile
import java.io.File

object FileUtils {
    fun getPdfFiles() : List<PdfFile>{
        val pdfList = mutableListOf<PdfFile>()

        val root = Environment.getExternalStorageDirectory()

        scanDirectory(root, pdfList)
        return pdfList
    }

    private fun scanDirectory(
        file: File,
        pdfList: MutableList<PdfFile>
    ) {
        val files = file.listFiles() ?: return

        for(f in files){
            if(f.isDirectory){
                scanDirectory(f, pdfList)
            }else{
                if(f.name.endsWith(".pdf")){
                    pdfList.add(
                        PdfFile(
                            f.name,
                            f.absolutePath,
                            f.length()
                        )
                    )
                }
            }
        }
    }
}
