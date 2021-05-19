package com.example.aprendendo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aprendendo.databinding.ActivityFormCadastroBinding
import com.example.aprendendo.databinding.ActivityFormLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class FormCadastro : AppCompatActivity() {
    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.btCadastrar.setOnClickListener{
            val email = binding.cadastroEmail.text.toString()
            val senha = binding.cadastroSenha.text.toString()
            val msg_erro = binding.erroCad
            if(email.isEmpty() || senha.isEmpty()){
                msg_erro.text = "Preencha todos os campos"
            }
            else{
                CadastrarUsuario()
            }

        }



    }
    private fun CadastrarUsuario(){
        val email = binding.cadastroEmail.text.toString()
        val senha = binding.cadastroSenha.text.toString()
        val msg_erro = binding.erroCad
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener{
            if(it.isSuccessful){
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                binding.cadastroEmail.setText("")
                binding.cadastroSenha.setText("")
                msg_erro.text = ""

            }
        }.addOnFailureListener{
            when(it){
                is FirebaseAuthWeakPasswordException-> msg_erro.text = "Digite uma senha com no minimo 6 caracteres"
                is FirebaseAuthUserCollisionException->msg_erro.text = "Esta conta ja foi cadastrada"
                is FirebaseNetworkException->msg_erro.text = "Sem conexão com a internet"
                else -> msg_erro.text = "Erro ao cadastrar usuário!"
            }

        }


    }

}