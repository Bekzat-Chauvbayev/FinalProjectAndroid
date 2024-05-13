package com.example.finalproject.pages

import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import android.app.DatePickerDialog
import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.finalproject.components.TableRow
import com.example.finalproject.components.UnstyledTextField
import com.example.finalproject.ui.theme.BackgroundElevated
import com.example.finalproject.ui.theme.Shapes
import com.example.finalproject.ui.theme.TopAppBarBackground
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.ui.theme.DividerColor
import com.example.finalproject.ui.theme.MoneyTheme
import com.example.finalproject.ui.theme.Primary
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api:: class)
@Composable
fun Add(navController: NavController){
    val recurrences = listOf(
        "None",
        "Daily",
        "Weekly",
        "Monthly",
        "Yearly",
    )
    var selectedRecurrences by remember {
        mutableStateOf(recurrences[0])
    }
    val categories = listOf("Groceries", "Bills", "Hobbies" , "Take out")
    var selectedCategory by remember {
        mutableStateOf(categories[0])
    }
    val mContext = LocalContext.current
    val mYear:Int
    val mMonth:Int
    val mDay:Int
    val mCalendar = Calendar.getInstance()

    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    var mDate by remember {
        mutableStateOf("${mCalendar.get(Calendar.DAY_OF_MONTH)}-${mCalendar.get(Calendar.MONTH) + 1}-${mCalendar.get(Calendar.YEAR)}")
    }
    
    val mDatePicker = DatePickerDialog(
        mContext,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            mDate = "${selectedDay}-${selectedMonth + 1}-${selectedYear}"
        },
        mYear,
        mMonth,
        mDay
    )
    mDatePicker.datePicker.maxDate = mCalendar.timeInMillis
        
    
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("Add") }, 
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = TopAppBarBackground
            ))
        },
        content = {innerPadding ->
            Column(modifier = Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally) {
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
                    TableRow("Recurrence"){
                        var recurrenceMenuOpened by remember {
                            mutableStateOf(false)
                        }
                        TextButton(onClick = {recurrenceMenuOpened = true},
                            shape = Shapes.large) {
                            Text(selectedRecurrences)
                            DropdownMenu(expanded = recurrenceMenuOpened, onDismissRequest = {
                                recurrenceMenuOpened = false
                            }) {
                                recurrences.forEach{ recurrence ->
                                    DropdownMenuItem(text = { Text(text = recurrence) }, onClick = { 
                                        selectedRecurrences = recurrence
                                        recurrenceMenuOpened = false
                                    })
                                }
                                
                            }
                            
                        }
                    }
                    
                    Divider(modifier = Modifier
                        .padding(start = 16.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow("Date"){
                        TextButton(onClick = {mDatePicker.show()}) {
                            Text(mDate)
                        }
                    }
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
                    TableRow("Category"){
                        var categoriesMenuOpened by remember {
                            mutableStateOf(false)
                        }
                        TextButton(onClick = { categoriesMenuOpened = true },
                            shape = Shapes.large) {
                            Text(text = selectedCategory)
                            DropdownMenu(expanded = categoriesMenuOpened, onDismissRequest = {
                                categoriesMenuOpened= false
                            }) {
                                categories.forEach{category->
                                    DropdownMenuItem(text = {
                                        Row(verticalAlignment = Alignment.CenterVertically){
                                                        Surface(modifier = Modifier.size(10.dp), shape = CircleShape, color = Primary) {
                                                            
                                                        }        
                                            Text(category, modifier = Modifier.padding(start = 8.dp))
                                                            }
                                    }, onClick = 
                                    { selectedCategory = category
                                    categoriesMenuOpened = false
                                    }
                                    )
                                }
                                
                            }
                        }
                    }
                }
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.padding(16.dp),
                    shape = Shapes.large) {
                    Text("Submit expense")
                }
            }

        }
    )
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAdd(){
    MoneyTheme {
        val navController = rememberNavController()
        Add(navController = navController)
    }
}
