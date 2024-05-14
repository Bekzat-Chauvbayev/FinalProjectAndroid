package com.example.finalproject.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalproject.models.Expense
import com.example.finalproject.ui.theme.LabelSecondary
import com.example.finalproject.ui.theme.Typography
import java.text.DecimalFormat
import java.time.format.DateTimeFormatter

@Composable
fun ExpenseRow(expense: Expense, modifier: Modifier = Modifier){
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =  Arrangement.SpaceBetween
        ) {
            Text(expense.note ?: expense.category!!.name,
                style = Typography.headlineMedium)
            Text(
                "USD ${DecimalFormat("0.#").format(expense.amount)}",
                style = Typography.headlineMedium)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryBadge(category = expense.category!!)
            Text(expense.date.format(DateTimeFormatter.ofPattern("HH:mm")),
                style = Typography.bodyMedium,
                color = LabelSecondary
                )
        }
    }
}
