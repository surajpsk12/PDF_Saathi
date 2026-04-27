package com.surajvanshsv.pdfsaathinew.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.surajvanshsv.pdfsaathinew.ui.home.HomeScreen
import com.surajvanshsv.pdfsaathinew.ui.viewer.PdfViewerScreen
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


@Composable
fun NavGraph(){

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            HomeScreen(navController)
        }


        composable(
            route = "viewer/{pdfPath}",
            arguments = listOf(
                navArgument("pdfPath"){ type = NavType.StringType }
            )
        ){
            backStackEntry ->
            val encodedPath = backStackEntry.arguments?.getString("pdfPath") ?: ""
            val pdfPath = URLDecoder.decode(encodedPath, StandardCharsets.UTF_8.toString())

            PdfViewerScreen(pdfPath)
        }

    }





}