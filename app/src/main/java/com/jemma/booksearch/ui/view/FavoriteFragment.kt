package com.jemma.booksearch.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jemma.booksearch.databinding.FragmentFavoriteBinding

// 2. 각 Fragment에 viewBinding 적용
// Fragment Binding은 필드에서 Binding을 선언하고, CreateView에서 지정해준 다음,
// 필요없을 경우 DestoryView에서 Null처리를 해준다
class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding: FragmentFavoriteBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}