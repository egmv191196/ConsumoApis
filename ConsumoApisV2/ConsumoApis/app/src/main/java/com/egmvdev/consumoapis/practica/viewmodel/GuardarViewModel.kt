package com.egmvdev.consumoapis.practica.viewmodel

import androidx.appcompat.app.AppCompatActivity.*
import androidx.lifecycle.MutableLiveData
import com.egmvdev.consumoapis.practica.model.Persona
import com.egmvdev.consumoapis.practica.vista.Guardar

class GuardarViewModel {
    var guardarContext: Guardar = Guardar()
    val persona = MutableLiveData<Persona>()
    val sharPref = guardarContext.getSharedPreferences("PrefenciasCompartidas", MODE_PRIVATE)

    fun obtenerPersona(){
        val nombre = sharPref.getString("Nombre", "")
        val apellido = sharPref.getString("Apellido", "")
        val edad = sharPref.getString("Edad", "")
        persona.postValue(Persona(nombre?:"",apellido?:"",edad?:""))
    }
    fun guardarPersona(perso:Persona){
        sharPref.edit()
            .putString("Nombre",perso.nombre)
            .putString("Apellido",perso.apellido)
            .putString("Edad",perso.edad)
            .commit()

    }
}