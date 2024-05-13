package com.example.finalproject.components

import android.text.style.TtsSpan
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.finalproject.R
import androidx.compose.ui.Alignment
import com.example.finalproject.ui.theme.Destructive
import com.example.finalproject.ui.theme.TextPrimary
import com.example.finalproject.ui.theme.Typography
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text

@Composable
fun TableRow(
    label: String,
    modifier: Modifier = Modifier,
    hasArrow: Boolean = false,
    isDestructive:Boolean = false,
    content: (@Composable RowScope.() -> Unit)? = null
) {
    val textColor = if (isDestructive) Destructive else TextPrimary

    Row(
       modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
       horizontalArrangement = Arrangement.SpaceBetween,
       verticalAlignment = Alignment.CenterVertically,
    ){
        Text(text = label, style = Typography.bodyMedium, color = textColor,
    modifier = Modifier.padding(vertical = 10.dp))
        if(hasArrow){
    Icon(
        painterResource(id = R.drawable.btn_right),
        contentDescription = "Right Arrow",
        modifier = Modifier.padding(vertical = 10.dp)
    )
        }
        if(content != null){
            content()
        }
    }
}
