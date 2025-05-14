package com.salomon.appmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
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
    }
}