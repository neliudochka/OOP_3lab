package com.example.a3lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.a3lab.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var myCanvasView: CanvasView
    private lateinit var binding: ActivityMainBinding
        var objects = mutableListOf<ImageButton>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMyCanvasView()
        initSecondMenu()
    }

    private fun initMyCanvasView () {
        myCanvasView = CanvasView(this)
        myCanvasView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        binding.canvasLayout.addView(myCanvasView)
    }

    private fun initSecondMenu() {
        objects = mutableListOf<ImageButton>(
            binding.toolbarPoint,
            binding.toolbarLine,
            binding.toolbarRect,
            binding.toolbarEllipse
        )

        objects.forEach {
            it.setOnClickListener {
                setListener(it.tag.toString())
            }
        }

    }

    private fun pressedButton (button: ImageButton, objects: MutableList<ImageButton>) {
        val pressedButtonColor = ContextCompat.getColor(this, R.color.pressedButton)
        val normButtonColor = ContextCompat.getColor(this, R.color.unpressedButton)

        objects.forEach {
            it.setBackgroundColor(normButtonColor)
        }

        button.setBackgroundColor(pressedButtonColor)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val newTitle = item.title
        return setListener(newTitle)
     }

    private fun setListener (newTitle: CharSequence): Boolean {
        when(newTitle) {
            getString(R.string.point) -> {
                setTitle(newTitle)
                myCanvasView.startPointEditor()
                pressedButton(objects[0], objects)
            }
            getString(R.string.line) -> {
                setTitle(newTitle)
                myCanvasView.startLineEditor()
                pressedButton(objects[1], objects)
            }
            getString(R.string.rect) -> {
                setTitle(newTitle)
                myCanvasView.startRectEditor()
                pressedButton(objects[2], objects)
            }
            getString(R.string.ellipse) -> {
                setTitle(newTitle)
                myCanvasView.startEllipseEditor()
                pressedButton(objects[3], objects)
            }
        }
        return true
    }
}