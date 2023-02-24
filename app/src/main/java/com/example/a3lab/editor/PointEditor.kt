package com.example.a3lab.editor

import com.example.a3lab.PaintOptions
import com.example.a3lab.shape.PointShape
import com.example.a3lab.shape.Shape
import com.example.a3lab.shape.ShapeAdder

class PointEditor(val paintOptions: PaintOptions, shapes: MutableList<Shape>) : ShapeEditor(paintOptions, shapes) {
    var pointShape: PointShape = PointShape(paintOptions)

    override fun onLBDown(x: Float, y: Float) {
        pointShape = PointShape(paintOptions)
        pointShape.setStartCoords(x, y)
    }

    override fun onLBUp() {
        pointShape.setFinishedFlag()
        ShapeAdder.addShape(pointShape, shapes)
    }

    override fun onMouseMove(x: Float, y: Float) {

    }

}