package com.jemma.booksearch.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jemma.booksearch.data.model.Book
import com.jemma.booksearch.databinding.ItemBookPreviewBinding

// BookData와 xml layout을 연결하는 viewHolder class
class BookSearchViewHolder(
    private val binding: ItemBookPreviewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(book: Book) {
        val author = book.authors.toString().removeSurrounding("[", "]")
        val publisher = book.publisher
        val date = if (book.datetime.isNotEmpty()) book.datetime.substring(0, 10) else ""

        itemView.apply {
            binding.ivArticleImage.load(book.thumbnail)
            binding.tvTitle.text = book.title
            binding.tvAuthor.text = "$author | $publisher"
            binding.tvDatetime.text = date
        }
    }
}