//package com.example.finalproject.components.charts
//
//import androidx.compose.ui.geometry.Rect
//import androidx.compose.ui.graphics.Canvas
//import androidx.compose.ui.graphics.drawscope.DrawScope
//import androidx.compose.ui.graphics.nativeCanvas
//import com.github.tehras.charts.piechart.utils.toLegacyInt
//import com.example.finalproject.ui.theme.LabelSecondary
//class LabelDrawer: {
//    private val piant = android.graphics.Paint().apply {
//        this.textAlign = android.graphics.Paint.Align.CENTER
//        this.color = LabelSecondary.toLegacyInt()
//        this.textSize = 42f
//    }
//     override fun drawLabel(
//         drawScope: DrawScope,
//         canvas: Canvas,
//         label: String,
//         barArea: Rect,
//         xAxisArea: Rect
//     ){
//         canvas.nativeCanvas.drawText(
//             label,
//             barArea.left + 50f,
//             barArea.bottom + 65f,
//             paint
//         )
//     }
//}
