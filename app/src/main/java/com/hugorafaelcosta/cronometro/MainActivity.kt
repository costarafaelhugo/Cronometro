package com.hugorafaelcosta.cronometro

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.hugorafaelcosta.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var running = false
    var pause: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.start.setOnClickListener {
            iniciarCronometro()
        }

        binding.pausa.setOnClickListener {
            pausaCronometro()
        }

        binding.stop.setOnClickListener {
            zerarCronometro()
        }
    }

    private fun zerarCronometro() {
        binding.cronometro.base = SystemClock.elapsedRealtime()
        pause = 0
    }

    private fun pausaCronometro() {
        if (running){
            binding.cronometro.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometro.base -pause
            running = false
        }
    }

    private fun iniciarCronometro() {
        if (!running) {
            binding.cronometro.base = SystemClock.elapsedRealtime()
            binding.cronometro.start()
            running = true
        }
    }
}