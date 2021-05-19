package com.example.aprendendo.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendendo.Model.Filmes
import com.example.aprendendo.databinding.ListaFilmesBinding

class FilmesAdapter(val filmes:MutableList<Filmes>):RecyclerView.Adapter<FilmesAdapter.FilmesViewHolder>(){

    inner class FilmesViewHolder(val binding: ListaFilmesBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {//layout a ser renderizado
        val binding = ListaFilmesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FilmesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {//pisição dos itens da lista
        with(holder){
            with(filmes[position]){
                binding.capaFilme.setImageResource(capaFilmes)
            }
        }
    }

    override fun getItemCount() = filmes.size // quantidade de itens, deixamos assim de maneira dinamica
}
