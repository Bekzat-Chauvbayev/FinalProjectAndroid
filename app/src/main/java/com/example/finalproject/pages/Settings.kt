package com.example.finalproject.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.finalproject.ui.theme.BackgroundElevated
import com.example.finalproject.ui.theme.Shapes
import com.example.finalproject.ui.theme.TopAppBarBackground
import com.example.finalproject.components.TableRow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavController) {
    Scaffold(
        topBar = {
            MediumTopAppBar(title = { Text("Settings") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                ))
        },
        content = {innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ){
                Column(modifier = Modifier
                    .padding(16.dp)
                    .clip(Shapes.medium)
                    .background(BackgroundElevated)
                    .fillMaxWidth()
                    ){
                    TableRow("Categories", hasArrow = true)
                    TableRow("Erase all data", isDestructive = true)
                }
            }
        }
    )
}
