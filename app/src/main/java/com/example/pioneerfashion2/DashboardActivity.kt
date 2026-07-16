package com.example.pioneerfashion2

import android.content.Context
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Find the textview by use of the ID
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextview)

        //Access the shared prefrences file as used in the API helper
        val prefs = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        //Fetch the usenrname (Incase there is no username,just use 'user' as the default username)
        val username = prefs.getString("username", "user")

        //Bind the name to the textview
        welcomeTextView.text = "Welcome $username"

        //Find the progress bar and the recycler bin by the use of their ids
        val progressBar = findViewById<ProgressBar>(R.id.progressbar)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        //Specify the API endpoint
        val api = "https://tikwet.alwaysdata.net/api/getproducts"

        //import the helper class
        val helper = ApiHelper(applicationContext)

        //inside of the helper class, access the loadproducts function
        helper.loadProducts(api, recyclerview, progressBar)
    }
}