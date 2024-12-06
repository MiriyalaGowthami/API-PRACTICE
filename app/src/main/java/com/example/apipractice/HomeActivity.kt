package com.example.apipractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apipractice.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        binding.greetingTextView.text = "Hello, $name!"
        binding.emailTextView.text = "Your email is $email"
    }
}