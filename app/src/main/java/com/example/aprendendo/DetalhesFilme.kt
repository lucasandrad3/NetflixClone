package com.example.aprendendo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aprendendo.Adapter.FilmesAdapter
import com.example.aprendendo.Model.addFilmes
import com.example.aprendendo.databinding.ActivityDetalhesFilmeBinding
import com.squareup.picasso.Picasso

class DetalhesFilme : AppCompatActivity() {
    private lateinit var binding:ActivityDetalhesFilmeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val toolbar = binding.toolbarDetalhes
        toolbar.setNavigationOnClickListener{
            val intent = Intent(this,ListaFilmes::class.java)
            startActivity(intent)
            finish()
        }

        val imgFilme = "https://firebasestorage.googleapis.com/v0/b/netflix-clone-fec45.appspot.com/o/video.jpg?alt=media&token=17165c88-b22a-452b-8827-d9b32e43f315"
        Picasso.get().load(imgFilme).fit().into(binding.capa)

        binding.play.setOnClickListener{
            val intent = Intent(this,Filme::class.java)
            startActivity(intent)
        }

        val recicle = binding.recycleMaisFilmes
        recicle.adapter = FilmesAdapter(addFilmes())
        recicle.layoutManager = GridLayoutManager(applicationContext,3)


    }

}
