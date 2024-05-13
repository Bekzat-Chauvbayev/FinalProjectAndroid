package com.example.finalproject.pages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.finalproject.components.TableRow
import com.example.finalproject.components.UnstyledTextField
import com.example.finalproject.ui.theme.BackgroundElevated
import com.example.finalproject.ui.theme.Shapes
import com.example.finalproject.ui.theme.TopAppBarBackground
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.finalproject.ui.theme.DividerColor

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api:: class)
@Composable
fun Add(navController: NavController){
    Scaffold(
        topBar = {
            MediumTopAppBar(title = { Text("Add") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = TopAppBarBackground
            ))
        },
        content = {innerPading ->
            Column(modifier = Modifier.padding(innerPading)) {
                Column(modifier = Modifier
                    .padding(16.dp)
                    .clip(Shapes.large)
                    .background(BackgroundElevated)
                    .fillMaxWidth()
                ){
                    TableRow("Amount") {
                        UnstyledTextField(
                            value = "whaaa",
                            onValueChange = {},
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(
                                textAlign = TextAlign.Right
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                            )
                        )
                    }
                    Divider(modifier = Modifier
                        .padding(start = 16.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow("Recurrence")
                    Divider(modifier = Modifier
                        .padding(start = 16.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow("Date")
                    Divider(modifier = Modifier
                        .padding(start = 16.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow("Note"){
                        UnstyledTextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier
                                .fillMaxWidth(),
                            textStyle = TextStyle(
                                textAlign = TextAlign.Right,
                            ),

                        )
                    }
                    Divider(modifier = Modifier
                        .padding(start = 16.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow("Category")
                }
            }

        }
    )
}
