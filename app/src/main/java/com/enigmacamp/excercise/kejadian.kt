package com.enigmacamp.excercise

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity

class kejadian : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kejadian)
        println("Kejadian onCreate() berlangsung")
    }

    public override fun onStart() {
        super.onStart()
        println("Kejadian onStart() berlangsung")
    }

    public override fun onDestroy() {
        super.onDestroy()
        println("Kejadian onDestroy() berlangsung")
    }

    public override fun onPause() {
        super.onPause()
        println("Kejadian onPause() berlangsung")
    }

    public override fun onResume() {
        super.onResume()
        println("Kejadian onResume() berlangsung")
    }

    public override fun onRestart() {
        super.onRestart()
        println("Kejadian onRestart() berlangsung")
    }

    public override fun onStop() {
        super.onStop()
        println("Kejadian onStop() berlangsung")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}