package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivityLoginBinding
import com.example.login.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signupButton.setOnClickListener{
            val name=binding.signupUname.text.toString()
            val email=binding.signupEmail.text.toString()
            val pass=binding.signupPass.text.toString()
            val cpass=binding.signupCpass.text.toString()

            if (name.isNotEmpty()  && email.isNotEmpty() && pass.isNotEmpty() && cpass.isNotEmpty()){
                if(pass == cpass){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent=Intent(this,LoginActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,"Enter correct email",Toast.LENGTH_SHORT).show()
                        }
                    }
                }else {
                    Toast.makeText(this,"Password dose not matched",Toast.LENGTH_SHORT).show()
                }


            }else {
                Toast.makeText(this,"Field all deatils",Toast.LENGTH_SHORT).show()
            }


        }
        binding.signupText.setOnClickListener {
            val signupIntent= Intent(this,LoginActivity::class.java)
            startActivity(signupIntent)
        }

    }
}