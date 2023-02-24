package com.example.a3lab

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import com.example.a3lab.editor.*
import com.example.a3lab.shape.Shape

class CanvasView(context: Context) :  View(context) {

    private var motionTouchEventX = 0f
    private var motionTouchEventY = 0f


    override fun onDraw(canvas: Canvas) {

        super.onDraw(canvas)

        for (i in shapes) {
            i.show(canvas)
            if(i.filled) {
                i.fill(canvas)
            }
            if(i.finished) {
                i.showFinal(canvas)
            }
        }

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        motionTouchEventX = event.x
        motionTouchEventY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }
        return true
    }

    private fun touchStart() {
        invalidate()
        currentShapeEditor.onLBDown(motionTouchEventX, motionTouchEventY)
    }

    private fun touchMove() {
        invalidate()
        currentShapeEditor.onMouseMove(motionTouchEventX, motionTouchEventY )
    }


    private fun touchUp() {
        currentShapeEditor.onLBUp()
        invalidate()
    }

    private val shapes = mutableListOf<Shape>()

    private var currentShapeEditor: ShapeEditor = PointEditor(PaintOptions, shapes)

    fun startPointEditor() {
        currentShapeEditor = PointEditor(PaintOptions, shapes)
    }

    fun startLineEditor() {
        currentShapeEditor = LineEditor(PaintOptions, shapes)
    }

    fun startRectEditor() {
        currentShapeEditor = RectEditor(PaintOptions, shapes)
    }

    fun startEllipseEditor() {
        currentShapeEditor = EllipseEditor(PaintOptions, shapes)
    }
}