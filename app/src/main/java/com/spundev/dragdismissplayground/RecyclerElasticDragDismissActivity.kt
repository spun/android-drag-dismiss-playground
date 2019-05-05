package com.spundev.dragdismissplayground

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.spundev.elasticdragdismissframelayout.ElasticDragDismissFrameLayout

class RecyclerElasticDragDismissActivity : AppCompatActivity() {

    private lateinit var draggableFrame: ElasticDragDismissFrameLayout
    private lateinit var chromeFader: ElasticDragDismissFrameLayout.SystemChromeFader

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, RecyclerElasticDragDismissActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_elastic_drag_dismiss)

        // ElasticDragDismissFrameLayout
        draggableFrame = findViewById(R.id.draggable_frame)
        chromeFader = ElasticDragDismissFrameLayout.SystemChromeFader(this)

        // RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = RecyclerElasticDragDismissAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Populate list
        val items = listOfItems()
        adapter.submitList(items)
    }

    private fun listOfItems(number: Int = 50): List<String> {
        val newList = mutableListOf<String>()
        for (i in 1..number) {
            newList.add("Item $i")
        }
        return newList
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
