package com.jemma.booksearch.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jemma.booksearch.R
import com.jemma.booksearch.data.repository.BookSearchRepositoryImpl
import com.jemma.booksearch.databinding.ActivityMainBinding
import com.jemma.booksearch.ui.viewmodel.BookSearchViewModel
import com.jemma.booksearch.ui.viewmodel.BookSearchViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    // 1. ViewBinding 설정
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var bookSearchViewModel: BookSearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Bottom Nav
        setBottomNavigationView()

        // 7. 앱이 처음 실행되었을 경우에만, 화면에 Search Fragment 실행
        // 앱이 처음으로 실행되었는지 여부는, saveInstanceState의 존재 여부로 판단
        if (savedInstanceState == null) {
            binding.bottomNav.selectedItemId = R.id.fragment_search
        }

        val bookSearchRepository = BookSearchRepositoryImpl()
        val factory = BookSearchViewModelProviderFactory(bookSearchRepository, this)
        bookSearchViewModel = ViewModelProvider(this, factory)[BookSearchViewModel::class.java]
    }

    // 6. Bottom Nav 구성
    private fun setBottomNavigationView() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, SearchFragment())
                        .commit()
                    true
                }
                R.id.fragment_favorite -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, FavoriteFragment())
                        .commit()
                    true
                }
                R.id.fragment_setting -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, SettingFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}