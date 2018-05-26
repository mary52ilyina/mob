package io.labs.lab3

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_fragment.*
import java.io.FileNotFoundException

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        setSupportActionBar(toolbar)
        var message = "No data"
        try {
            applicationContext.openFileInput("quest.txt").use {
                val data = it.readBytes()
                if (data.isNotEmpty()) {
                    message = data.toString(Charsets.UTF_8)
                }
            }
        } catch (e: FileNotFoundException) {

        }

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }
}
