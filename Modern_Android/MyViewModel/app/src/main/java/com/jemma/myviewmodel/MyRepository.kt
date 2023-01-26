package com.jemma.myviewmodel

import androidx.lifecycle.LiveData

// repository 구조 - API
interface MyRepository {
    fun getCounter(): LiveData<Int>
    fun increaseCounter()
}