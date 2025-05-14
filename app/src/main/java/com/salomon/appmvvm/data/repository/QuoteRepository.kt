package com.salomon.appmvvm.data.repository

import com.salomon.appmvvm.data.model.QuoteModel
import com.salomon.appmvvm.data.model.QuoteProvider
import com.salomon.appmvvm.data.network.QuoteService

class QuoteRepository {
    private val quoteServiceApi = QuoteService()
    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = quoteServiceApi.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}