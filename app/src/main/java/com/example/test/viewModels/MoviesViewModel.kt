package com.example.test.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.models.MoviesModel
import com.example.test.network.APIClient
import com.example.test.network.APIinterface
import com.example.test.repositories.MoviesRepositories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MoviesViewModel(private val moviesRepositories: MoviesRepositories) : ViewModel() {


    val sampletext = MutableLiveData<String>()

    val moviesList = MutableLiveData<List<MoviesModel>>()
    val errorMsg = MutableLiveData<String>()

    fun getAllMovies() {
        //APIClient.getClient().create(APIinterface::class.java)
        val call: Call<List<MoviesModel>> = moviesRepositories.getMovies()

        call.enqueue(object : Callback<List<MoviesModel>> {
            override fun onResponse(call: Call<List<MoviesModel>>, response: Response<List<MoviesModel>>) {
                moviesList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<MoviesModel>>, t: Throwable) {
                errorMsg.postValue(t.message)
            }

        })

    }


}