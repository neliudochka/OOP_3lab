package com.example.a3lab.shape

class ShapeAdder {
    companion object {
        fun addShape(shape: Shape, shapes: MutableList<Shape>) {
            shapes.add(shape)
        }
    }
}