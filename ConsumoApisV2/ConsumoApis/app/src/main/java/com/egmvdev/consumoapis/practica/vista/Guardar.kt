package com.egmvdev.consumoapis.practica.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.egmvdev.consumoapis.databinding.ActivityGuardarBinding
import com.egmvdev.consumoapis.practica.model.Persona
import com.egmvdev.consumoapis.practica.viewmodel.GuardarViewModel
import com.egmvdev.consumoapis.practica.viewmodel.RegistrarViewModel

class Guardar : AppCompatActivity() {
    private lateinit var bind:ActivityGuardarBinding
    private val GuardarViewModel: GuardarViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityGuardarBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val Nombre =intent.getStringExtra("Nombre")?:""
        val Apellido =intent.getStringExtra("Apellido")?:""
        val Edad =intent.getStringExtra("Edad")?:""
        bind.tvNombreG.text = bind.tvNombreG.text.toString() +" "+ Nombre
        bind.tvApellidoG.text = bind.tvApellidoG.text.toString() +" "+ Apellido
        bind.tvEdadG.text = bind.tvEdadG.text.toString() +" "+ Edad
        bind.btnGuardar.setOnClickListener {
            GuardarViewModel.guardarPersona(Persona(Nombre,Appellido,Edad))
            /*var intent: Intent = Intent(this, Registrar::class.java)
            intent.putExtra("persona",Persona(Nombre,Apellido,Edad))
            startActivity(intent)*/
        }
    }
}