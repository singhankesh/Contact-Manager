package com.appymize.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.appymize.contactmanager.databinding.ActivitySignUpBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {

    lateinit var binding : ActivitySignUpBinding
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.tvlogin.setOnClickListener {

            val i = Intent(this,SignIn::class.java)
            startActivity(i)
        }


        binding.btnSignUp.setOnClickListener {

            val name = binding.inputName.text.toString()
            val email = binding.inputEmail.text.toString()
            val id = binding.inputId.text.toString()
            val password = binding.inputPassword.text.toString()

            val user = Users(name,email, id, password)

            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(id).setValue(user).addOnSuccessListener {
                val i = Intent(this,HomeActivity::class.java)
                startActivity(i)
                finish()
            }.addOnFailureListener{
                Toast.makeText(this,"Please Register",Toast.LENGTH_SHORT).show()
            }


        }
    }
}