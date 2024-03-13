package com.example.comics.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comics.databinding.ActivityMainBinding
import com.example.comics.data.model.Comic
import com.example.comics.presentation.adapter.ComicAdapter
import com.example.comics.presentation.viewmodel.ComicViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ComicViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        viewModel.getComics()

        setupSwipeRefresh()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.comics.collectLatest { comics ->
                showComicList(comics)
            }
        }

        lifecycleScope.launch {
            viewModel.error.collectLatest { error ->
                if (error != null) {
                    showError()
                }
            }
        }
    }

    private fun showComicList(comics: List<Comic>) {
        with(binding) {
            errorTV.visibility = View.GONE
            listItem.visibility = View.VISIBLE
            listItem.adapter = ComicAdapter(comics)
            listItem.layoutManager = LinearLayoutManager(this@MainActivity)
            swipeRefresh.isRefreshing = false
        }
    }

    private fun showError() {
        with(binding) {
            listItem.visibility = View.GONE
            errorTV.visibility = View.VISIBLE
            swipeRefresh.isRefreshing = false
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            this.binding.swipeRefresh.isRefreshing = true
            viewModel.getComics()
        }
    }
}
