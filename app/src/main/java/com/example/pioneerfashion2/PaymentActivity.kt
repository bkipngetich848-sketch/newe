package com.example.pioneerfashion2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //retrieve the details of the products from the previous activity
        val name = intent.getStringExtra("product_name")
        val cost = intent.getIntExtra("product_cost",0)

//        get the text view by use of they ids
        val txtName = findViewById<TextView>(R.id.txtProductName)
        val txtCost = findViewById<TextView>(R.id.txtProductCost)

        //update the txtview with the values passed from the previous intent
        txtName.text = name
        txtCost.text = "Ksh $cost"

        //find the button and the phone number editext and by use of their ids
        val btnPay = findViewById<Button>(R.id.pay)
        val edtPhone = findViewById<EditText>(R.id.phone)

        //when the button is click what happend
        btnPay.setOnClickListener{
            //speciffy the Api endpoint
            val api ="https://kbenkamotho.alwaysdata.net/api/mpesa_payment"

            //extract te phone number from edittext
            val phone = edtPhone.text.toString().trim()

            //create a requestParams
            val data = RequestParams()

            //add the phone and the amount
            data.put("amount",cost)
            data.put("phone",phone)

            //import the helper class
            val helper = ApiHelper(applicationContext)

            //access the post function inside of the helper class
            helper.post(api, data)
        }

    }
}