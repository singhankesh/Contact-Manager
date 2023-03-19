package com.appymize.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.appymize.contactmanager.databinding.ActivitySignInBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignIn : AppCompatActivity() {

    lateinit var binding : ActivitySignInBinding
    lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.tvSignUp.setOnClickListener {

            val i = Intent(this,SignUp::class.java)
            startActivity(i)
        }

        binding.btnSignIn.setOnClickListener {

            val id = binding.inputId.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(id).get().addOnSuccessListener {

                if (it.exists()){
                    val i = Intent(this,HomeActivity::class.java)
                    startActivity(i)
                    finish()
                }else{
                    Toast.makeText(this,"User Not Found",Toast.LENGTH_SHORT).show()

                }

            }


        }


    }
}