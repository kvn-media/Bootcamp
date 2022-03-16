package com.enigmacamp.excercise

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class autoComplete : AppCompatActivity() {
    var negara = arrayOf(
        "Autria",
        "Australia",
        "Belanda",
        "Belarus",
        "China",
        "Chili",
        "Denmark",
        "Ethiopia",
        "Finlandia",
        "Guatemala",
        "Honduras",
        "India",
        "Indonesia",
        "Irlandia",
        "Jepang",
        "Kamerun",
        "Lithuania"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_dropdown_item_1line, negara)
        val textViewNegara =
            findViewById<View>(R.id.autoCompleteTextViewNegara) as AutoCompleteTextView
        textViewNegara.setText("")
        textViewNegara.threshold = 1
        textViewNegara.setAdapter(adapter)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}