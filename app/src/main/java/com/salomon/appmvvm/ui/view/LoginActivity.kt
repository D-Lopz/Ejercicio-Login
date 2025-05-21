package com.salomon.appmvvm.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.salomon.appmvvm.data.model.UserModel
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

        loginViewModel._userModel.observe(this, {
        Toast.makeText(this, "Bienvenido ${it?.name}", Toast.LENGTH_SHORT).show()
            startMain(it)
        })

        binding.btnIniciarSesion.setOnClickListener {
            if (validateData()){
                loginViewModel.login(
                    binding.tietUsername.text.toString(),
                    binding.tietPassword.text.toString()
                )
            }
        }
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

    private fun startMain(userModel: UserModel?){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("username", userModel?.name)
        intent.putExtra("lastname", userModel?.lastName)
        intent.putExtra("jwt", userModel?.jwt)
        startActivity(intent)
        finish()
    }
}