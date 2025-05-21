package com.salomon.appmvvm.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.salomon.appmvvm.data.model.UserProvider
import com.salomon.appmvvm.databinding.ActivityMainBinding
import com.salomon.appmvvm.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //lamado al onCreate del viewmodel
        quoteViewModel.onCreate()

        //Observa si hay cambios en el model
        quoteViewModel.quoteModel.observe(this, Observer{
            binding.tvQuote.text = it?.quote
            binding.tvAutor.text = it?.author

        })
        binding.tvContainer.setOnClickListener{
            quoteViewModel.randomQuote()
        }

        val name = intent.getStringExtra("name")
        val lastname = intent.getStringExtra("lastname")
        val jwt = intent.getStringExtra("jwt")

        binding.tvUser.text = "$name - $lastname - $jwt"

        binding.tvUser.setOnClickListener{
            UserProvider.user = null
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}