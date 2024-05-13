package com.example.finalproject.pages

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.components.PickerTrigger
import com.example.finalproject.expensesList.ExpensesList
import com.example.finalproject.mock.mockExpenses
import com.example.finalproject.models.Recurrence
import com.example.finalproject.ui.theme.LabelSecondary
import com.example.finalproject.ui.theme.MoneyTheme
import com.example.finalproject.ui.theme.TopAppBarBackground
import com.example.finalproject.viewmodels.ExpensesViewModel
import  com.example.finalproject.ui.theme.Typography
import  com.example.finalproject.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Expenses(
  navController: NavController,
  vm: ExpensesViewModel = viewModel()
) {
    val recurrences = listOf(
        Recurrence.Daily,
        Recurrence.Weekly,
        Recurrence.Monthly,
        Recurrence.Yearly
    )
    val state by vm.uiState.collectAsState()
    var  reccurenceMenuOpened by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("Expenses") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                )
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "Total for:",
                        style = Typography.bodyMedium,
                    )
                    PickerTrigger(
                        state.recurrence.target ?: Recurrence.None.target,
                        onClick = { reccurenceMenuOpened = !reccurenceMenuOpened },
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    DropdownMenu(expanded = reccurenceMenuOpened,
                        onDismissRequest = { reccurenceMenuOpened = false }) {
                        recurrences.forEach { recurrence ->
                            DropdownMenuItem(text = { Text(recurrence.target) }, onClick = {
                                vm.setRecurrence(recurrence)
                                reccurenceMenuOpened = false
                            })
                        }
                    }
                }
                Row(modifier = Modifier.padding(vertical = 32.dp)) {
                    Text(
                        "$",
                        style = Typography.bodyMedium,
                        color = LabelSecondary,
                        modifier = Modifier.padding(end = 4.dp, top = 4.dp)
                    )
                    Text("${state.sumTotal}", style = Typography.titleLarge)
                }
                ExpensesList(
                    expenses = mockExpenses,
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(
                            rememberScrollState()
                        )
                )
            }
        }
    )
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ExpensesPreview() {
    MoneyTheme {
        Expenses(navController = rememberNavController())
    }
}
