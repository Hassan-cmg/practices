package com.example.test.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.test.repositories.MoviesRepositories
import com.example.test.viewModels.MoviesViewModel

class MoviesViewModelFactory(private val moviesRepositories: MoviesRepositories) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            MoviesViewModel(this.moviesRepositories) as T
        } else
            throw IllegalArgumentException("ViewModel Not Found")
    }
}