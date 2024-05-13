package com.example.finalproject.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalproject.models.Category
import com.example.finalproject.ui.theme.Shapes
import com.example.finalproject.ui.theme.Typography

@Composable
fun CategoryBadge(category: Category, modifier: Modifier = Modifier){
    Surface(
        shape = Shapes.large,
        color = category.color.copy(alpha = 0.25f  ),
        modifier = Modifier
    ) {
        Text(
            category.name,
            color =category.color,
            style = Typography.bodySmall,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
    }
}
