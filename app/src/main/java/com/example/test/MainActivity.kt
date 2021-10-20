package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.test.adapters.MoviesAdapter
import com.example.test.databinding.ActivityMainBinding
import com.example.test.factories.MoviesViewModelFactory
import com.example.test.network.APIClient
import com.example.test.network.APIinterface
import com.example.test.repositories.MoviesRepositories
import com.example.test.viewModels.MoviesViewModel

//2-way data binding
//https://www.youtube.com/watch?v=TVlpENKIg2A
//https://appdevnotes.com/android-two-way-data-binding-tutorial/

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    // private lateinit var recyclerview: RecyclerView

    private val TAG = "MainActivity"

    lateinit var viewModel: MoviesViewModel


    val adapter = MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        viewModel = ViewModelProvider(
            this,
            MoviesViewModelFactory(
                MoviesRepositories(
                    APIClient.getClient().create(APIinterface::class.java)
                )
            )
        ).get(MoviesViewModel::class.java)

        binding.vm = viewModel
        binding.lifecycleOwner = this

        // recyclerview = findViewById(R.id.recyclerview)//before data binding
        binding.recyclerview.adapter = adapter

        viewModel.moviesList.observe(this, Observer {
            adapter.setMovieList(it)
        })


        viewModel.errorMsg.observe(this, Observer {

        })
        viewModel.getAllMovies()

    }
}