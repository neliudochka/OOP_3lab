package com.example.a3lab

import android.graphics.Color
import android.graphics.Paint

val paintInProgress = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    color = Color.RED
    // Smooths out edges of what is drawn without affecting shape.
    isAntiAlias = true
    // Dithering affects how colors with higher-precision than the device are down-sampled.
    isDither = true
    style = Paint.Style.STROKE // default: FILL
    strokeJoin = Paint.Join.ROUND // default: MITER
    strokeCap = Paint.Cap.ROUND // default: BUTT
    strokeWidth = 10f // default: Hairline-width (really thin)
}

val paintFinal = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    color = Color.BLACK
    // Smooths out edges of what is drawn without affecting shape.
    isAntiAlias = true
    // Dithering affects how colors with higher-precision than the device are down-sampled.
    isDither = true
    style = Paint.Style.STROKE // default: FILL
    strokeJoin = Paint.Join.ROUND // default: MITER
    strokeCap = Paint.Cap.ROUND // default: BUTT
    strokeWidth = 10f // default: Hairline-width (really thin)
}


val paintFillEllipse = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    style = Paint.Style.FILL
    color = Color.rgb(30,144,255)
    strokeWidth = 8f
}

val paintPoint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    color = Color.BLACK
    style = Paint.Style.FILL_AND_STROKE
    strokeWidth = 10f
}

object PaintOptions {
    val inProgress: Paint = paintInProgress
    val final: Paint = paintFinal
    val fillEllipse: Paint = paintFillEllipse
    val point: Paint = paintPoint
}

