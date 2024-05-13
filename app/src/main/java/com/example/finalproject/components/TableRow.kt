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

@Composable
fun TableRow(
    label: String? = null,
    hasArrow: Boolean = false,
    isDestructive:Boolean = false,
    detailContent:(@Composable RowScope.() -> Unit)? = null,
    content: (@Composable RowScope.() -> Unit)? = null
) {
    val textColor = if (isDestructive) Destructive else TextPrimary

    Row(
    modifier = Modifier.fillMaxSize(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
    ){
     if(content != null){
        content()
     }
        if(hasArrow){
    Icon(
        painterResource(id = R.drawable.btn_right),
        contentDescription = "Right Arrow",
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
    )
        }
        if(detailContent != null){
            detailContent()
        }
    }
}
