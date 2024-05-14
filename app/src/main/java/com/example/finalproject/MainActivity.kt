package com.example.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import android.view.WindowManager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.finalproject.pages.Add
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.finalproject.pages.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.pages.Expenses
import com.example.finalproject.pages.Settings
import com.example.finalproject.ui.theme.MoneyTheme
import com.example.finalproject.ui.theme.TopAppBarBackground
import io.sentry.compose.withSentryObservableEffect


class MainActivity : ComponentActivity() {
   @OptIn(ExperimentalMaterial3Api::class)
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

      setContent {
         MoneyTheme {
            var showBottomBar by rememberSaveable {
               mutableStateOf(true)
            }
            val navController = rememberNavController().withSentryObservableEffect()
            val backStackEntry by navController.currentBackStackEntryAsState()

            showBottomBar = when (backStackEntry?.destination?.route){
               "settings/categories" -> false
               else -> true
            }
            Scaffold(
               bottomBar = {
                  if(showBottomBar){


                  NavigationBar(containerColor = TopAppBarBackground) {

                     NavigationBarItem(
                        selected = backStackEntry?.destination?.route == "expenses",
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
                        selected = backStackEntry?.destination?.route == "reports",
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
                        selected = backStackEntry?.destination?.route == "add",
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
                        selected = backStackEntry?.destination?.route?.startsWith("settings")
                           ?: false,
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
                           Expenses(navController)
                        }
                     }
                     composable("reports") {
                        Surface(
                           modifier = Modifier
                              .fillMaxSize()
                              .padding(innerPadding),
                        ) {
                           Reports()
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
                           Add(navController)
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



