package io.labs.lab2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

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
            val intent = Intent(this, FragmentActivity::class.java).apply {
                putExtra("msg", "Question: " + editQuestion.text + " answer: " + answer)
            }
            startActivity(intent)
        }
    }
}
