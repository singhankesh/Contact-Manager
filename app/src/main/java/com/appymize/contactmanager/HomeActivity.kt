package com.appymize.contactmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.appymize.contactmanager.databinding.ActivityHomeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class HomeActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeBinding
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnaddContact.setOnClickListener {

            val name = binding.contactName.text.toString()
            val email = binding.contactEmail.text.toString()
            val number = binding.contactNumber.text.toString()

            val contact = Contacts(name, email, number)

            database = FirebaseDatabase.getInstance().getReference("Contacts")
            database.child(number).setValue(contact).addOnSuccessListener {
                Toast.makeText(this,"Contact Saved Successfully",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                Toast.makeText(this,"Please try again",Toast.LENGTH_SHORT).show()

            }

        }


    }
}