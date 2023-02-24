package com.example.a3lab.shape

import android.graphics.Canvas
import com.example.a3lab.PaintOptions

class PointShape (val paintOptions: PaintOptions): Shape(paintOptions) {

    override fun show(canvas: Canvas) {
        canvas.drawCircle(x1, y1, 10f, PaintOptions.inProgress)
    }

    override fun showFinal(canvas: Canvas) {
        canvas.drawCircle(x1, y1, 10f, PaintOptions.point)
    }

}