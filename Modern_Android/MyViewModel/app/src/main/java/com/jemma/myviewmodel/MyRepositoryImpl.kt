package com.jemma.myviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// 정의한 Repository를 실구현할 class
class MyRepositoryImpl(counter: Int) : MyRepository {
    // 이 부분은 실제로 room이나 retrofit에서 받아오게 함
    private val liveCounter = MutableLiveData<Int>(counter)

    override fun getCounter(): LiveData<Int> {
        // 데이터 레이어에서 받아온 값을 리턴
        return liveCounter
    }

    override fun increaseCounter() {
        liveCounter.value = liveCounter.value?.plus(1)
    }

}