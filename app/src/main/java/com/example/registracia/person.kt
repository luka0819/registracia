package com.example.registracia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class person : AppCompatActivity() {
    private lateinit var personaluriinformacia: TextView
    private lateinit var parolisshecvla: Button
    private lateinit var gamosvla: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)


        mAuth = FirebaseAuth.getInstance()
        personaluriinformacia = findViewById(R.id.personaluriinformacia)
        parolisshecvla = findViewById(R.id.parolisshecvla)
        gamosvla = findViewById(R.id.gamosvla)

        personaluriinformacia.text = mAuth.currentUser?.uid

        gamosvla.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
            mAuth.signOut()
        }
        parolisshecvla.setOnClickListener{
            startActivity(Intent(this,com.example.registracia.parolisshecvla::class.java))
        }

    }
}