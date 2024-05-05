package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Game : AppCompatActivity() {
//initializing buttons and progress bars
    private lateinit var feedBar: ProgressBar
    private lateinit var cleanBar: ProgressBar
    private lateinit var playBar: ProgressBar

    private var feedProgress = 40
    private var cleanProgress = 50
    private var happyProgress = 30

    private lateinit var feedImage: ImageView
    private lateinit var cleanImage: ImageView
    private lateinit var happyImage: ImageView

    private val handler = Handler()
    private val timerRunnable = object : Runnable {
        override fun run() {
            feedProgress -= 1
            cleanProgress -= 1
            happyProgress -= 1

            feedBar.progress = feedProgress
            cleanBar.progress = cleanProgress
            playBar.progress = happyProgress

            if (feedProgress > 0 && cleanProgress > 0 && happyProgress > 0) {
                handler.postDelayed(this, 850) // Update every second
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        feedBar = findViewById(R.id.feedBar)
        cleanBar = findViewById(R.id.cleanBar)
        playBar = findViewById(R.id.playBar)

        feedProgress = 40 // Example value, set as needed
        cleanProgress = 50 // Example value, set as needed
        happyProgress = 30 // Example value, set as needed

        feedBar.progress = feedProgress
        cleanBar.progress = cleanProgress
        playBar.progress = happyProgress

        // initializing the buttons and images for each buttons
        val feedButton: Button = findViewById(R.id.feedButton)
        val cleanButton: Button = findViewById(R.id.cleanButton)
        val playButton: Button = findViewById(R.id.playButton)
        val imageView2: ImageView = findViewById(R.id.imageView2)
        feedImage = findViewById(R.id.feedImage)
        cleanImage = findViewById(R.id.cleanImage)
        happyImage = findViewById(R.id.happyImage)

        // Start the timer to decrement progress every 10 seconds
        handler.postDelayed(timerRunnable, 850)

        feedButton.setOnClickListener {
            feedProgress += 10 // Example value, adjust as needed
            feedBar.progress = feedProgress
            imageView2.setImageDrawable(feedImage.drawable)
        }

        cleanButton.setOnClickListener {
            cleanProgress += 10 // Example value, adjust as needed
            cleanBar.progress = cleanProgress
            imageView2.setImageDrawable(cleanImage.drawable)
        }

        playButton.setOnClickListener {
            happyProgress += 10 // Example value, adjust as needed
            playBar.progress = happyProgress
            imageView2.setImageDrawable(happyImage.drawable)
        }


        fun onDestroy() {
            super.onDestroy()
            handler.removeCallbacks(timerRunnable) // Remove the timer callback when the activity is destroyed
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}









