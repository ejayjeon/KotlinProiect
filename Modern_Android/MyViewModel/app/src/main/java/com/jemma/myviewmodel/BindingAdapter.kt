package com.jemma.myviewmodel

import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

//@BindingAdapter("app.progressScaled")
//fun setProgress(progressBar: ProgressBar, counter: Int, max: Int) {
//    // 프로그래스바의 진행도를 max까지만 하겠다
//    progressBar.progress = (counter * 2).coerceAtMost(max)
//}

@BindingAdapter("app:progressScaled")
fun setProgress(progressBar: ProgressBar, counter: Int, max: Int) {
    progressBar.progress = (counter * 2).coerceAtMost(max)
}