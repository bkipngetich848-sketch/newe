package com.example.pioneerfashion2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Find the text view by use of it's id
        val signuptxt = findViewById<TextView>(R.id.txtsignup)

        signuptxt.setOnClickListener{
            val newpage = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(newpage)
        }
        //Find the button and the edit text by use of their ids
        val emailEditText = findViewById<EditText>(R.id.email)
        val  passwordEditText = findViewById<EditText>(R.id.password)
        val signinBtn = findViewById<Button>(R.id.signinbtn)

        //Specify what happens when the button is clicked
        signinBtn.setOnClickListener {
            //set the API endpoint
            val api = "http://tikwet.alwaysdata.net/api/signin"

            //Create a request params that acts as an envelope to hold your data
            val data = RequestParams()

            //Extract the data from the edit text and add the same to the RequestParams
            data.put("email",emailEditText.text.toString().trim())
            data.put("password",passwordEditText.text.toString())

            //import the API helper class
            val helper = ApiHelper(applicationContext)

            //access the method post_login in the helper class
            helper.post_login(api, data)
        }
    }
}