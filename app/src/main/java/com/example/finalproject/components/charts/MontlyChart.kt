//package com.example.finalproject.components.charts
//
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.finalproject.models.Expense
//import java.time.LocalDate
//import java.time.YearMonth
//
//@Composable
//fun MonthlyChart(expenses: List<Expense>, month: LocalDate) {
//    val groupedExpenses = expenses.groupedByDayOfMonth()
//    val numberOfDays = YearMonth.of(month.year, month.month).lengthOfMonth()
//
//    BarChart(
//        barChartData = BarChartData(
//            bars = buildList() {
//                for (i in 1..numberOfDays) {
//                    add(BarChartData.Bar(
//                        label = "$i",
//                        value = groupedExpenses[i]?.total?.toFloat()
//                            ?: 0f,
//                        color = Color.White,
//                    ))
//                }
//            }
//        ),
//        labelDrawer = LabelDrawer(recurrence = Recurrence.Monthly, lastDay = numberOfDays),
//        yAxisDrawer = SimpleYAxisDrawer(
//            labelTextColor = LabelSecondary,
//            labelValueFormatter = ::simplifyNumber,
//            labelRatio = 7,
//            labelTextSize = 14.sp
//        ),
//        barDrawer = BarDrawer(recurrence = Recurrence.Monthly),
//        modifier = Modifier
//            .padding(bottom = 20.dp)
//            .fillMaxSize()
//    )
//}
