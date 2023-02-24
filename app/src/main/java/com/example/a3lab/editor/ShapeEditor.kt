package com.example.a3lab.editor

import com.example.a3lab.PaintOptions
import com.example.a3lab.shape.Shape

abstract class ShapeEditor (paintOptions: PaintOptions, val shapes: MutableList<Shape>): Editor() {

    override fun onMouseMove(x: Float, y: Float) {
    }

    override fun onLBDown(x: Float, y: Float) {
    }

    override fun onLBUp() {
    }
}