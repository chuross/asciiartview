package com.github.chuross.asciiartview

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val asciiArtView = findViewById<AsciiArtView>(R.id.asciiart)
        assets.open("ascii1.txt").bufferedReader().use {
            asciiArtView.draw(it.readText())
        }
        asciiArtView.setTypeface(Typeface.createFromAsset(assets, "mona.ttf"))
    }
}
