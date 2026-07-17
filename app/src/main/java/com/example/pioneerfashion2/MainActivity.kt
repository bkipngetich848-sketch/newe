package com.example.pioneerfashion2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //find the buttons by use of their Id's
        val signupbtn = findViewById<Button>(R.id.signupbtn)
        val signinbtn = findViewById<Button>(R.id.signinbtn)
        val aboutbtn = findViewById<Button>(R.id.aboutbtn)

        aboutbtn.setOnClickListener {
            val newpage = Intent(applicationContext, AboutActivity::class.java)
            startActivity(newpage)
        }//end intent

        //have the explicit intent
        signinbtn.setOnClickListener {
            val newpage = Intent(applicationContext, SignInActivity::class.java)
            startActivity(newpage)
        }//end intent

        signupbtn.setOnClickListener {
            val newpage = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(newpage)

        }

    }

}