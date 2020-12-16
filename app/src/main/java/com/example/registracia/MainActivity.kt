package com.example.registracia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var shesvla: Button
    private lateinit var registraciabtn: Button
    private lateinit var parolisagdgena: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        if (mAuth.currentUser != null) {
            startActivity(Intent(this, person::class.java))
            finish()

        }
        setContentView(R.layout.activity_main)


        inputEmail = findViewById(R.id.emailshesvla)
        inputPassword = findViewById(R.id.passwordshesvla)
        shesvla = findViewById(R.id.shesvla)
        registraciabtn = findViewById(R.id.registracia)
        parolisagdgena = findViewById(R.id.parolisagdgena)


        registraciabtn.setOnClickListener {
            startActivity(Intent(this, registracia::class.java))
        }
        parolisagdgena.setOnClickListener {
            startActivity(Intent(this,com.example.registracia.parolisagdgena::class.java))

        }

        shesvla.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "ველი ცარიელია!", Toast.LENGTH_LONG).show()
            } else {
                mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, person::class.java))
                            finish()

                        } else {
                            Toast.makeText(this, "შეცდომა", Toast.LENGTH_LONG).show()


                        }


                    }



            }
        }
    }
}