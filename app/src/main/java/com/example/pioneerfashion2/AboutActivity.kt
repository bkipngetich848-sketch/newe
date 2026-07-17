package com.example.pioneerfashion2

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class AboutActivity : AppCompatActivity() {

    //declare a tts variable
    lateinit var tts: TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //find the text view and button
        val textView = findViewById<TextView>(R.id.textview)
        val speakButton = findViewById<Button>(R.id.speakButton)
        //create a TTs object check if it avalaible and set a languafe
                tts = TextToSpeech(this){
            tts.language = Locale.US
    }//end
        //set button listener
        speakButton.setOnClickListener{
            val text = textView.text.toString()//get text from text view
            //ask ttts to speak mthe text from textview above
            tts.speak(text, TextToSpeech.QUEUE_FLUSH,null,null,)
        }//end
}//end

    //stop the tts from speakng when app is closed/destroyed/killed
    override fun onDestroy() {
        tts.stop()//stops tts
        tts.shutdown()
        super.onDestroy()
    }
}