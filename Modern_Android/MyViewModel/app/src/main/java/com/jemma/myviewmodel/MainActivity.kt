package com.jemma.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.jemma.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private val binding: ActivityMainBinding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
    var binding : ActivityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // 뷰모델 적용
//        val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
//        myViewModel.counter = 100
//        binding.textView.text = myViewModel.counter.toString()
//
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//        }



        // by 키워드를 사용
        val myRepositoryImpl = MyRepositoryImpl(100)
        val factory = MyViewModelFactory(10, myRepositoryImpl, this)
//      val myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
        val myViewModel : MyViewModel by viewModels<MyViewModel>() {factory}
        binding.lifecycleOwner = this
        binding.viewModel = myViewModel
//        binding.textView.text = myViewModel.counter.toString()
        binding.btn.setOnClickListener {
//            myViewModel.counter += 1
//            myViewModel.saveState()
//            binding.textView.text = myViewModel.counter.toString()

            // UI 표시 로직을 clickListener 안에 둘 필요가 없게 됨
            //myViewModel.liveCounter.value = myViewModel.liveCounter.value?.plus(1)
            myViewModel.increaseCounter()
        }

        // 라이브데이터 옵저빙
//        myViewModel.liveCounter.observe(this) {
//            counter -> binding.textView.text = counter.toString()
//        }

        // 라이브데이터 값 변경
//        myViewModel.modifiedCounter.observe(this) {
//            counter -> binding.textView.text = counter
//        }
    }


}