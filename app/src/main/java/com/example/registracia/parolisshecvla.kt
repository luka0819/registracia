package com.example.registracia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class parolisshecvla : AppCompatActivity() {

    private lateinit var parolisshecvla: EditText
    private lateinit var parolisdayeneba: Button
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parolisshecvla)

        mAuth = FirebaseAuth.getInstance()

        parolisshecvla = findViewById(R.id.emailparolisshecvla)
        parolisdayeneba = findViewById(R.id.parolisdayeneba)

        parolisdayeneba.setOnClickListener {
            val axaliparoli = parolisshecvla.text.toString()
            if(axaliparoli.isEmpty()){
                Toast.makeText(this,"ველი ცარიელია",Toast.LENGTH_LONG).show()

            }else{
                mAuth.currentUser?.updatePassword(axaliparoli)
                    ?.addOnCompleteListener{
                        if(it.isSuccessful){
                            startActivity(Intent(this,person::class.java))
                            finish()

                        }else{
                            Toast.makeText(this,"დაფიქსირდა შეცდომა",Toast.LENGTH_LONG).show()
                        }
                    }
            }

        }


    }
}