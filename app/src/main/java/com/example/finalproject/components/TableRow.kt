package com.example.finalproject.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.finalproject.R
import com.example.finalproject.ui.theme.Destructive
import com.example.finalproject.ui.theme.TextPrimary
import com.example.finalproject.ui.theme.Typography
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text

@Composable
fun TableRow(
    label: String,
    onClick: (String) -> Unit,
    hasArrow: Boolean = false,
    isDestructive:Boolean = false
) {
    val textColor = if (isDestructive) Destructive else TextPrimary

    Row(
    modifier = Modifier
        .fillMaxSize()
        .clickable { onClick(label) }
        .padding(horizontal = 16.dp, vertical = 10.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    ){
        Text(text = label, style = Typography.bodyMedium, color = textColor,)
        if(hasArrow){
    Icon(
        painterResource(id = R.drawable.btn_right),
        contentDescription = "Right Arrow",
    )
        }
    }
}
