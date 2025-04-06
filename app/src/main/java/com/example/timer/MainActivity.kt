package com.example.timer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import com.example.timer.R
import kotlin.concurrent.thread
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textTimer: TextView
    private lateinit var btnStart: Button
    private lateinit var btnPause: Button
    private lateinit var btnStop: Button

    var total = 0
    var started=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textTimer = findViewById(R.id.textTimer)
        btnStart = findViewById(R.id.btnStart)
        btnPause = findViewById(R.id.btnPause)
        btnStop = findViewById(R.id.btnStop)

        btnStart.setOnClickListener {
            start()
        }

        btnPause.setOnClickListener {
            pause()
        }

        btnStop.setOnClickListener {
            stop()
        }
    }


    fun start() {
        started = true
        thread(start=true){
            while(started){
                Thread.sleep(1000)
                if(!started) break
                total=total+1
                runOnUiThread{
                    textTimer.text=formatTime(total)
                }
            }
        }

    }

    fun pause() {
        started=false
    }

    fun stop() {
        started=false
        total=0
        textTimer.text="00:00"
    }

    private fun formatTime(time: Int): String {
        val m = String.format("%02d", time/60)
        val s = String.format("%02d", time%60)
        return "$m: $s"
    }
}
