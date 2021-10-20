package com.example.test.repositories

import com.example.test.network.APIinterface

class MoviesRepositories (private val apIinterface: APIinterface) {

    fun getMovies() = apIinterface.getMoviesList()

}