package com.spundev.dragdismissplayground

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spundev.elasticdragdismissframelayout.ElasticDragDismissFrameLayout

class SimpleElasticDragDismissActivity : AppCompatActivity() {

    private lateinit var draggableFrame: ElasticDragDismissFrameLayout
    private lateinit var chromeFader: ElasticDragDismissFrameLayout.SystemChromeFader

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, SimpleElasticDragDismissActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_elastic_drag_dismiss)

        draggableFrame = findViewById(R.id.draggable_frame)
        chromeFader = ElasticDragDismissFrameLayout.SystemChromeFader(this)
    }

    override fun onResume() {
        super.onResume()
        draggableFrame.addListener(chromeFader)
    }

    override fun onPause() {
        draggableFrame.removeListener(chromeFader)
        super.onPause()
    }
}
