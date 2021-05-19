package com.example.aprendendo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aprendendo.Adapter.FilmesAdapter
import com.example.aprendendo.Model.addFilmes
import com.example.aprendendo.OnClick.OnItemClickListener
import com.example.aprendendo.OnClick.addOnItemClickListener
import com.example.aprendendo.databinding.ActivityListaFilmesBinding
import com.google.firebase.auth.FirebaseAuth

class ListaFilmes : AppCompatActivity() {
    private lateinit var biding:ActivityListaFilmesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        biding = ActivityListaFilmesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        val recicleFilmes = biding.recyclerView
        recicleFilmes.adapter = FilmesAdapter(addFilmes())
        recicleFilmes.layoutManager = GridLayoutManager(applicationContext,3)
        recicleFilmes.addOnItemClickListener(object: OnItemClickListener{
            override fun onItemClicked(position: Int, view: View) {
                when(position){
                    0->detalhesFilme()
                }
            }
        })

    }

    private fun detalhesFilme(){
        val itent = Intent(this,DetalhesFilme::class.java)
        startActivity(itent)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal,menu)//emergir o menu da tela menu_principal
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.deslogar -> {
                FirebaseAuth.getInstance().signOut()
                openLogin()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun openLogin(){
        val itent = Intent(this,FormLogin::class.java)
        startActivity(itent)
        finish()
    }
}