package com.example.aprendendo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.aprendendo.databinding.ActivityFilmeBinding

class Filme : AppCompatActivity() {
    private lateinit var binding: ActivityFilmeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFilmeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val filmeUrl = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-fec45.appspot.com/o/THE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX.mp4?alt=media&token=4f6a3a94-4de5-48c9-b938-cdae466f75fa")

        val filme = binding.filme
        filme.setMediaController(MediaController(this))
        filme.setVideoURI(filmeUrl)
        filme.requestFocus()
        filme.start()
    }
}