package com.surajvanshsv.pdfsaathinew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.surajvanshsv.pdfsaathinew.ui.home.HomeScreen
import com.surajvanshsv.pdfsaathinew.ui.navigation.NavGraph
import com.surajvanshsv.pdfsaathinew.ui.theme.PdfsaathinewTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PdfsaathinewTheme {
                NavGraph()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PdfsaathinewTheme {
    }
}