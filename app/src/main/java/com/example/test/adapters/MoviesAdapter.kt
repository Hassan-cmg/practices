package com.example.test.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.BR
import com.example.test.R
import com.example.test.databinding.MoviesItemviewBinding
import com.example.test.models.MoviesModel

//used Extension function for showing image using Binding Adapter concept, see below
//https://www.youtube.com/watch?v=XfdaOpQ4UbI&list=PLRKyZvuMYSIO0jLgj8g6sADnD0IBaWaw2&index=9
class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>() {

    var movies = mutableListOf<MoviesModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setMovieList(movies: List<MoviesModel>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
//        val listItem = layoutInflater.inflate(R.layout.movies_itemview, parent, false)
        val moviesItemviewBinding:MoviesItemviewBinding = DataBindingUtil.inflate(layoutInflater,R.layout.movies_itemview, parent, false)
        return MoviesViewHolder(moviesItemviewBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        holder.bindAddress(movie)

    }

    override fun getItemCount(): Int {
        return movies.size
    }


}

class MoviesViewHolder(private val binding: MoviesItemviewBinding) : RecyclerView.ViewHolder(binding.root) {
//    var name = itemView.findViewById<TextView>(R.id.name)
//    var imageview = itemView.findViewById<ImageView>(R.id.imageview)


    @SuppressLint("SetTextI18n")
    fun bindAddress(moviesModel: MoviesModel) {
        binding.setVariable(BR.vm,moviesModel)

//        name.text = moviesModel.name
//        Glide.with(context).load(moviesModel.imageUrl).into(imageview)


    }
}

@BindingAdapter("imageURL")
fun ImageView.bindUrlImage(imageUrl: String?) {
    Glide.with(this.context).load(imageUrl).into(this)
}