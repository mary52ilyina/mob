package io.labs.lab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var cbYes: CheckBox
    private lateinit var btnOk: Button
    private lateinit var cbNo: CheckBox
    private lateinit var editQuestion: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnOk = findViewById(R.id.btnOk)
        cbNo = findViewById(R.id.checkBoxNo)
        cbYes = findViewById(R.id.checkBoxYes)
        editQuestion = findViewById(R.id.questionEdit)
        var answer = "not selected"
        cbYes.setOnClickListener {
            cbNo.isChecked = false
            answer = "yes"
        }
        cbNo.setOnClickListener {
            cbYes.isChecked = false
            answer = "no"
        }
        btnOk.setOnClickListener {
            Toast.makeText(this@MainActivity, "Question:" + editQuestion.text +
                    "Answer: " + answer, Toast.LENGTH_SHORT).show()
        }
    }
}
