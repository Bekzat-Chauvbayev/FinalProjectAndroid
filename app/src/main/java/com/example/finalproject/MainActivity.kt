package com.example.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.pages.Expenses
import com.example.finalproject.pages.Settings
import com.example.finalproject.ui.theme.MoneyTheme


class MainActivity : ComponentActivity() {
   @OptIn(ExperimentalMaterial3Api::class)
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      setContent {
         MoneyTheme {
            val navController = rememberNavController()
            val backStackEntry = navController.currentBackStackEntryAsState()
            Scaffold(
               bottomBar = {
                  NavigationBar {
                     NavigationBarItem(
                        selected = backStackEntry.value?.destination?.route == "expenses",
                        onClick = { navController.navigate("expenses") },
                        label = {
                           Text("Expenses")
                        },
                        icon = {
                           Icon(
                              painterResource(id = R.drawable.upload),
                              contentDescription = "Upload"
                           )
                        }
                     )
                     NavigationBarItem(
                        selected = backStackEntry.value?.destination?.route == "reports",
                        onClick = { navController.navigate("reports") },
                        label = {
                           Text("Reports")
                        },
                        icon = {
                           Icon(
                              painterResource(id = R.drawable.bar_chart),
                              contentDescription = "Reports"
                           )
                        }
                     )
                     NavigationBarItem(
                        selected = backStackEntry.value?.destination?.route == "add",
                        onClick = { navController.navigate("add") },
                        label = {
                           Text("Add")
                        },
                        icon = {
                           Icon(
                              painterResource(id = R.drawable.add),
                              contentDescription = "Add"
                           )
                        }
                     )
                     NavigationBarItem(
                        selected = backStackEntry.value?.destination?.route == "settings",
                        onClick = { navController.navigate("settings") },
                        label = {
                           Text("Settings")
                        },
                        icon = {
                           Icon(
                              painterResource(id = R.drawable.settings_outlined),
                              contentDescription = "Settings"
                           )
                        }
                     )
                  }
               },
               content = { innerPadding ->
                  NavHost(navController = navController, startDestination = "expenses") {
                     composable("expenses") {
                        Surface(
                           modifier = Modifier
                              .fillMaxSize()
                              .padding(innerPadding),
                        ) {
                           Expenses(navController, "Expenses")
                        }
                     }
                     composable("reports") {
                        Surface(
                           modifier = Modifier
                              .fillMaxSize()
                              .padding(innerPadding),
                        ) {
                           Greeting("Reports")
                        }
                     }
                     composable("add") {
                        Surface(
                           modifier = Modifier
                              .fillMaxSize()
                              .padding(innerPadding),
                        ) {
                           Greeting("Add")
                        }
                     }
                     composable("settings") {
                        Surface(
                           modifier = Modifier
                              .fillMaxSize()
                              .padding(innerPadding),
                        ) {
                           Settings(navController)
                        }
                     }
                     composable("settings/categories") {
                        Surface(
                           modifier = Modifier
                              .fillMaxSize()
                              .padding(innerPadding),
                        ) {
                           Greeting("Categories")
                        }
                     }
                  }
               }
            )
         }
      }
   }

   @Composable
   fun Greeting(name: String) {
      Text(text = "Hello $name!")
   }
}

