package com.example.cobaasramaku.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cobaasramaku.screens.DashboardScreen
import com.example.cobaasramaku.screens.auth.LandingScreen
import com.example.cobaasramaku.screens.auth.LoginScreen
import com.example.cobaasramaku.screens.SplashScreen
import com.example.cobaasramaku.screens.auth.SignUpScreen


sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Landing : Screen("landing")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Dashboard : Screen("dashboard")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(Screen.Splash.route){
            SplashScreen(
                onNavigateToLanding = {
                    navController.navigate(Screen.Landing.route){
                        popUpTo(Screen.Splash.route){inclusive = true}
                    }
                }
            )
        }

        composable(Screen.Landing.route){
            LandingScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                },
                onNavigateToSignUp = {
                    navController.navigate(Screen.SignUp.route)
                }
            )
        }

        composable(Screen.Login.route){
            LoginScreen(
                onNavigateToSignUp = {
                    navController.navigate(Screen.SignUp.route)
                },
                onLoginSuccess ={
                    navController.navigate(Screen.Dashboard.route){
                        popUpTo(Screen.Landing.route) { inclusive = true}
                    }
                }
            )
        }

        composable(Screen.SignUp.route){
            SignUpScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                },
                onSignUpSuccess = {
                    navController.navigate(Screen.Dashboard.route){
                        popUpTo(Screen.Landing.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Dashboard.route){
            DashboardScreen()
        }
    }
}