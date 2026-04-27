package com.surajvanshsv.pdfsaathinew.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.surajvanshsv.pdfsaathinew.ui.home.HomeScreen
import com.surajvanshsv.pdfsaathinew.ui.viewer.PdfViewerScreen

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
                val pdfPath = backStackEntry.arguments?.getString("pdfPath") ?: ""

            PdfViewerScreen(pdfPath)
        }

    }





}