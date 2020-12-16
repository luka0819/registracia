package com.example.registracia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class registracia : AppCompatActivity() {
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var daregistrireba: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registracia)

        mAuth=FirebaseAuth.getInstance()

        inputEmail = findViewById(R.id.registraciaemail)
        inputPassword = findViewById(R.id.registraciaPassword)
        daregistrireba = findViewById(R.id.daregistrireba)


        daregistrireba.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"ველი ცარიელია",Toast.LENGTH_LONG).show()
            }else{
                mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener{ task ->
                        if (task.isSuccessful){
                            startActivity(Intent(this,MainActivity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this,"შეცდომა!",Toast.LENGTH_LONG).show()
                        }


                    }

            }
        }

    }
}