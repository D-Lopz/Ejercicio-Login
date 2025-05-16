package com.salomon.appmvvm.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

import com.salomon.appmvvm.R
import com.salomon.appmvvm.databinding.ActivityLoginBinding
import com.salomon.appmvvm.ui.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel._isLoading.observe(this, {
            binding.progress.isVisible = it

        })

        loginViewModel._message.observe(this, {
          Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

    }
    private fun validateData(): Boolean {
        var isValid = true
        with(binding){
            // validar el null del campo username
            if (tietUsername.text.toString().isBlank()){
                isValid = false
                tietUsername.error = "Campo requerido"
            } else {
                tietUsername.error = null
            }
            // validar el null del campo contraseña
            if (tietPassword.text.toString().isBlank()){
                isValid = false
                tietPassword.error = "Campo requerido"
            } else {
                tietPassword.error = null
            }
        }
        return isValid
    }
}