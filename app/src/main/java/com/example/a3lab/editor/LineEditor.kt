package com.example.a3lab.editor

import com.example.a3lab.PaintOptions
import com.example.a3lab.shape.LineShape
import com.example.a3lab.shape.Shape
import com.example.a3lab.shape.ShapeAdder

class LineEditor (val paintOptions: PaintOptions, shapes: MutableList<Shape>) : ShapeEditor(paintOptions, shapes) {
    var lineShape: LineShape = LineShape(paintOptions)


    override fun onLBDown(x: Float, y: Float) {
        lineShape = LineShape(paintOptions)
        lineShape.setStartCoords(x, y)
    }

    override fun onLBUp() {
        lineShape.setFinishedFlag()
        ShapeAdder.addShape(lineShape, shapes)
    }

    override fun onMouseMove(x: Float, y: Float) {
        if (shapes.contains(lineShape))
            shapes.removeAt(shapes.lastIndex)

        lineShape.setEndCoords(x, y)
        ShapeAdder.addShape(lineShape, shapes)
    }


}