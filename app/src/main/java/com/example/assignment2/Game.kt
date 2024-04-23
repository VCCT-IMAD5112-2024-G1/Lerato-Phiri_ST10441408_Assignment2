package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        val feedButton: Button = findViewById<Button>(R.id.feedButton)
        val cleanButton: Button = findViewById<Button>(R.id.cleanButton)
        val playButton: Button = findViewById<Button>(R.id.playButton)

        var imageView2 = findViewById<ImageView>(R.id.imageView2)

        feedButton.setOnClickListener{
//            imageView2.setImageResource(R.layout)


            fun startGame(view: View) {
                val intent = Intent(this, Game::class.java)
                startActivity(intent)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}