package com.egmvdev.consumoapis.practica.vista

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.egmvdev.consumoapis.databinding.ActivityRegistrarBinding
import com.egmvdev.consumoapis.practica.model.Persona
import com.egmvdev.consumoapis.practica.viewmodel.RegistrarViewModel

class Registrar : AppCompatActivity() {
    var contextOfApplication: Context? = null
    private lateinit var bind:ActivityRegistrarBinding
    private val registrarViewModel: RegistrarViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        contextOfApplication = applicationContext
        super.onCreate(savedInstanceState)
        bind= ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val person1 =intent.getSerializableExtra("persona")?:null
        if(person1!=null){
            var lis = person1 as Persona
            registrarViewModel.obtenerPersona(lis)
        }
        registrarViewModel.persona.observe(this, Observer{
            bind.etNombre.setText(it.nombre)
            bind.etApellido.setText(it.apellido)
            bind.etEdad.setText(it.edad)
        })
        bind.btnRegistrar.setOnClickListener {
            var intent: Intent = Intent(this, Guardar::class.java)
            intent.putExtra("Nombre", bind.etNombre.text.toString())
            intent.putExtra("Apellido", bind.etApellido.text.toString())
            intent.putExtra("Edad", bind.etEdad.text.toString())
            startActivity(intent)
        }
    }
}