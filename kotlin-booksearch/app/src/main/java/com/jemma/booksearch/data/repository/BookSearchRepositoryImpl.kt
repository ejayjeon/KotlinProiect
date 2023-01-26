package com.jemma.booksearch.data.repository

import com.jemma.booksearch.data.api.RetrofitInstance.api
import com.jemma.booksearch.data.model.SearchResponse
import retrofit2.Response

class BookSearchRepositoryImpl : BookSearchRepository {
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse> {
        return api.searchBooks(query, sort, page, size)
    }

}