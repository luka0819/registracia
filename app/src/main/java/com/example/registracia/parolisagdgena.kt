package com.example.registracia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class parolisagdgena : AppCompatActivity() {
    private lateinit var emailparolisagdgena: EditText
    private lateinit var parolismotxovna: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parolisagdgena)

        mAuth = FirebaseAuth.getInstance()

        emailparolisagdgena = findViewById(R.id.emailparolisagdgena)
        parolismotxovna = findViewById(R.id.parolismotxovna)

        parolismotxovna.setOnClickListener {
            val email = emailparolisagdgena.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(this, "ველი ცარიელია", Toast.LENGTH_SHORT).show()


            } else {
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "დაფიქსირდა შეცდომა", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }

}
