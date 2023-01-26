package com.jemma.myviewmodel

import androidx.lifecycle.*

// ViewModel 상속
//class MyViewModel : ViewModel() {
//    val counter : Int = 0
//}

class MyViewModel(
    _counter : Int,
    private val repositoryImpl: MyRepositoryImpl,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

//    var counter: Int = _counter

    // livedata 이용
    // 변경 불가능하기 때문에 MutableLiveData
    var liveCounter : MutableLiveData<Int> = MutableLiveData(_counter)

    // transformations livedata
    val modifiedCounter : LiveData<String> = Transformations.map(liveCounter) {
        counter -> "$counter 입니다"
    }

    val counterFromRepository : LiveData<Int> = repositoryImpl.getCounter()

    fun increaseCounter() {
        repositoryImpl.increaseCounter()
    }

    val hasChecked : MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)

    var counter: Int = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: _counter

    fun saveState() {
        savedStateHandle.set(SAVE_STATE_KEY, counter)
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
    }
}


