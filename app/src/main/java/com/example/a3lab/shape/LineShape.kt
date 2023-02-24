package com.example.a3lab.shape

import android.graphics.Canvas
import com.example.a3lab.PaintOptions

class LineShape (val paintOptions: PaintOptions): Shape(paintOptions) {

    override fun show(canvas: Canvas) {
        canvas.drawLine(x1, y1, x2, y2, PaintOptions.inProgress)
    }

    override fun showFinal(canvas: Canvas) {
        canvas.drawLine(x1, y1, x2, y2, PaintOptions.final)
    }

}