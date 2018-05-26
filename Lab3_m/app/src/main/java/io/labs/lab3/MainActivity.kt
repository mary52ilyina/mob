package io.labs.lab3

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var cbYes: CheckBox
    private lateinit var btnOk: Button
    private lateinit var btnSave: Button
    private lateinit var cbNo: CheckBox
    private lateinit var editQuestion: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnOk = findViewById(R.id.btnOk)
        btnSave = findViewById(R.id.btnSave)
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
        btnSave.setOnClickListener {
            val fileName = "quest.txt"
            val fileContent = "Question: " + editQuestion.text + " answer: " + answer
            applicationContext.openFileOutput(fileName, Context.MODE_PRIVATE).use {
                it.write(fileContent.toByteArray(Charsets.UTF_8))
            }
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }
        btnOk.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
    }
}
