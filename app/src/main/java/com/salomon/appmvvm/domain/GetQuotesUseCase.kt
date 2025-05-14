package com.salomon.appmvvm.domain

import com.salomon.appmvvm.data.model.QuoteModel
import com.salomon.appmvvm.data.repository.QuoteRepository

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke (): List<QuoteModel>? = repository.getAllQuotes()

}