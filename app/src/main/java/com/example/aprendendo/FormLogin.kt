package com.example.aprendendo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aprendendo.databinding.ActivityFormLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class FormLogin : AppCompatActivity() {
    private lateinit var binding: ActivityFormLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        verficarUserLogado()
        supportActionBar!!.hide()

        binding.txtInscrevaSe.setOnClickListener{
            OpenCad()
        }
        binding.btEntrar.setOnClickListener{
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()
            val text_erro = binding.editErro

            if(email.isEmpty() || senha.isEmpty()){
                text_erro.text = "Preencha Todos os campos"
            }else{
                AutenticarUsuario()
            }
        }
    }
    private fun AutenticarUsuario(){
        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()
        val text_erro = binding.editErro

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                openListFilmes()
            }
        }.addOnFailureListener {

            when(it){
                is FirebaseAuthInvalidCredentialsException->text_erro.text = "Usuário ou senha incorretos"
                is FirebaseNetworkException->text_erro.text="Sem conexao com a internet"
                else-> text_erro.text="Erro ao logar usuário"
            }

        }


    }

    private fun verficarUserLogado(){
        val logado = FirebaseAuth.getInstance().currentUser
        if(logado != null){
            openListFilmes()
        }
    }

    private fun openListFilmes(){
        val itent = Intent(this,ListaFilmes::class.java)
        startActivity(itent)
        finish()
    }

    private fun OpenCad(){
        val itent = Intent(this,FormCadastro::class.java)
        startActivity(itent)

    }
}