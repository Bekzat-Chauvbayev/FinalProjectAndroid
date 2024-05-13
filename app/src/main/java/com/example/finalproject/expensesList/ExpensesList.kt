package com.example.finalproject.expensesList

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalproject.components.ExpensesDayGroup
import com.example.finalproject.mock.mockExpenses
import com.example.finalproject.models.DayExpenses
import com.example.finalproject.models.Expense
import com.example.finalproject.models.groupedByDay
import com.example.finalproject.ui.theme.MoneyTheme

@Composable
fun ExpensesList(expenses: List<Expense> , modifier : Modifier = Modifier){
    val groupedExpenses = expenses.groupedByDay()

    Column(modifier = modifier) {
    groupedExpenses.keys.forEach{
        date-> if(groupedExpenses[date]!=null){
            ExpensesDayGroup(date = date , dayExpenses = groupedExpenses[date]!! , modifier =Modifier.padding(top = 24.dp))
    }
    }

    }
}
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun Preview() {
    MoneyTheme {
        ExpensesList(mockExpenses)
    }
}
