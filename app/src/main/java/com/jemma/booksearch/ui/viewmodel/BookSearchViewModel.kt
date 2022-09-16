package com.jemma.booksearch.ui.viewmodel

import androidx.lifecycle.*
import com.jemma.booksearch.data.model.SearchResponse
import com.jemma.booksearch.data.repository.BookSearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// ViewModel은 자체로 생성시에 초기값을 전달받지 못하기 때문에 factory가 필요함
class BookSearchViewModel(
    private val bookSearchRepository: BookSearchRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    // API
    private val _searchResult = MutableLiveData<SearchResponse>()
    val searchResult: LiveData<SearchResponse> get() = _searchResult

    // repository의 searchBooks를 코루틴 내부에서 처리하는 함수
    // 코루틴은 백그라운드의 작업을 더 용이하게 수행하게 해주는 기술
    fun searchBooks(query: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = bookSearchRepository.searchBooks(query, "accuracy", 1, 15)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _searchResult.postValue(body) // 반환값
            }
        }
    }

    // SavedState
    var query = String()
        set(value) {
            field = value
            savedStateHandle.set(SAVE_STATE_KEY, value)
        }

    init {
        query = savedStateHandle.get<String>(SAVE_STATE_KEY) ?: ""
    }

    companion object {
        private const val SAVE_STATE_KEY = "query"
    }
}