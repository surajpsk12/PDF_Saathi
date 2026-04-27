package com.surajvanshsv.pdfsaathinew.ui.home

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import java.net.URLEncoder
import java.nio.charset.StandardCharsets



@Composable
fun HomeScreen(
    navController: NavController ,
    viewModel: HomeViewModel = hiltViewModel()
){

    val context = LocalContext.current

    val pdfList = viewModel.pdfList

    val folderPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocumentTree()
    ){ uri: Uri? ->
        uri?.let {
            viewModel.loadPdfsFromUri(context, it)
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text="Pdf Saathi",
            style=MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            folderPickerLauncher.launch(null)
        }) {
            Text(text="Select Folder")
        }

        LazyColumn {
            items(pdfList){
                pdf ->

                Text(
                    text = pdf.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            val encodedPath = URLEncoder.encode(pdf.path, StandardCharsets.UTF_8.toString())

                            navController.navigate("viewer/$encodedPath")
                        }
                        .padding(8.dp)
                )

            }
        }

    }
}

