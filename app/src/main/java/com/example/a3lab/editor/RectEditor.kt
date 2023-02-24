package com.example.a3lab.editor

import com.example.a3lab.PaintOptions
import com.example.a3lab.shape.RectShape
import com.example.a3lab.shape.Shape
import com.example.a3lab.shape.ShapeAdder

class RectEditor (val paintOptions: PaintOptions, shapes: MutableList<Shape>) : ShapeEditor(paintOptions, shapes) {
    var rectShape: RectShape = RectShape(paintOptions)

    override fun onLBDown(x: Float, y: Float) {
        rectShape = RectShape(paintOptions)
        rectShape.setStartCoords(x, y)
    }

    override fun onLBUp() {
        rectShape.setFinishedFlag()
        ShapeAdder.addShape(rectShape, shapes)
    }


    override fun onMouseMove(x: Float, y: Float) {
        if (shapes.contains(rectShape))
            shapes.removeAt(shapes.lastIndex)

        rectShape.setEndCoords(x, y)
        ShapeAdder.addShape(rectShape, shapes)
    }

}