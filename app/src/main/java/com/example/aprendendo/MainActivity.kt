package com.example.aprendendo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            openLogin()
        },2000)


    }
    private fun openLogin(){
        val itent = Intent(this,FormLogin::class.java)
        startActivity(itent)
        finish()
    }
}