package com.example.finalproject.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalproject.components.charts.WeeklyChart
import com.example.finalproject.expensesList.ExpensesList
import com.example.finalproject.mock.mockExpenses
import com.example.finalproject.ui.theme.LabelSecondary
import com.example.finalproject.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Reports() {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("Reports") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                )
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text("12 Sep - 18 Sep", style = Typography.titleSmall)
                        Row(modifier = Modifier.padding(top = 4.dp)) {
                            Text(
                                "USD",
                                style = Typography.bodyMedium,
                                color = LabelSecondary,
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Text("85", style = Typography.headlineMedium)
                        }
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text("Avg/day", style = Typography.titleSmall)
                        Row(modifier = Modifier.padding(top = 4.dp)) {
                            Text(
                                "USD",
                                style = Typography.bodyMedium,
                                color = LabelSecondary,
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Text("85", style = Typography.headlineMedium)
                        }
                    }
                }

                Box(modifier = Modifier.padding(vertical = 16.dp)) {
                    WeeklyChart(expenses = mockExpenses)
                }

                ExpensesList(
                    expenses = mockExpenses, modifier = Modifier
                        .weight(1f)
                        .verticalScroll(
                            rememberScrollState()
                        )
                )
            }
        }
    )
}