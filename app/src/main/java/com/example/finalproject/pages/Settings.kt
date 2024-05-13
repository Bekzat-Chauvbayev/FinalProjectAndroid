package com.example.finalproject.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
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
import com.example.finalproject.ui.theme.DividerColor


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
                    .clip(Shapes.large)
                    .background(BackgroundElevated)
                    .fillMaxWidth()
                    ){
                    TableRow(label = "Categories", hasArrow = true, modifier = Modifier.clickable {
                        navController.navigate("setting/categories")
                    })
                    Divider(modifier = Modifier
                        .padding(start = 16.dp), thickness = 1.dp, color = DividerColor)
                    TableRow(label = "Erase all data", isDestructive = true)
                }
            }
        }
    )
}
