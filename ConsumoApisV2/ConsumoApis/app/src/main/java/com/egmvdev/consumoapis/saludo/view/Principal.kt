package com.egmvdev.consumoapis.saludo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.egmvdev.consumoapis.databinding.ActivityPrincipalBinding
import com.egmvdev.consumoapis.saludo.viewmodel.SaludoViewModel

class Principal : AppCompatActivity() {
    private lateinit var bind:ActivityPrincipalBinding
    private val saludoViewModel: SaludoViewModel by viewModels()
    private var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(bind.root)
        saludoViewModel.saludo.observe(this, Observer {
            bind.txtSaludo.text = it.texto
        })
        bind.btnNuevoSaludo.setOnClickListener {
            this.position++
            if (this.position>5)
                this.position = 1
            saludoViewModel.obtenerSaludo(this.position)
        }
    }
}