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

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //find the text view by use of id
        val signuptxt = findViewById<TextView>(R.id.txtsignin)

        signuptxt.setOnClickListener {
            val newpage = Intent(applicationContext, SignInActivity::class.java)
            startActivity(newpage)
        }
        //find the button and editby use of their id
        val emailEditText = findViewById<EditText>(R.id.email)
        val phoneEditText = findViewById<EditText>(R.id.phone)
        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val signinBtn = findViewById<Button>(R.id.signupbtn)


//        sdpecify what happend
        signinBtn.setOnClickListener {
//            set the API endpoint
            val api = "https://tikwet.alwaysdata.net/api/signin"

            //create requestparams that act as envelope to hold your data
            val data = RequestParams()

            //extract thje data from the edittext and add the same to the RequestParams
            data.put("email", emailEditText.text.toString().trim())
            data.put("password", passwordEditText.text.toString())
            data.put("username", usernameEditText.text.toString())
            data.put("phone", phoneEditText.text.toString())

            //import the API helper class
            val helper = ApiHelper(applicationContext)

            //access the method post_login in the helper class
            helper.post_login(api, data)
        }

    }
}
