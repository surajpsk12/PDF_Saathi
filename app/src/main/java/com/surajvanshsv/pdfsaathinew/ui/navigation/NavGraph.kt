package com.surajvanshsv.pdfsaathinew.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.surajvanshsv.pdfsaathinew.ui.home.HomeScreen

@Composable
fun NavGraph(){

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            HomeScreen()
        }

    }





}