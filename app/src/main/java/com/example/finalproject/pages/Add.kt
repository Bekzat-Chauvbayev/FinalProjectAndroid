package com.example.finalproject.pages

import android.content.res.Configuration
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.components.TableRow
import com.example.finalproject.components.UnstyledTextField
import com.example.finalproject.models.Recurrence
import com.example.finalproject.ui.theme.BackgroundElevated
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog
import com.example.finalproject.ui.theme.DividerColor
import com.example.finalproject.ui.theme.MoneyTheme
import com.example.finalproject.ui.theme.Primary
import com.example.finalproject.ui.theme.TopAppBarBackground
import com.example.finalproject.ui.theme.Typography
import com.example.finalproject.viewmodels.AddViewModel
import java.util.*
import com.example.finalproject.ui.theme.Shapes

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api:: class, ExperimentalComposeUiApi::class)
@Composable
fun Add(navController: NavController, vm: AddViewModel = viewModel()) {
    val state by vm.uiState.collectAsState()
    val recurrences = listOf(
        Recurrence.None,
        Recurrence.Daily,
        Recurrence.Weekly,
        Recurrence.Monthly,
        Recurrence.Yearly
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

    val mDatePicker = android.app.DatePickerDialog(
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
                            value = state.amount,
                            onValueChange = vm::setAmount,
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("0") },
                            arrangement = Arrangement.End,
                            maxLines = 1,
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
                            Text(state.recurrence?.name ?: Recurrence.None.name)
                            DropdownMenu(expanded = recurrenceMenuOpened, onDismissRequest = {
                                recurrenceMenuOpened = false
                            }) {
                                recurrences.forEach{ recurrence ->
                                    DropdownMenuItem(text = { Text(recurrence.name) }, onClick = {
                                        vm.setRecurrence(recurrence)
                                        recurrenceMenuOpened = false
                                    })
                                }

                            }

                        }
                    }

                    Divider(modifier = Modifier
                        .padding(start = 16.dp), thickness = 1.dp, color = DividerColor
                    )
                    var datePickerShowing by remember {
                        mutableStateOf(false)
                    }
                    TableRow("Date"){
                        TextButton(onClick = { datePickerShowing = true }) {
                            Text(state.date.toString())
                        }
                        if (datePickerShowing) {
                            DatePickerDialog(
                                onDismissRequest = { datePickerShowing = false },
                                onDateChange = { it ->
                                    vm.setDate(it)
                                    datePickerShowing = false
                                },
                                initialDate = state.date,
                                title = { Text("Select date", style = Typography.titleLarge) }
                            )
                        }
                    }
                    Divider(modifier = Modifier
                        .padding(start = 16.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow("Note"){
                        UnstyledTextField(
                            value = state.note,
                            placeholder = { Text("Leave some notes") },
                            arrangement = Arrangement.End,
                            onValueChange = vm::setNote,
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
