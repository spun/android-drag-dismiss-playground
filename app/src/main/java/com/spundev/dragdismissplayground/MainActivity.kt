package com.spundev.dragdismissplayground

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Open simple ElasticDragDismissFrameLayout example
        findViewById<Button>(R.id.simpleElasticDragButton).setOnClickListener {
            SimpleElasticDragDismissActivity.start(this)
        }

        // Open recyclerView with ElasticDragDismissFrameLayout example
        findViewById<Button>(R.id.recyclerElasticDragButton).setOnClickListener {
            RecyclerElasticDragDismissActivity.start(this)
        }
    }
}
