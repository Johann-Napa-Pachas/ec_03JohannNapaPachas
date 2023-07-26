package com.example.ec_appmoviles.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.ec_appmoviles.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        binding.email.editText?.addTextChangedListener { text ->
            val email = text.toString()
            val password = binding.password.editText?.text.toString()
            binding.btnLogin.isEnabled = validateInputs(email, password)
        }

        binding.password.editText?.addTextChangedListener { text ->
            val email = binding.email.editText?.text.toString()
            val password = text.toString()
            binding.btnLogin.isEnabled = validateInputs(email, password)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.email.editText?.text.toString()
            val password = binding.password.editText?.text.toString()

            if (validateInputs(email, password)) {
                if (email == "ejemplo@idat.edu.pe" && password == "123456") {
                    // Iniciar sesión exitoso
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Credenciales incorrectas
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Validación fallida
                Toast.makeText(
                    this,
                    "Por favor, ingrese un correo electrónico válido y una contraseña de al menos 6 caracteres",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun validateInputs(email:String, password:String): Boolean{
        val isEmailOk = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordOk = password.length >= 6
        return isPasswordOk && isEmailOk
    }
}